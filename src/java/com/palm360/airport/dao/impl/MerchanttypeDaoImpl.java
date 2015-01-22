package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.MerchanttypeDao;
import com.palm360.airport.model.Merchanttype;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("merchantTypeDao")
@EntityKeyName(entity = Merchanttype.class, keyName = "Merchanttype")
public class MerchanttypeDaoImpl extends BaseDaoImpl implements MerchanttypeDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public MerchanttypeDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Merchanttype record) throws SQLException {
		sqlMapClient.insert("MerchantType.insert", record);
	}

	public int updateByPrimaryKey(Merchanttype record) throws SQLException {
		int rows = sqlMapClient.update(
				"MerchantType.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Merchanttype record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"MerchantType.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Merchanttype selectByPrimaryKey(Integer mtid) throws SQLException {
		Merchanttype key = new Merchanttype();
		key.setMtid(mtid);
		Merchanttype record = (Merchanttype) sqlMapClient.queryForObject(
				"MerchantType.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer mtid) throws SQLException {
		Merchanttype key = new Merchanttype();
		key.setMtid(mtid);
		int rows = sqlMapClient.delete(
				"MerchantType.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("MerchantType.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("MerchantType.queryAllCount");
	}
}
