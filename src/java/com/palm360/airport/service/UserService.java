package com.palm360.airport.service;

import java.util.List;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.exception.AirportRuntimeException;

public interface UserService {
	
	UserInfo login(String email, String password, String loginIp,String uuid,String loginDevice) throws AirportRuntimeException;

	UserInfo register(UserInfo ui) throws AirportRuntimeException;

	boolean deleteUser(int userID) throws AirportRuntimeException;

	boolean modifyUser(UserInfo ui) throws AirportRuntimeException;

	List<UserInfo> queryUser(int start, int count) throws AirportRuntimeException;

	int queryUserCount() throws AirportRuntimeException;
	
	boolean forgotPassword(String email, String uuid) throws AirportRuntimeException;
	
}
