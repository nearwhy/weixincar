package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.CityDao;
import com.palm360.airport.model.City;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("cityDao")
@EntityKeyName(entity = City.class, keyName = "City")
public class CityDaoImpl extends BaseDaoImpl implements CityDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public CityDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(City record) throws SQLException {
		sqlMapClient.insert("City.insert", record);
	}

	public int updateByPrimaryKey(City record) throws SQLException {
		int rows = sqlMapClient.update(
				"City.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(City record) throws SQLException {
		int rows = sqlMapClient.update(
				"City.updateByPrimaryKeySelective", record);
		return rows;
	}

	public City selectByPrimaryKey(Integer cityid) throws SQLException {
		City key = new City();
		key.setCityid(cityid);
		City record = (City) sqlMapClient.queryForObject(
				"City.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer cityid) throws SQLException {
		City key = new City();
		key.setCityid(cityid);
		int rows = sqlMapClient.delete(
				"City.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("City.queryAll", new AirportQueryP(page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("City.queryAllCount");
	}

}
