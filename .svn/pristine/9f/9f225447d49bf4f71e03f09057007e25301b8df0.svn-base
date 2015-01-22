package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.LoginhistroyDao;
import com.palm360.airport.model.Loginhistroy;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.exception.AirportRuntimeException;
import com.palm360.airport.util.stereotype.EntityKeyName;
import com.palm360.airport.util.stereotype.NoCache;

@Repository("loginHistroyDao")
@EntityKeyName(entity = Loginhistroy.class, keyName = "Loginhistroy")
@NoCache
public class LoginhistroyDaoImpl extends BaseDaoImpl implements LoginhistroyDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public LoginhistroyDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Loginhistroy record) throws SQLException {
		// it is nothing to do
		// it is for redis
	}

	public int updateByPrimaryKey(Loginhistroy record) throws SQLException {
		int rows = sqlMapClient.update(
				"LoginHistroy.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Loginhistroy record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"LoginHistroy.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Loginhistroy selectByPrimaryKey(Integer id) throws SQLException {
		Loginhistroy key = new Loginhistroy();
		key.setId(id);
		Loginhistroy record = (Loginhistroy) sqlMapClient.queryForObject(
				"LoginHistroy.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Loginhistroy key = new Loginhistroy();
		key.setId(id);
		int rows = sqlMapClient.delete(
				"LoginHistroy.deleteByPrimaryKey", key);
		return rows;
	}

	public void insertDB(Loginhistroy record) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("LoginHistroy.insert", record);
		} catch (Exception e) {
			throw new AirportRuntimeException("system.unkown.err", e);
		}
	}

	public List queryAll(int size, int page) {
		return super.queryAll("LoginHistroy.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("LoginHistroy.queryAllCount");
	}

}
