package com.palm360.airport.redis;
/**
 * 记录当前用户登录日志
 * @author zhangtong
 *
 */
public interface LoginLog {
	//TODO 需要修改OBject为对应的实体类
	void addLogin(String key,Object o);
	//TODO 
	void logOut(String key);
	
	void getList(String key);
	
	void removeAt(String key);
	
	int getPrimaryKeyValue(String key);
	
	void incrPrimaryKey(String key);
	
}
