package com.palm360.airport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import sun.rmi.log.LogHandler;

import com.palm360.airport.dao.LoginhistroyDao;
import com.palm360.airport.dao.UserInfoDao;
import com.palm360.airport.dao.UseroprationlogDao;
import com.palm360.airport.dao.impl.LoginhistroyDaoImpl;
import com.palm360.airport.model.Loginhistroy;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.model.Useroprationlog;
import com.palm360.airport.redis.RedisUtil;
import com.palm360.airport.redis.RedisUtilEx;
import com.palm360.airport.util.AirPortUtil;

/**
 * 将redis中的log数据copy到数据库中 每天晚上3点执行
 * 
 * @author zhangtong
 * 
 */
@Service
public class UpdateLogQuartz {

	@Autowired
	@Qualifier("redisEx")
	private RedisUtilEx redis;
//	
//	@Autowired
//	@Qualifier("loginHistroyDao")
//	private LoginhistroyDao loginHistroyDao;
//	
	@Autowired
	@Qualifier("userOprationLogDao")
	private UseroprationlogDao userOprationLogDao; 

	/**
	 * 计划任务，每天凌晨3点的时候更新登录日志
	 * 和操作日志到db
	 */
	@Scheduled(cron = "00 00 03 * * ?")
	protected void job() {
		// TODO Auto-generated method stub
		List<Object> list;// = new ArrayList<Object>();
		int start = 0, count = 10;
		String key = AirPortUtil.getClassEntityKey(LoginhistroyDaoImpl.class);
		list = redis.getListByHash(key, Useroprationlog.class, start, count, "",
				false);
//		for (Object l : list) {
//			if (l instanceof Loginhistroy) {
//				Loginhistroy lh = (Loginhistroy) l;
////				loginHistroyDao.insertDB(lh);
//				redis.RemoveFromList(key, lh.getId() + "", Loginhistroy.class);
//			}
//		}

	}

	public static void main(String[] a) {
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"application-servlet2.xml");
		BeanFactory bf = c.getParentBeanFactory();
		System.out.println(bf.getBean("loginHistroyDao"));
	}

	// public void setRedisUtils(RedisUtilEx redisUtils) {
	// this.redisUtils = redisUtils;
	// }
	//
	// public RedisUtilEx getRedisUtils() {
	// return redisUtils;
	// }
}
