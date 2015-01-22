package com.palm360.airport.redisimpl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.aopalliance.intercept.Invocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.org.rapid_framework.util.ObjectUtils;

import com.palm360.airport.dao.UserInfoDao;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.redis.RedisUtilEx;
import com.palm360.airport.util.AirPortUtil;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.exception.AirportException;
import com.palm360.airport.util.exception.AirportRuntimeException;
import com.palm360.airport.util.stereotype.EntityKeyName;
import com.palm360.airport.util.stereotype.Replication;

/**
 * 主要用于在单独进行增删改查的时候<br />
 * 复制mysql数据到redis中
 * 
 * @author zhangtong
 * 
 */
public class ReplicationDBToRedisAdvice implements MethodInterceptor {// ,Advice{
// ,AfterReturningAdvice {

	private Logger log = Logger.getLogger(getClass());
	@Autowired
	@Qualifier("redisEx")
	private RedisUtilEx redisUtilEx;// = new RedisUtilEx();


	public static void main(String[] agrg) {
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"application-servlet2.xml");
		UserInfoDao dao = (UserInfoDao) c.getBean("UserInfoDao");
		UserInfo ui = new UserInfo();
		ui.setUserID(26);
		dao.getUserInfo(ui);

	}

	/**
	 * 在执行检索之前 search* query* 先检查redis，如果redis中含有数据，则不执行原有DB方法<br/>
	 * 执行方法后, 需要检索 insert* update* delete*,并将数据复制到redis
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {

		String className = invocation.getThis().getClass().getName();//得到daoimpl实现类的名称

		// if (AirPortUtil.isClassNeedCached(className))
		// {//判断当前类是否需要缓存，譬如LogHistory就不需要缓存
		// return invocation.proceed();
		// }

		Object[] args = invocation.getArguments();// 目标方法的参数
		// org.springframework.transaction.interceptor.TransactionInterceptor t;
		// org.springframework.jdbc.datasource.DataSourceTransactionManager tt;
		// org.springframework.transaction.CannotCreateTransactionException xx;
		// t.setTransactionAttributes(transactionAttributes)
		log.info("the method " + invocation.getThis().getClass().getName()
				+ "." + invocation.getMethod() + "() will be executed.");
		Replication replication = null;//新建注解类
		if (invocation.getMethod().isAnnotationPresent(Replication.class)) {//如果注解类存在，得到该注解
			replication = invocation.getMethod().getAnnotation(
					Replication.class);
			log.info("Create replication in invoke method ");
		} else {//如果注解不存在，退出拦截器
			return invocation.proceed();
		}

		boolean isCacheObject = false;
		// boolean isCacheList = false;
		if (replication.isBeforeDB()) {
			if (replication.isQuery()) {
				Object returnObj = doRedis(replication, invocation, args);
				if (returnObj != null) {// 如果缓存有需要的对象，那么就返回缓存中的对象
					return returnObj;
				} else {// 如果缓存中不存在需要的对象，那么标识wannaSave为true，然后进行下一步的保存
					isCacheObject = true;
				}
			} else if (replication.isLoad()) {
				// 判断当前类是否需要缓存，譬如LogHistory就不需要缓存
				if (AirPortUtil.isClassNeedCached(className)) {
					return invocation.proceed();
				}
				Boolean flag = (Boolean) doRedis(replication, invocation, args);
				if (flag) {// 如果缓存有需要的对象，那么就返回缓存中的对象
					return null;
				} else {// 如果缓存中不存在需要的对象，那么标识wannaSave为true，然后进行下一步的保存
				// isCacheList = true;
					isCacheObject = true;
				}
			} else if (replication.isQueryAll()) {//查询缓存得到数据list
				List<Object> list = (List<Object>) doRedis(replication,
						invocation, args);
				if (null != list && list.size() > 0) {
					return list;
				} else {
					// isCacheList = true;
					isCacheObject = true;
				}
			}
		}
		
		Object obj = null;
		// 如果没有检索成功 执行执行原有方法
		if (obj == null) {
			try {
				obj = invocation.proceed();// 执行目标方法
				// 如果是复杂检索，那么保存检索后的list<PK>到redis
				// 保存复杂检索key 为 key_where=objectsFiled:objectValues_orderBy
				if (isCacheObject && obj != null && replication.isQuery()) {
					EntityKeyName ekn = AirPortUtil
							.getEntityKeyNameByClassStr(invocation.getThis()
									.getClass().getName());
					String searchkey = ekn.keyName();
					Object[] params = invocation.getArguments();
					for (Object ob : params) {
						searchkey += redisUtilEx.split + ob.toString();
						
					}
					redisUtilEx.saveSearchList(searchkey, (List) obj); 
					//return redisUtilEx.getSaveSearchList(searchkey, ekn
					//		.keyName(), ekn.entity());
					return obj;
				} else if (isCacheObject && obj != null) {// 对不存在缓存中的对象进行保存
					insertToRedis(replication, invocation, obj, replication
							.isCustomKey());
				}
				// else if (isCacheList && obj != null) {
				// List<Object> list = (List<Object>) obj;
				// insertToRedis(replication, invocation,
				// list,replication.isCustomKey());
				// }
			}catch(SQLException sqle){
				throw new AirportRuntimeException("system.err.unkown",sqle);
			} catch (AirportRuntimeException e) {
				throw e;
			} catch(Exception ex){
				throw new AirportRuntimeException("system.err.unkown",ex);
			}
		}
		// TODO 此处处理 增删改部分代码
		if (replication.isAfterDB()) {
			doRedis(replication, invocation, args);
		}
		log.info("the method " + invocation.getThis().getClass().getName()
				+ "." + invocation.getMethod().getName()
				+ "() has been executed.");
		return obj;
	}

	/**
	 * 进行redis的判断和相关操作
	 * 
	 * @param replication
	 * @param invocation
	 * @param args
	 * @return
	 * @throws AirportException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private Object doRedis(Replication replication,
			MethodInvocation invocation, Object[] args)
			throws AirportException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			IllegalArgumentException, SecurityException,
			InvocationTargetException, NoSuchMethodException {
		String key = replication.key();//得到缓存的key
		if (StringUtils.isBlank(key)) {//判断key是否存在，如果不存在，那么就从daoimpl类上获取key
			key = AirPortUtil.getKeyNameByClassStr(invocation.getThis()
					.getClass().getName());
			log.info("xzl:" + key);
			if (null == key || "".equals(key)) {//如果key还是不存在，抛出异常
				throw new AirportRuntimeException("system.err.param.required");
			}
		}
		if (replication.isInsert()) { // 执行插入redis操作
			Object o = args[0];//获取被拦截方法的参数
			boolean useCustomPK = replication.isCustomKey();//判断是否是自定义pk
			log.info(key + " ----------- " + o.toString() + " ------ "
					+ useCustomPK);
			insertToRedis(replication, invocation, o, useCustomPK);
		} else if (replication.isUpdate()) {// 执行更新redis操作
			Object o = args[0];//获取被拦截方法的参数
			if (ObjectUtils.isNullOrEmptyString(o)) {//判断当前参数是否存在，不存在抛出异常
				throw new AirportRuntimeException("system.err.param.required");
			}
			String pkField = AirPortUtil.getPrimaryKeyFromClass(o.getClass());//得到pk属性
			String primaryKeyValue = AirPortUtil.getProperty(o, pkField)
					.toString();//得到pk的值
			log.info(o + "-----" + key + "-----" + primaryKeyValue);
			modifyToRedis(o, key, primaryKeyValue);
		} else if (replication.isDelete()) {//执行删除某一条在redis中数据
			Object o = args[0];//获取被拦截方法的参数
			if (ObjectUtils.isNullOrEmptyString(o)) {//判断当前参数是否存在，不存在抛出异常
				throw new AirportRuntimeException("system.err.param.required");
			}
			String pkField = AirPortUtil.getPrimaryKeyFromClass(o.getClass());//得到pk属性
			String primaryKeyValue = AirPortUtil.getProperty(o, pkField)
					.toString();//得到pk的值
			deleteFromRedis(key, primaryKeyValue, o.getClass());
		} else if (replication.isQuery()) {//执行查询操作，查询操作分为几种
			Object o = args[0];//获取被拦截方法的参数
			if (ObjectUtils.isNullOrEmptyString(o)) {//判断当前参数是否存在，不存在抛出异常
				throw new AirportRuntimeException("system.err.param.required");
			}

			EntityKeyName ekn = AirPortUtil
					.getEntityKeyNameByClassStr(invocation.getThis().getClass()
							.getName());
			
			// 如果是主键检索
			if (replication.isPkQuery()) {
				String pkField = AirPortUtil.getPrimaryKeyFromClass(o
						.getClass());
				String primaryKeyValue = AirPortUtil.getProperty(o, pkField)
						.toString();
				return getObjectFromRedis(key, o.getClass(), primaryKeyValue,
						false);
			}
			// 如果是聚合索引检索
			else if (replication.isIndexQuery()) {

				String indexValue = AirPortUtil.getProperty(o,
						replication.indexFiled()).toString();
				return getObjectFromRedis(key, o.getClass(), replication
						.indexFiled(), indexValue);
			}
			//检索对应外键的内容
			else if(replication.isQueryFK()){
				Object[] params = invocation.getArguments();
				if(params.length >1) throw new AirportRuntimeException("system.err.param.length");
				if(!(params[0] instanceof AirportQueryP)) throw new AirportRuntimeException("system.err.param.query");
				AirportQueryP ap = (AirportQueryP) params[0];
				double fkValue =Double.parseDouble( AirPortUtil.getProperty(o,replication.fkName()).toString());
				String fkName = replication.fkName();
				if(replication.fkName().indexOf(".")!=-1){
					fkName = replication.fkName().substring(replication.fkName().indexOf(".")+1,replication.fkName().length());
				}
				Object relist =  redisUtilEx.getListByFk(ekn.keyName(),fkName, fkValue, ekn.entity(), ap.getStart(), ap.getSize());
				if(relist==null) return null;
				if(relist instanceof List){
					List olist = (List) relist;
					if(olist.size()==0) return null;
				}
				return relist;
			}
			// 如果是为特殊检索
			Object ret = null;
			
			//查看是否已经保存了缓存,如果已经保存了检索列表，那么直接返回检索列表
			String searchkey = ekn.keyName();
			Object[] params = invocation.getArguments();
			for (Object ob : params) {
				searchkey += redisUtilEx.split + ob.toString();
			}
			ret = redisUtilEx.getSaveSearchList(searchkey, ekn
					.keyName(), ekn.entity());
			if(ret != null)return ret;
			//判断是否已经有实现类的方法，那么采用实现类方法进行查询
			if(null != ekn.replicationClass() && !"".equals(ekn.replicationClass())){
				Object oo = Class.forName(ekn.replicationClass()).newInstance();
				if (oo instanceof BaseRedis) {
					BaseRedis br = (BaseRedis) oo;
					br.setRedisUtilEx(redisUtilEx);
					br.setEntity(ekn.entity());
					br.setKey(ekn.keyName());
				} else {
					throw new AirportRuntimeException(
							"system.err.exntends.baseredis");
				}
				String mname = invocation.getMethod().getName();
				
				if (invocation.getArguments().length > 0) {
					Class[] cs = new Class[invocation.getArguments().length];
					int i = 0;
					for (Object ao : invocation.getArguments()) {
						cs[i] = ao.getClass();
						i++;
					}
					try {
						ret = oo.getClass().getMethod(mname, cs).invoke(oo,
								invocation.getArguments());
					} catch (Exception e) {
						throw new AirportRuntimeException(
								"system.err.redismethod.null",e);
					}
				} else {
					try {
						ret = oo.getClass().getMethod(mname, null).invoke(oo, null);
					} catch (Exception e) {
						throw new AirportRuntimeException(
								"system.err.redismethod.null",e);
					}
				}
			}else {
				//TODO
//				String searchkey = ekn.keyName();
//				Object[] params = invocation.getArguments();
//				for (Object ob : params) {
//					searchkey += redisUtilEx.split + ob.toString();
//				}
//				return redisUtilEx.getSaveSearchList(searchkey, ekn
//						.keyName(), ekn.entity());
			}
			return ret;
		} else if (replication.isLoad()) {//是否是服务器启动时加载所有数据
			String entityName = AirPortUtil.getEntityNameByClassStr(invocation
					.getThis().getClass().getName());
			Class c = Class.forName(entityName);
			Long n = redisUtilEx.getListLength(key, c);// 判断redis中有没有数据
			return n > 0;
		} else if (replication.isQueryAll()) {//查询数据list
			String entityName = AirPortUtil.getEntityNameByClassStr(invocation
					.getThis().getClass().getName());
			Class c = Class.forName(entityName);
			return redisUtilEx.getListByHash(key, c, Integer.parseInt(args[1]
					.toString()), Integer.parseInt(args[0].toString()), null,
					false);
		} else {
			throw new AirportRuntimeException("system.err.param.required");
		}
		return null;
	}

	/**
	 * 将数据存储到redis中
	 */
	private void insertToRedis(Replication replication, Invocation invocation,
			Object list, boolean useCustomPK) throws AirportException,
			ClassNotFoundException {
		String key = AirPortUtil.getKeyNameByClassStr(invocation.getThis()
				.getClass().getName());
		;
		if (StringUtils.isBlank(key)) {
			throw new AirportException(invocation.getClass().getName()
					+ "'s key is null");
		}
		log.info(key + " with customPK = " + useCustomPK
						+ " will be cached...");
		if (list instanceof List)
			redisUtilEx.setListForHash(key, (List) list, false);
		else
			redisUtilEx.addListToHash(key, list, useCustomPK, false);
	}

	// /**
	// * 缓存查找结果
	// * @param replication
	// * @param invocation
	// * @param newObject
	// * @throws AirportException
	// * @throws ClassNotFoundException
	// */
	// private void insertToRedis(Replication replication, Invocation
	// invocation,
	// Object newObject) throws AirportException, ClassNotFoundException {
	// String key = AirPortUtil.getKeyNameByClassStr(invocation.getThis()
	// .getClass().getName());
	// key = AirPortUtil.getKeyNameByClassStr(invocation.getThis().getClass()
	// .getName());
	// // log.info("xzl:" + key);
	// // if (null == key || "".equals(key)) {
	// // return;
	// // }
	// if (StringUtils.isBlank(key)) {
	// throw new AirportException(invocation.getClass().getName()
	// + "'s key is null");
	// }
	// boolean useCustomPK = replication.isCustomKey();
	// log.info(key + " ----------- " + newObject.toString() + " ------ "
	// + useCustomPK + " will be cached...");
	// insertToRedis(key, newObject, useCustomPK);
	// }

	/**
	 * 将传入的对象更新到redis中
	 */
	private void modifyToRedis(Object o, String key, String primaryKeyValue) {
		try {
			redisUtilEx.ModifyObject(o, key, primaryKeyValue);
		} catch (Exception e) {
			throw new AirportRuntimeException();
		}
	}

	/**
	 * 删除指定在redis中的一条数据
	 * 
	 * @param key
	 * @param primaryKeyValue
	 * @param c
	 */
	private void deleteFromRedis(String key, String primaryKeyValue,
			Class<? extends Object> c) {
		redisUtilEx.RemoveFromList(key, primaryKeyValue, c);
	}

	/**
	 * 用聚合索引检索
	 * 
	 * @param key
	 * @param clazz
	 * @param indexFiled
	 * @param indexValue
	 * @return
	 */
	private Object getObjectFromRedis(String key,
			Class<? extends Object> clazz, String indexFiled, String indexValue) {
		return redisUtilEx.getObjectByIndex(key, indexFiled, indexValue, clazz);
	}

	/**
	 * 用主键检索
	 * 
	 * @param key
	 * @param clazz
	 * @param pkValue
	 * @param isNeedFkValue
	 * @return
	 */
	private Object getObjectFromRedis(String key,
			Class<? extends Object> clazz, String pkValue, boolean isNeedFkValue) {
		return redisUtilEx.getObjectByHash(key, clazz, pkValue, false);
	}

}
