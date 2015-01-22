package com.palm360.airport.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.NullArgumentException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Transaction;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.AirPortUtil;
import com.palm360.airport.util.exception.AirportRuntimeException;
import com.palm360.airport.util.stereotype.EntityKeyName;
import com.palm360.airport.util.stereotype.ForeignKeyList;
import com.palm360.airport.util.stereotype.ForeignKeyObject;
import com.palm360.airport.util.stereotype.SortedSet;

/**
 * 
 * redis储存数据类型 基础类<br />
 * 主要讲实体类保存在redis中，对其进行增删改查<br />
 * 部分功能不如db强大（检索功能目前对于 聚合索引支持好，目前不支持非聚合索引）<br />
 * 
 * @author zhangtong
 * @see RedisUtil
 * @since 1.2 再次优化读取过程，尤其外键读取方式
 */
@Service("redisEx")
public class RedisUtilEx {

	Logger log = Logger.getLogger(getClass());
	private static final String REDIS_SERVER_IP = "192.168.1.160";
	private static final Integer REDIS_SERVER_PORT = 998;
	// private RedisUtil redisUtil = new RedisUtil();
	public static final String split = "_";// "."
	@Autowired
	@Qualifier("redis")
	private RedisUtil edis;

	// TODO need to save another list to sort
	public List<Object> searchListByHash() {
		List<Object> rlist = new ArrayList<Object>();
		// TODO
		return rlist;
	}

	/**
	 * 检索获得类内容 如果没有检索到，那么返回null
	 * 如果已经保存过，那么重新设定过期时间加长一天
	 * @param searchkey
	 *            检索的key名
	 * @param objectKey
	 *            实体类对应的key
	 * @param c
	 * @return
	 * @throws Exception 
	 */
	public List<Object> getSaveSearchList(String searchkey, String objectKey,
			Class<? extends Object> c) {
		List<Object> rlist = new ArrayList<Object>();
		Jedis redis = edis.getConnection();
		if (!redis.exists(searchkey)) {
			edis.returnResource(redis);
			return null;
		}
		//FIXME 如果再次设置超时时间，那么一旦有信息更新，将不能同步
		//redis.expire(searchkey, 24*60*60);
		List<String> list = new ArrayList<String>();
		list.addAll(redis.zrange(searchkey,0,-1));
		//for (String str : list) {
		rlist = this.getListByHash(objectKey, c, list);
			//rlist.add(this.getObjectByHash(objectKey, c, str, false));
		//}
		edis.returnResource(redis);
		return rlist;
	}

	@Deprecated
	public List<Object> getSaveSearchList(String key, String searchKey,
			Class<? extends Object> c, int start, int count) {
		List<Object> rlist = new ArrayList<Object>();
		// TODO
		return rlist;
	}

