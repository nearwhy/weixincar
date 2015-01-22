package com.palm360.airport.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.UserInfoDao;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.exception.AirportRuntimeException;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("userInfoDao")
@EntityKeyName(entity = UserInfo.class, keyName = "UserInfo",replicationClass="com.palm360.airport.redisimpl.UserInfoRedisImpl")
public class UserInfoDaoImpl extends BaseDaoImpl implements UserInfoDao {

	public UserInfo AddUserInfo(UserInfo ui) {
		Object o = getSqlMapClientTemplate().insert("UserInfo.AddUser", ui);
		ui.setUserID(Integer.parseInt(o.toString()));
		return ui;
	}

	public int deleteUserInfo(UserInfo userInfo) {
		try {
			return getSqlMapClientTemplate().delete("UserInfo.DeleteUserInfo",
					userInfo);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public UserInfo getUserInfo(UserInfo userInfo) {
		try {
			return (UserInfo) getSqlMapClientTemplate().queryForObject(
					"UserInfo.GetUserInfo", userInfo);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public int updateUserInfo(UserInfo userInfo) {
		try {
			return getSqlMapClientTemplate().update("UserInfo.UpdateUserInfo",
					userInfo);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public List queryAll(int size, int page) {
		return super.queryAll("UserInfo.queryAll",
				new AirportQueryP(page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("UserInfo.queryAllCount");
	}

	public List<UserInfo> queryUserInfo(AirportQueryP qp) {
		try {
			return getSqlMapClientTemplate().queryForList("UserInfo.queryUserInfo",
					qp);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public UserInfo queryUesrInfoByNickName(UserInfo ui) {
		AirportQueryP qp = new AirportQueryP();
		//UserInfo ui = new UserInfo();
		//ui.setNickName(nickName);
		qp.setParams(ui);
		try {
			return (UserInfo) getSqlMapClientTemplate().queryForObject("UserInfo.queryUserInfo",
					qp);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

	public UserInfo queryUesrInfoByEmail(UserInfo ui) {
		AirportQueryP qp = new AirportQueryP();
		//UserInfo ui = new UserInfo();
		//ui.setNickName(nickName);
		qp.setParams(ui);
		qp.setValue(new String[]{"*"});
		try {
			return (UserInfo) getSqlMapClientTemplate().queryForObject("UserInfo.queryUserInfo",
					qp);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
	}

}
