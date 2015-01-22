package com.palm360.airport.redisimpl;

import org.apache.log4j.Logger;

import com.palm360.airport.redis.RedisUtilEx;

/**
 * 所有对redis操作的基类
 * 
 * @author xzl
 * 
 */
public abstract class BaseRedis {

	protected transient Logger log = Logger.getLogger(getClass());

	public static final double MIN = 0.0099;
	public static final double MAX = 0.0099;
	public static final String split = "_";

	private String key;
	private RedisUtilEx redisUtilEx;
	private Class<?> entity;

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setRedisUtilEx(RedisUtilEx redisUtilEx) {
		this.redisUtilEx = redisUtilEx;
	}

	public RedisUtilEx getRedisUtilEx() {
		return redisUtilEx;
	}

	public void setEntity(Class entity) {
		this.entity = entity;
	}

	public Class getEntity() {
		return entity;
	}
}
