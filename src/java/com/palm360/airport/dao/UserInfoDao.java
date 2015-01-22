package com.palm360.airport.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.Replication;

@Repository
public interface UserInfoDao extends BaseDao<UserInfo> {

	// @Replication(isQuery=true,key="UserInfo",replicationMethod="searchName",
	// isAfterDB=true)
	public List<UserInfo> queryUserInfo(AirportQueryP qp);

	/**
	 * 根据用户nick name查询
	 * 
	 * @param ui
	 * @return
	 */
	@Replication(isQuery = true, key = "UserInfo", isIndexQuery = true, indexFiled = "nickName", isBeforeDB = true)
	public UserInfo queryUesrInfoByNickName(UserInfo ui);// (String nickName);
	
	/**
	 * 根据用户email查询
	 * 
	 * @param ui
	 * @return
	 */
	@Replication(isQuery = true, key = "UserInfo", isIndexQuery = true, indexFiled = "email", isBeforeDB = true)
	public UserInfo queryUesrInfoByEmail(UserInfo ui);// (String nickName);

	/**
	 * 创建用户信息
	 * 
	 * @param ui
	 * @return
	 */
	@Replication(isInsert = true, key = "UserInfo", isAfterDB = true)
	public UserInfo AddUserInfo(UserInfo userInfo);

	/**
	 * 更新用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	@Replication(isUpdate = true, key = "UserInfo", isAfterDB = true)
	public int updateUserInfo(UserInfo userInfo);

	/**
	 * 删除用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	@Replication(isDelete = true, key = "UserInfo", isAfterDB = true)
	public int deleteUserInfo(UserInfo userInfo);

	/**
	 * 获取某个用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	@Replication(isQuery = true, key = "UserInfo", isPkQuery = true, isBeforeDB = true)
	public UserInfo getUserInfo(UserInfo userInfo); 

	// @Transactional(rollbackFor = AirportRuntimeException.class)
	// public int testTranscation(UserInfo ui);
}