	/**
	 * 删除检索结果 速度较慢<br />
	 * zrange search_key 0 -1 <br />
	 * {<br />
	 * del key_searchKey_*_*<br />
	 * zrem search_key key_searchKey_*_* <br />
	 * }<br />
	 * 
	 * @param key
	 * @param searchKey
	 */
	public void delSearchKey(String key, String searchKey) {
		Jedis redis = edis.getConnection();// new Jedis(REDIS_SERVER_IP,
		// REDIS_SERVER_PORT);
		String keysearch = "search" + split + "key";
		Set<String> set = redis.zrange(keysearch, 0, -1);
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String obj = it.next();
			if (obj.startsWith(key + split + searchKey)) {
				redis.del(obj);
				redis.zrem(keysearch, obj);
			}
		}
		edis.returnResource(redis);
	}

	/**
	 * 保存检索结果，如果原表发生（增删）变化，检索结果不会产生变化 <br />
	 * 删除原表某一数据后会造成缓存 检索结果 0 10 可能不足10条数据<br />
	 * 此时需要删除检索结果再次保存<br />
	 * 
	 * zincrby search_key 1 key_searchKey_start_count<br />
	 * 
	 * rpush key_searchKey_start_count pkvalue<br />
	 * 
	 * expire key_searchKey_start_count 60*60*24<br />
	 * 
	 * @param key
	 * @param searchKey
	 * @param list
	 * @see delSearchKey
	 * @throws Exception
	 */
	public void saveSearchList(String key, List<Object> list) {
		Jedis redis = edis.getConnection();
		if (list == null) {
			edis.returnResource(redis);
			throw new NullArgumentException("list is null.");
		}
		if (list.size() == 0) {
			edis.returnResource(redis);
			return;
			//throw new IndexOutOfBoundsException("list size if zero.");
		}
		String pk = AirPortUtil.getPrimaryKeyFromClass(list.get(0).getClass());
		String saveKey = key;
		redis.zincrby("search" + split + "key", 1, saveKey);
		Pipeline pe =  redis.pipelined();
		pe.del(saveKey);
		int i=0;
		for (Object o : list) {
			// 将检索出来的主键保存在list中
			// redis.rpush(saveKey, AirPortUtil.getProperty(o, pk).toString());
			//pe.sadd(saveKey, AirPortUtil.getProperty(o, pk).toString());
			pe.zadd(saveKey, i, AirPortUtil.getProperty(o, pk).toString());
			i++;
		}
		// 设置超时时间为1天
		pe.expire(saveKey, 60 * 60 * 24);
		pe.sync();
		edis.returnResource(redis);
	}

	/**
	 * 保存检索结果，如果原表发生（增删）变化，检索结果不会产生变化 <br />
	 * 删除原表某一数据后会造成缓存 检索结果 0 10 可能不足10条数据<br />
	 * 此时需要删除检索结果再次保存<br />
	 * 
	 * zincrby search_key 1 key_searchKey_start_count<br />
	 * 
	 * rpush key_searchKey_start_count pkvalue<br />
	 * 
	 * expire key_searchKey_start_count 60*60*24<br />
	 * 
	 * @param key
	 * @param searchKey
	 * @param list
	 * @see delSearchKey
	 * @throws Exception
	 */
	@Deprecated
	public void saveSearchList(String key, String searchKey, List<Object> list,
			int start, int count) {// throws Exception{
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		if (list == null) {
			edis.returnResource(redis);
			throw new NullArgumentException("list is null.");
		}
		if (list.size() == 0) {
			edis.returnResource(redis);
			throw new IndexOutOfBoundsException("list size if zero.");
		}
		String pk = AirPortUtil.getPrimaryKeyFromClass(list.get(0).getClass());
		String saveKey = key + split + searchKey + split + start + split
				+ count;
		redis.zincrby("search" + split + "key", 1, saveKey);

		for (Object o : list) {
			// 将检索出来的主键保存在list中
			redis.rpush(saveKey, AirPortUtil.getProperty(o, pk).toString());

		}
		// 设置超时时间为1天
		redis.expire(saveKey, 60 * 60 * 24);
		edis.returnResource(redis);
	}

	/**
	 * 支持自定义键修改
	 * 
	 * @param o
	 * @param key
	 * @param pk
	 */
	public void ModifyObjectEx(Object o, String key, String primaryKeyValue) {
		// TODO
	}

	/**
	 * 不能修改主键 <br />
	 * 不支持自定义主键 <br />
	 * could not modify primary key
	 * 
	 * @see RemoveToList
	 * @see addListForHash
	 * @throws Exception
	 */
	public void ModifyObject(Object o, String key, String primaryKeyValue)
			 {
		Class<? extends Object> c = o.getClass();
		// this.RemoveFromList(key, primaryKeyValue, c);
		this.addListToHash(key, o, false, true);
	}

	/**
	 * 从缓存中删除特定的key<br />
	 * lrem key_pk 0 pkvalue<br />
	 * del key_pkvalue <br />
	 * {<br />
	 * del key_fieldName <br />
	 * }<br />
	 * {<br />
	 * zrem key_fkFieldName pkvalue<br />
	 * }
	 * 
	 * @param key
	 * @param primaryKeyValue
	 *            主键key值
	 * @param c
	 */
	public void RemoveFromList(String key, String primaryKeyValue,
			Class<? extends Object> c) {
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		String pk = AirPortUtil.getPrimaryKeyFromClass(c);
		List<String> ilist = AirPortUtil.getDBIndexKeyFromClass(c);
		List<String> fklist = AirPortUtil.getForeignKey(c);
		
		Pipeline pe = redis.pipelined();
		// 在list中删除其中一个项目
		pe.lrem(key + split + pk, 0, primaryKeyValue);

		// 删除索引表
		// hdel key_filedName filedValue
		for (String fi : ilist) {
			// System.out.println(redis.hget(key + split + primaryKeyValue,
			// fi));
			pe.hdel(key + split + fi, redis.hget(key + split
					+ primaryKeyValue, fi));
		}
		// 删除hash表
		pe.del(key + split + primaryKeyValue);

		// 删除外键
		for (String fk : fklist) {
			pe.zrem(key + split + fk, primaryKeyValue);
		}
		pe.sync();
		edis.returnResource(redis);
	}

	/**
	 * 完全匹配检索
	 * 
	 * @param key
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public Object searchByIndex(String key, Class<? extends Object> c,
			String fieldName, String searchKey, boolean fkvalue)
			throws Exception {
		Object o = c.newInstance();
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		String skey = key + split + fieldName;
		String pk = redis.hget(skey, searchKey);
		List<String> flist = AirPortUtil.getClassFieldName(c);
		List<ForeignKeyObject> fklisto = AirPortUtil.getForeignKeyClass(c);
		for (int j = 0; j < flist.size(); j++) {
			//得到外键对应的子项内容
			if(AirPortUtil.isStereotype(c,  flist.get(j), ForeignKeyList.class)){
				ForeignKeyList fl = c.getDeclaredField(flist.get(j)).getAnnotation(ForeignKeyList.class);
				double fkdvalue = Double.parseDouble(AirPortUtil.getProperty(o, fl.fkValue()).toString());
				Object fklist = this.getListByFk(fl.keyName(), fl.fkField(),fkdvalue , fl.fkClass(), 0, -1);
				AirPortUtil.setProperty(o, flist.get(j), fklist);
				continue;
			}
			
			String obj = redis.hget(key + split + pk, flist.get(j));
			AirPortUtil.setProperty(o, flist.get(j), obj);
			// 得到外键对应的子项内容
//			for (ForeignKeyObject fko : fklisto) {
//				String fk = fko.getFkId();
//				// 判断只有循环到外键的时候
//				if (fk.equals(flist.get(j))) {
//					if (fkvalue) {// 是否读取外键子项目
//						String fkKey = fko.getTableName() + split + o;
//						String fkv = redis.hget(fkKey, fko.getFkFieldName());
//						AirPortUtil.setProperty(o, fko.getFieldName(), fkv);
//					}
//					// 无论读取是否,都要跳出
//					// continue;
//					break;
//				}
//			}
		}
		edis.returnResource(redis);
		return o;
	}

	/**
	 * 通过外键 查找相应内容<br />
	 * 
	 * zrangebyscore key_filedName fkvalue fkvalue limit start count<br />
	 * {<br />
	 * hget key_pk filedName<br />
	 * }<br />
	 * 
	 * @param key
	 *            要查询的主key
	 * @param fkName
	 *            外键名称
	 * @param fkvalue
	 *            要检索的外键值（数字类型）
	 * @param c
	 *            要返回的类的类型
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Object> searchByFk(String key, String fkName, int fkvalue,
			Class<? extends Object> c, int start, int count) {
		List<Object> rlist = new ArrayList<Object>();
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		String fkk = key + split + fkName;
		Set<String> setpk = redis.zrangeByScore(fkk, fkvalue, fkvalue, start,
				count);
		edis.returnResource(redis);
		List pklist = new ArrayList();
		pklist.add(setpk);
		return this.getListByHash(key, c, pklist);
//		Iterator<String> it = setpk.iterator();
//		//List<String> flist = AirPortUtil.getClassFieldName(c);
//		while (it.hasNext()) {
//			String pk = it.next();
//			//String findKey = key + split + pk;
//			rlist.add(this.getObjectByHash(key, c, pk, true));
////			Object o = null;
////			try {
////				o = c.newInstance();
////			} catch (Exception e) {
////				edis.returnResource(redis);
////				throw new AirportRuntimeException("system.err.system", e);
////			}
////			if (o != null) {
////				for (String f : flist) {
////					// FIXME fix it to hmget
////					String value = redis.hget(findKey, f);
////					try {
////						AirPortUtil.setProperty(o, f, value);
////					} catch (Exception e) {
////						edis.returnResource(redis);
////						throw new AirportRuntimeException("system.err.system",
////								e);
////					}
////				}
////				rlist.add(o);
////			}
//		}
//		edis.returnResource(redis);
//		return rlist;
	}

	/**
	 * 通过外键获得一个list
	 * @param key
	 * @param fkFiled
	 * @param fkValue
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public Object getListByFk(String key,String fkFiled,double fkValue,Class<? extends Object> clazz,int start,int count){
		
		Jedis redis = edis.getConnection();
		Set<String> set =  redis.zrangeByScore(key+split+fkFiled, fkValue, fkValue,start,count);
		edis.returnResource(redis);
		List<String> pkList = new ArrayList<String>();
		pkList.addAll(set);
		Object ro = this.getListByHash(key, clazz, pkList);
		if(ro == null) return null;
		if(ro instanceof List){
			List list = (List) ro;
			if(list.size()>1) return list;
			if(list.size()==0) return null;
			if(list.size()==1) return list.get(0);
		}
		
		return ro;
		
	}
	/**
	 * 通过聚合索引找到一个对象 <br> 
	 * hexists key_indexFiled indexValue<br> 
	 * hget key_indexFiled<br>
	 * indexValue hget key_pkValue fieldValue<br>
	 * 
	 * @param key
	 * @param indexFiled
	 * @param indexValue
	 * @param clazz
	 * @return
	 */
	public Object getObjectByIndex(String key, String indexFiled,
			String indexValue, Class<? extends Object> clazz) {
		Object object = null;
		Jedis redis = edis.getConnection();
		List<String> fields = AirPortUtil.getCachedClassFieldName(clazz);
		// String pkField = AirPortUtil.getPrimaryKeyFromClass(clazz);
		try {
			String pkValue = redis.hget(key + split + indexFiled, indexValue);
			edis.returnResource(redis);
			return this.getObjectByHash(key, clazz, pkValue, false);
//			boolean isExist = redis.hexists(key + split + indexFiled,
//					indexValue);
//			String pkValue = null;
//			if (isExist) {
//				pkValue = redis.hget(key + split + indexFiled, indexValue);
//				object = clazz.newInstance();
//			} else {
//				edis.returnResource(redis);
//				return object;
//			}
//			String fieldValue = null;
//			List ll = redis.hmget(key + split + pkValue, fields
//					.toArray(new String[] {}));
//			int i = 0;
//			for (String field : fields) {
//				// fieldValue = redis.hget(key + split + pkValue, field);
//				AirPortUtil.setProperty(object, field, ll.get(i));// fieldValue);
//				i++;
//			}
		} catch (Exception e) {
			edis.returnResource(redis);
			throw new AirportRuntimeException("system.err.system");
		}
//		log.info("get object by hash--> " + object);
//		edis.returnResource(redis);
//		return object;
	}
	/**
	 * 从Redis获取某个一系列对象的数据 hexists key_pkvalue pkfiled hget key_pkvalue field
	 * 通过PKlist
	 * 
	 * @param key
	 * @param clazz
	 * @param pkValue
	 * @param fkvalue
	 * @return
	 */
	public List getListByHash(String key, Class<? extends Object> clazz,
			List<String> listpk){
		List rlist = new ArrayList();
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		Pipeline pe = redis.pipelined();
		List<String> fields = AirPortUtil.getClassFieldName(clazz);//.getCachedClassFieldName(clazz);
		String pkField = AirPortUtil.getPrimaryKeyFromClass(clazz);
		Response<List<String>>[] rl = new Response[listpk.size()];
		int index = 0;
		for (String pkValue : listpk) {
			try {

				String fieldValue = null;
				String[] str = new String[fields.size()];
				int i = 0;

				rl[index] = pe.hmget(key + split + pkValue, fields
						.toArray(new String[] {}));
				index++;

			} catch (Exception e) {
				edis.returnResource(redis);
				e.printStackTrace();
				throw new AirportRuntimeException("system.err.system", e);
			}

		}
		pe.sync();

		for (int i = 0; i < rl.length; i++) {
			int j = 0;
			Object o = null;
			try {
				o = clazz.newInstance();
				for (String field : fields) {
					//FIXME 取得外键信息List
					if(AirPortUtil.isStereotype(clazz, field, ForeignKeyList.class)){
						ForeignKeyList fl = clazz.getDeclaredField(field).getAnnotation(ForeignKeyList.class);
						double fkdvalue = Double.parseDouble(AirPortUtil.getProperty(o, fl.fkValue()).toString());
						Object fklist = this.getListByFk(fl.keyName(), fl.fkField(),fkdvalue , fl.fkClass(), 0, -1);
						AirPortUtil.setProperty(o, field, fklist);
						continue;
					}
					AirPortUtil.setProperty(o, field, rl[i].get().get(j));
					j++;
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(o != null)
				rlist.add(o);

		}
		// log.info("get object by hash--> " + object);
		edis.returnResource(redis);
		return rlist;
	}

	/**
	 * 从Redis获取某个对象的数据 hexists key_pkvalue pkfiled hget key_pkvalue field
	 * 
	 * @param key
	 * @param clazz
	 * @param pkValue
	 * @param fkvalue 是否检索外键相关的键值数据
	 * @return
	 */
	public Object getObjectByHash(String key, Class<? extends Object> clazz,
			String pkValue, boolean fkvalue) {
		Object object = null;
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		Pipeline pe = redis.pipelined();
		List<String> fields = AirPortUtil.getClassFieldName(clazz);//AirPortUtil.getCachedClassFieldName(clazz);
		String pkField = AirPortUtil.getPrimaryKeyFromClass(clazz);
		try {

//			boolean isExist = redis.hexists(key + split + pkValue, pkField);
//			if (isExist) {
//				object = clazz.newInstance();
//			} else {
//				edis.returnResource(redis);
//				return object;
//			}
			object = clazz.newInstance();
			String fieldValue = null;
			String[] str = new String[fields.size()];
			int i = 0;

			Response<List<String>> ll = pe.hmget(key + split + pkValue, fields
					.toArray(new String[] {}));
			pe.sync();
			i = 0;
			for (String field : fields) {
				//FIXME 取得外键信息List
				if(AirPortUtil.isStereotype(clazz, field, ForeignKeyList.class)){
					ForeignKeyList fl = clazz.getDeclaredField(field).getAnnotation(ForeignKeyList.class);
					double fkdvalue = Double.parseDouble(AirPortUtil.getProperty(object, fl.fkValue()).toString());
					Object fklist = this.getListByFk(fl.keyName(), fl.fkField(),fkdvalue , fl.fkClass(), 0, -1);
					AirPortUtil.setProperty(object, field, fklist);
					continue;
				}
				AirPortUtil.setProperty(object, field, ll.get().get(i));
				i++;
			}
			//检索外键部分
			

		} catch (Exception e) {
			edis.returnResource(redis);
			e.printStackTrace();
			throw new AirportRuntimeException("system.err.system", e);
		}
		// log.info("get object by hash--> " + object);
		edis.returnResource(redis);
		return object;
	}

	/**
	 * 获得一个表数据长度 如果不是表key，那么自动根据key查找 如果是表key，那么自动组织key
	 * 
	 * @param key
	 *            表名key
	 * @param c
	 * @return
	 */
	public long getListLength(String key, Class c) {
		String pk = AirPortUtil.getPrimaryKeyFromClass(c);
		// TODO to find type of key
		if (null != pk && !"".equals(pk))
			key += split + pk;
		return getKeyLength(key);
	}

	protected long getKeyLength(String key) {
		Jedis redis = edis.getConnection();
		long lengthb = redis.llen(key);
		edis.returnResource(redis);
		return lengthb;
	}

	/**
	 * 
	 * 获得单表（可包含外键）数据<br />
	 * sort User_userID by User_*->password get User_*->password<br />
	 * sort key_pkname by key_*->fieldName get key_*->fieldName get ... limit
	 * start count<br />
	 * 
	 * @param key
	 * @param c
	 * @param start
	 * @param count
	 * @param orderKey
	 * @return
	 * @throws Exception
	 */
	public List<Object> getListByHash(String key, Class<? extends Object> c,
			int start, int count, String orderKey, boolean fkvalue) {// throws
		// Exception{
		List<Object> rlist = new ArrayList<Object>();

		// sort User_userID by User_*->password get User_*->password
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();

		SortingParams sp = new SortingParams();
		if (orderKey != null && !"".equals(orderKey))
			sp.by(key + split + "*->" + orderKey);// User_*->password
		List<String> flist = AirPortUtil.getClassFieldName(c);
		String pk = AirPortUtil.getPrimaryKeyFromClass(c);
		String[] geto = new String[flist.size()];
		int i = 0;
		for (String f : flist) {
			geto[i] = key + split + "*->" + f;// User_*->...
			i++;
		}
		sp.get(geto);
		sp.limit(start, count);

		List<String> templist = redis.sort(key + split + pk, sp);
		// log.info(templist);
		Iterator<String> it = templist.iterator();
		String mainKey = AirPortUtil.getPrimaryKeyFromClass(c);
		// List<String> fklist = AirPortUtil.getForeignKey(c);
//		List<ForeignKeyObject> fklisto = AirPortUtil.getForeignKeyClass(c);
		while (it.hasNext()) {
			Object o = null;
			try {
				o = c.newInstance();
			} catch (Exception e) {
				edis.returnResource(redis);
				throw new AirportRuntimeException("system.err.system", e);
			}
			for (int j = 0; j < flist.size(); j++) {
				Object obj = it.next();// 获得当前内容
				//得到外键对应的子项内容
				try{
					if(AirPortUtil.isStereotype(c, flist.get(j), ForeignKeyList.class)){
						ForeignKeyList fl = c.getDeclaredField(flist.get(j)).getAnnotation(ForeignKeyList.class);
						double fkdvalue = Double.parseDouble(AirPortUtil.getProperty(o, fl.fkValue()).toString());
						Object fklist = this.getListByFk(fl.keyName(), fl.fkField(),fkdvalue , fl.fkClass(), 0, -1);
						AirPortUtil.setProperty(o, flist.get(j), fklist);
						continue;
					}
				}catch(Exception e){
					edis.returnResource(redis);
					throw new AirportRuntimeException("system.err.system", e);
				}
				
				try {
					AirPortUtil.setProperty(o, flist.get(j), obj);
				} catch (Exception e) {
					edis.returnResource(redis);
					throw new AirportRuntimeException("system.err.system", e);
				}
				// 得到外键对应的子项内容
//				for (ForeignKeyObject fko : fklisto) {
//					String fk = fko.getFkId();
//					// 判断只有循环到外键的时候
//					if (fk.equals(flist.get(j))) {
//						if (fkvalue) {// 是否读取外键子项目
//							String fkKey = fko.getTableName() + split + o;
//							String fkv = redis
//									.hget(fkKey, fko.getFkFieldName());
//							try {
//								AirPortUtil.setProperty(o, fk, fkv);
//							} catch (Exception e) {
//								edis.returnResource(redis);
//								throw new AirportRuntimeException(
//										"system.err.system", e);
//							}
//						}
//						// 无论读取是否,都要跳出
//						// continue;
//						break;
//					}
//				}
				// 是否是主键
				if (flist.get(j).equals(mainKey)) {

				}

			}
			rlist.add(o);
		}
		edis.returnResource(redis);
		return rlist;
	}

	/**
	 * 添加类到key
	 * 
	 * @param key
	 * @param o
	 * @param useCustomPK
	 * @param isModify
	 */
	public void addListToHash(String key, Object o, boolean useCustomPK,
			boolean isModify) {// throws
		// Exception{
		this.addListToHash(null, null, key, o, useCustomPK, isModify);
	}

	/**
	 * 判断当前key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean isExists(String key) {
		Jedis redis = edis.getConnection();
		boolean ret = redis.exists(key);
		edis.returnResource(redis);
		return ret;
	}

	/**
	 * 
	 * 保存主键<br />
	 * rpush key_pkname pkvalue (一表一个）<br />
	 * 外键（有重复项）<br />
	 * zadd key_fieldName fieldvalue pkvalue（一表一个）<br />
	 * 聚合索引键（无重复项）<br />
	 * hset key_fieldName fieldvalue pkvalue（一表一个）<br />
	 * 普通键<br />
	 * hset key_pk fieldName fieldValue（一条一个）<br />
	 * 
	 * @param redis
	 * @param key
	 * @param o
	 * @param useCustomPK
	 *            是否自定义主键
	 * @param isModify
	 *            TODO
	 * @throws Exception
	 */
	protected void addListToHash(Jedis redis, Pipeline pe, String key,
			Object o, boolean useCustomPK, boolean isModify) {// throws
																// Exception{
		boolean brredis = false;
		if (redis == null) {
			// redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
			redis = edis.getConnection();
			brredis = true;
		}

		String mainKey = AirPortUtil.getPrimaryKeyFromClass(o.getClass());
		List<String> flist = AirPortUtil.getCachedClassFieldName(o.getClass());
		// Class<? extends Object> type = AirPortUtil.getPrimaryKeyType(o
		// .getClass(), mainKey);
		// boolean isNumber = AirPortUtil.isNumber(type.getName());
		String pk = "";
		// 是否需要自定义 主键
		if (!useCustomPK)
			pk = AirPortUtil.getProperty(o, mainKey).toString();
		else
			pk = redis.incr(key + split + "next" + split + "pk") + "";
		// 聚合索引
		List<String> ilist = AirPortUtil.getDBIndexKeyFromClass(o.getClass());
		// 外键类型
		List<String> forlist = AirPortUtil.getForeignKey(o.getClass());
//		// 外键类 全部修正为NoCatch
//		List<ForeignKeyObject> fclist = AirPortUtil.getForeignKeyClass(o
//				.getClass());
		// 如果是修改，那么首先将聚合索引的 保存到hashmap中
		// key=filedName value=filedValue
		HashMap<String, String> indexValueList = new HashMap<String, String>();
		if (isModify) {
			for (String fi : ilist) {
				// FIXME fix it to hmget
				indexValueList.put(fi, redis.hget(key + split + pk, fi));
			}
		}

		if (pe == null)
			pe = redis.pipelined();
		// rpush key_
		if (!isModify) {
			if (pe != null)
				pe.rpush(key + split + mainKey, pk);
			else
				redis.rpush(key + split + mainKey, pk);
		}

		for (String f : flist) {
			// 需要保存成 SortedSet的進行保存
			if (AirPortUtil.isStereotype(o.getClass(), f, SortedSet.class)) {
				Object fkValue = AirPortUtil.getProperty(o, f);
				if (fkValue != null && !fkValue.equals("")) {
					if (pe == null)
						redis.zadd(key + split + f, Double.parseDouble(fkValue
								.toString()), pk);
					else
						pe.zadd(key + split + f, Double.parseDouble(fkValue
								.toString()), pk);
				}
			}
			// 为了外键方便检索,另存一份sort set
			for (String forl : forlist) {
				if (f.equals(forl)) {// 如果是外键,用sored set保存
					// zadd key_fieldName fk-value pk
					Object fkValue = AirPortUtil.getProperty(o, f);
					if (fkValue != null && !fkValue.equals("")) {
						if (pe == null)
							redis.zadd(key + split + f, Double
									.parseDouble(fkValue.toString()), pk);
						else
							pe.zadd(key + split + f, Double.parseDouble(fkValue
									.toString()), pk);
					}
				}
			}
			// 外键对应的子类型，不保存
//			boolean bcon = false;
//			for (ForeignKeyObject obj : fclist) {
//				if (obj.getFieldName().equals(f)) {
//					bcon = true;
//					break;
//				}
//			}
//			if (bcon)
//				continue;
			// 为了方便检索-单独再次保存聚合索引储存
			for (String fi : ilist) {
				if (f.equals(fi)) {
					// hset key_fieldName value pk
					Object indexValue = AirPortUtil.getProperty(o, fi);
					if (indexValue != null && !indexValue.equals("")) {
						// 如果是修改,那么通过上文找到聚合索引的KV
						// 在此处，直接删除掉
						if (isModify) {
							if (indexValueList != null
									&& indexValueList.containsKey(fi)) {
								// hdel key_filedName filedValue
								if (pe == null)
									redis.hdel(key + split + f, indexValueList
											.get(fi));
								else
									pe.hdel(key + split + f, indexValueList
											.get(fi));
							}
						}
						if (pe == null)
							redis.hset(key + split + f, indexValue.toString(),
									pk);
						else
							pe.hset(key + split + f, indexValue.toString(), pk);

					}
					break;
				}
			}
			// 保存普通Key hset key_pk fieldName fieldValue
			Object fieldValue = AirPortUtil.getProperty(o, f);
			if (fieldValue != null && !fieldValue.equals("")) {
				if (pe == null)
					redis.hset(key + split + pk, f, fieldValue.toString());
				else
					pe.hset(key + split + pk, f, fieldValue.toString());
			}
		}
		
		if (brredis) {
			if (pe != null) {
				pe.sync();
			}
			edis.returnResource(redis);
		}

	}

	/**
	 * 
	 * 保存主键<br />
	 * rpush key_pkname pkvalue (一表一个）<br />
	 * 外键（有重复项）<br />
	 * zadd key_fieldName fieldvalue pkvalue（一表一个）<br />
	 * 聚合索引键（无重复项）<br />
	 * hset key_fieldName fieldvalue pkvalue（一表一个）<br />
	 * 普通键<br />
	 * hset key_pk fieldName fieldValue（一条一个）<br />
	 * 
	 * @param redis
	 * @param key
	 * @param o
	 * @param useCustomPK
	 *            是否自定义主键
	 * @throws Exception
	 */
	public void setListForHash(String key, List<Object> list,
			boolean useCustomPK) {// throws Exception{
		// Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);
		Jedis redis = edis.getConnection();
		// Transaction ts = redis.multi();
		// ts.exec();
		Pipeline pe = null;
		if(!useCustomPK){
			pe = redis.pipelined();
		}
		for (Object o : list) {
			if (useCustomPK)
				this.addListToHash(redis, null, key, o, useCustomPK, false);
			else{
				
				this.addListToHash(redis, pe, key, o,
						useCustomPK, false);
			}
		}
		if(!useCustomPK){
			pe.sync();
		}
		edis.returnResource(redis);
	}
	/**
	 * 通过保存的临时数据进行交集运算（sorted set）
	 * @param keys
	 * @return
	 */
	public Set interStoreForGis(String... keys) {
		Jedis redis = edis.getConnection();
		Pipeline pe = redis.pipelined();
		String tempkey = AirPortUtil.randomString(32);
//		long length = 
		pe.zinterstore(tempkey, keys);
		pe.expire(tempkey, 60 * 1);
//		if (length <= 0) {
//			edis.returnResource(redis);
//			return null;
//		}
		Response<Set<String>> set = pe.zrange(tempkey, 0, -1);
		pe.sync();
		edis.returnResource(redis);
		return set.get();
	}

	/**
	 * 获得gis中的 最大最小的区间并保存成临时数据 临时数据 过期时间为1分钟
	 * 
	 * @param key
	 * @param fieldName
	 * @param min
	 * @param max
	 */
	public String saveSortedSetForGis(String key, String fieldName, double min,
			double max) {
		Jedis redis = edis.getConnection();
		Set<String> set = redis
				.zrangeByScore(key + split + fieldName, min, max);
		Iterator<String> it = set.iterator();
		Pipeline pi = redis.pipelined();
		String temp = AirPortUtil.randomString(16);
		while (it.hasNext()) {
			pi.zadd(key + split + fieldName + temp, 0, it.next());
		}
		pi.expire(key + split + fieldName + temp, 60 * 1);
		pi.sync();
		edis.returnResource(redis);
		return key + split + fieldName + temp;
	}


	public static void main(String[] args) throws Exception {
		Jedis redis = new Jedis(REDIS_SERVER_IP, REDIS_SERVER_PORT);

		String la = "la";
		String lo = "lo";

		// Transaction tc = redis.multi();
		// redis.multi();
		// tc.set("a", "b");
		// tc.set("dsafasd", "12312312");
		// tc.set("aaaa", "ewwe");
		// // tc.discard();
		// tc.exec();
		// List<UserInfo> list = new ArrayList<UserInfo>();
		// UserInfo ui = new UserInfo();
		// ui.setUserID(1);
		// ui.setNickName("test1");
		// ui.setPassword("123456");
		// list.add(ui);
		//		
		// RedisUtilEx rue = new RedisUtilEx();
		// // rue.setList("userinfo", list);
		// rue.setListForHash("User", list, false);
	}

	public void setEdis(RedisUtil edis) {
		this.edis = edis;
	}

	public RedisUtil getEdis() {
		return edis;
	}

}


// public void AddToList(String key,Object t,boolean customPK) throws
// Exception{
// //Jedis redis = redisUtil.getConnection();
// Jedis redis = new Jedis(REDIS_SERVER,REDIS_SERVER_PORT);
// String mainKey = AirPortUtil.getPrimaryKeyFromClass(t.getClass());
// List<String> flist = AirPortUtil.getClassFiledName(t.getClass());
// Class type = AirPortUtil.getPrimaryKeyType(t.getClass(), mainKey);
// boolean isNumber = AirPortUtil.isNumber(type.getName());
// String pk = AirPortUtil.getProperty(t, mainKey).toString();
// if(customPK){
// pk = redis.incr(key+"_customkey")+"";
// }
// redis.rpush(key+"_"+mainKey, pk);
// for(String f:flist){
// redis.set(key+"_"+f+"_"+pk, AirPortUtil.getProperty(t, f).toString());
// }
// List<String> keyName = AirPortUtil.getDBIndexKeyFromClass(t.getClass());
// int i=0;
// for(String str:keyName){
// if(isNumber)
// redis.zadd(key+"_index_"+str,
// Double.parseDouble(AirPortUtil.getProperty(t, mainKey).toString()),
// AirPortUtil.getProperty(t, str).toString());
// else{
// redis.zadd(key+"_index_"+str,
// i,
// AirPortUtil.getProperty(t, str).toString());
// redis.set(key+"_"+str+"_plus_"+ AirPortUtil.getProperty(t,
// str).toString(),
// AirPortUtil.getProperty(t, mainKey).toString());
// }
// i++;
// }
// }

// @Deprecated
// public void DelList(String key,Class c,boolean subValue){
// //Jedis redis = redisUtil.getConnection();
// Jedis redis = new Jedis(REDIS_SERVER,REDIS_SERVER_PORT);
// long length = redis.llen(key);
// if(subValue){
// List<String> list = redis.lrange(key, 0, length);
// List<String> flist = AirPortUtil.getClassFiledName(c);
// for(String str:list){
// //int index = Integer.parseInt(str);
// for(String f:flist){
// redis.del("key"+split+f+split+str);
// }
// }
// }
// //redis.ltrim(key, length+1, length+1);
// redis.del(key);
// redis.del(key+split+"customkey");
// }

// /**
// * 将一个类保存到redis中
// * 保存结构如下
// * 主list： key_主键名称
// * 副键值：
// * key_字段名称_主键值 value:（字段内容）
// * --副键值+保存结构：
// * -- key_字段名称_plus_KeyNamePlus value:（主键内容）
// *
// * rpush tablename_primarykey primarykey
// * zadd tablename_index_indexkey primarykey_value
// *
// * 如果选择使用自定义primarykey
// * incr tablename_customkey 1
// * rpush tablename_primarykey customkey
// * zadd tablename_index_indexkey customkey
// * @param key 要保存的主key（建议使用tablename）
// * @param list 要保存的结构
// * @throws Exception
// */
// public void setList(String key,List list,boolean customPK) throws
// Exception{
//		
// //Jedis redis = redisUtil.getConnection();
// Jedis redis = new Jedis(REDIS_SERVER,REDIS_SERVER_PORT);
//		
// for(Object t:list){
// AddToList(key,t,customPK);
// }
// }

// /**
// * 根据关键key查询
// * 结果返回对应的类list
// *
// * @param <T>
// * @param c
// * @param key
// * @param searchKey
// * @param plus
// * @return
// * @throws Exception
// */
// @Deprecated
// public <T>List<T> searchClassObject(T c,String key,String
// searchKey,boolean plus) throws Exception{
// Jedis redis = new Jedis(REDIS_SERVER,REDIS_SERVER_PORT);
// List<T> rlist = new ArrayList<T>();
// String keys = "";
// if(plus){
//			
// keys = key+"*_plus_*"+searchKey+"*";
// }else{
// keys = key+"*"+searchKey+"*";
// }
// Set set = redis.keys(keys);
// Iterator it = set.iterator();
// while(it.hasNext()){
// //System.out.println(it.next());
// String gKey = it.next().toString();
// T newIn = (T) c.getClass().newInstance();
//			
// String value = redis.get(gKey);
// List<String> flist = AirPortUtil.getClassFiledName(c.getClass());
// String tempKey = key+"_";
// for(String f:flist){
// tempKey = key+"_";
// tempKey += f+"_";
// tempKey += value;
// System.out.println(tempKey);
// String val = redis.get(tempKey);
// AirPortUtil.setProperty(newIn, f, val);
// }
// rlist.add(newIn);
// }
//			
// // }
// // else{
// // keys = key+"*"+searchKey+"*";
// // return this.searchClassObject(c, keys, searchKey);
// //
// // }
// return rlist;
// }
// /**
// * 从redis中读取一个类列表
// * 根据key构成Key_字段名_*获得所有内容
// * @param c 类类型
// * @param key 主key
// * @param orderKey 排序键
// * @param sortOrder 排序方式 0 顺序 1逆序
// * @param start 从多少开始
// * @param count 到多少结束
// * @return 返回整个一个list列表
// * @throws Exception
// */
// @Deprecated
// public List getList(Class c,String key,String orderKey,int sortOrder,int
// start,int count) throws Exception{
//		
// List list = new ArrayList<Object>();
// SortingParams srt = new SortingParams();
// List<String> flist = AirPortUtil.getClassFiledName(c);
// String mainKey = AirPortUtil.getPrimaryKeyFromClass(c);
// if(orderKey == null || "".equals(orderKey)){
// srt.by(mainKey);
// }
// else
// srt.by(orderKey);
// String[] geto = new String[flist.size()];
// int i=0;
// for(String f:flist){
// geto[i] = key+"_"+f+"_*";
// i++;
// }
// if(sortOrder ==0){
// srt.asc();
// }else{
// srt.desc();
// }
// srt.get(geto);
// srt.limit(start, count);
// List<String> templist = redisUtil.getConnection().sort(key+"_"+mainKey,
// srt);
// Iterator it = templist.iterator();
// while(it.hasNext()){
// Object o = c.newInstance();
// for(int j=0;j<flist.size();j++){
// AirPortUtil.setProperty(o,flist.get(j), it.next());
// }
// list.add(o);
// }
// return list;
// }
// /**
// * 获得聚合索引内容(唯一性）
// * @param <T>
// * @param c
// * @param key
// * @param indexKey
// * @param searchKey
// * @return
// */
// @Deprecated
// public <T>List<T> searchClassList(Class c,String key,String indexKey
// ,String searchKey){
// Jedis redis = new Jedis(REDIS_SERVER,REDIS_SERVER_PORT);
// List<T> rlist = new ArrayList<T>();
// double index = -1;
// try{
// index = redis.zscore(key+"_index_"+indexKey, searchKey);
// T newIn = (T) c.newInstance();
// List<String> flist = AirPortUtil.getClassFiledName(c);
// String tempKey = key+"_";
// for(String f:flist){
// tempKey = key+"_";
// tempKey += f+"_";
// tempKey += (int)index;
// System.out.println(tempKey);
// String val = redis.get(tempKey);
// AirPortUtil.setProperty(newIn, f, val);
// }
// rlist.add(newIn);
// }catch(Exception e){
// e.printStackTrace();
// }
// return rlist;
// }
