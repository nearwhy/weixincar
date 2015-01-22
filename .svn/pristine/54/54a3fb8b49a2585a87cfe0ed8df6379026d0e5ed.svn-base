package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.VerificationcodeDao;
import com.palm360.airport.model.Verificationcode;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("verificationCodeDao")
@EntityKeyName(entity = Verificationcode.class, keyName = "Verificationcode")
public class VerificationcodeDaoImpl extends BaseDaoImpl implements
		VerificationcodeDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public VerificationcodeDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Verificationcode record) throws SQLException {
		sqlMapClient.insert("VerificationCode.insert", record);
	}

	public int updateByPrimaryKey(Verificationcode record) throws SQLException {
		int rows = sqlMapClient.update(
				"VerificationCode.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Verificationcode record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"VerificationCode.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Verificationcode selectByPrimaryKey(Integer verificationid)
			throws SQLException {
		Verificationcode key = new Verificationcode();
		key.setVerificationid(verificationid);
		Verificationcode record = (Verificationcode) sqlMapClient
				.queryForObject(
						"VerificationCode.selectByPrimaryKey",
						key);
		return record;
	}

	public int deleteByPrimaryKey(Integer verificationid) throws SQLException {
		Verificationcode key = new Verificationcode();
		key.setVerificationid(verificationid);
		int rows = sqlMapClient.delete(
				"VerificationCode.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("VerificationCode.queryAll", new AirportQueryP(
				page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("VerificationCode.queryAllCount");
	}

}
