package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.UseroprationlogDao;
import com.palm360.airport.model.Useroprationlog;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;
import com.palm360.airport.util.stereotype.NoCache;

@Repository("userOprationLogDao")
@EntityKeyName(entity = Useroprationlog.class, keyName = "Useroprationlog")
@NoCache
public class UseroprationlogDaoImpl extends BaseDaoImpl implements
		UseroprationlogDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public UseroprationlogDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Useroprationlog record) {
		
	}
	
	public int updateByPrimaryKey(Useroprationlog record) throws SQLException {
		int rows = sqlMapClient.update(
				"UserOprationLog.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Useroprationlog record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"UserOprationLog.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Useroprationlog selectByPrimaryKey(Integer logid)
			throws SQLException {
		Useroprationlog key = new Useroprationlog();
		key.setLogid(logid);
		Useroprationlog record = (Useroprationlog) sqlMapClient.queryForObject(
				"UserOprationLog.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer logid) throws SQLException {
		Useroprationlog key = new Useroprationlog();
		key.setLogid(logid);
		int rows = sqlMapClient.delete(
				"UserOprationLog.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("UserOprationLog.queryAll", new AirportQueryP(
				page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("UserOprationLog.queryAllCount");
	}

	public void insertDB(Useroprationlog record) {
		// TODO Auto-generated method stub
		sqlMapClient.insert("UserOprationLog.insert", record);
	}

}
