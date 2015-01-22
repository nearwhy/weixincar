package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.ProvinceDao;
import com.palm360.airport.model.Province;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("provinceDao")
@EntityKeyName(entity = Province.class, keyName = "Province")
public class ProvinceDaoImpl extends BaseDaoImpl implements ProvinceDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public ProvinceDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Province record) throws SQLException {
		sqlMapClient.insert("Province.insert", record);
	}

	public int updateByPrimaryKey(Province record) throws SQLException {
		int rows = sqlMapClient.update(
				"Province.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Province record) throws SQLException {
		int rows = sqlMapClient.update(
				"Province.updateByPrimaryKeySelective", record);
		return rows;
	}

	public Province selectByPrimaryKey(Integer provinceid) throws SQLException {
		Province key = new Province();
		key.setProvinceid(provinceid);
		Province record = (Province) sqlMapClient.queryForObject(
				"Province.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer provinceid) throws SQLException {
		Province key = new Province();
		key.setProvinceid(provinceid);
		int rows = sqlMapClient.delete(
				"Province.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("Province.queryAll",
				new AirportQueryP(page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("Province.queryAllCount");
	}
}
