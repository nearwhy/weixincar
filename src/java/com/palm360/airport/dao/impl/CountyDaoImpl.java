package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.CountyDao;
import com.palm360.airport.model.County;
import com.palm360.airport.model.CountyExample;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("countyDao")
@EntityKeyName(entity = County.class, keyName = "County")
public class CountyDaoImpl extends BaseDaoImpl implements CountyDao {

	private SqlMapClientTemplate sqlMapClient;

	public CountyDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(County record) throws SQLException {
		sqlMapClient.insert("County.insert", record);
	}

	public int updateByPrimaryKey(County record) throws SQLException {
		int rows = sqlMapClient.update(
				"County.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(County record) throws SQLException {
		int rows = sqlMapClient.update(
				"County.updateByPrimaryKeySelective", record);
		return rows;
	}

	public List selectByExample(CountyExample example) throws SQLException {
		List list = sqlMapClient.queryForList(
				"County.selectByExample", example);
		return list;
	}

	public County selectByPrimaryKey(Integer countyid) throws SQLException {
		County key = new County();
		key.setCountyid(countyid);
		County record = (County) sqlMapClient.queryForObject(
				"County.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByExample(CountyExample example) throws SQLException {
		int rows = sqlMapClient.delete(
				"County.deleteByExample", example);
		return rows;
	}

	public int deleteByPrimaryKey(Integer countyid) throws SQLException {
		County key = new County();
		key.setCountyid(countyid);
		int rows = sqlMapClient.delete(
				"County.deleteByPrimaryKey", key);
		return rows;
	}

	public int countByExample(CountyExample example) throws SQLException {
		Integer count = (Integer) sqlMapClient.queryForObject(
				"County.countByExample", example);
		return count.intValue();
	}

	public int updateByExampleSelective(County record, CountyExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"County.updateByExampleSelective", parms);
		return rows;
	}

	public int updateByExample(County record, CountyExample example)
			throws SQLException {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = sqlMapClient.update(
				"County.updateByExample", parms);
		return rows;
	}

	private static class UpdateByExampleParms extends CountyExample {
		private Object record;

		public UpdateByExampleParms(Object record, CountyExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	public List queryAll(int size, int page) {
		return super.queryAll("County.queryAll", new AirportQueryP(page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("County.queryAllCount");
	}
}
