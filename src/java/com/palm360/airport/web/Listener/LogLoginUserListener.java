package com.palm360.airport.web.Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import redis.clients.jedis.Jedis;

import com.palm360.airport.redis.RedisUtil;
import com.palm360.airport.redis.RedisUtilEx;

/**
 * 记录session销毁时推出动作
 * @author zhangtong
 *
 */
public class LogLoginUserListener implements HttpSessionListener{

	private static final String CURRENT_USER_COUNT="current_user_count";
	private static final String ALL_USER_COUNT="all_user_count";
	private static final String BEANNAME="";
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO it is nothing to do
		 ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getSession().getServletContext());
		 RedisUtil ru = (RedisUtil) ctx.getBean(BEANNAME);		 
		 Jedis je = ru.getConnection();
		 //记录当前在线用户数量
		 je.incr(CURRENT_USER_COUNT);
		 //记录访问过的总人次
		 je.incr(ALL_USER_COUNT);
		 ru.returnResource(je);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO write user id to redis if user had login
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getSession().getServletContext());
		 RedisUtil ru = (RedisUtil) ctx.getBean(BEANNAME);
		 Jedis je = ru.getConnection();
		 //如果在线 下线,销毁其中一个
		 je.decr(CURRENT_USER_COUNT);
		 //TODO
		 //需要判断如果用户已经登录，那么要修改用户的下线时间
		 ru.returnResource(je);
	}

}
