package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.CommodityTypeDao;
import com.palm360.airport.model.CommodityType;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("commodityTypeDao")
@EntityKeyName(entity = CommodityType.class, keyName = "CommodityType")
public class CommodityTypeDaoImpl extends BaseDaoImpl implements CommodityTypeDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public CommodityTypeDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(CommodityType record) throws SQLException {
		sqlMapClient.insert("CommodityType.insert", record);
	}

	public int updateByPrimaryKey(CommodityType record) throws SQLException {
		int rows = sqlMapClient.update(
				"CommodityType.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(CommodityType record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"CommodityType.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public CommodityType selectByPrimaryKey(Integer ctid) throws SQLException {
		CommodityType key = new CommodityType();
		key.setCtid(ctid);
		CommodityType record = (CommodityType) sqlMapClient.queryForObject(
				"CommodityType.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer ctid) throws SQLException {
		CommodityType key = new CommodityType();
		key.setCtid(ctid);
		int rows = sqlMapClient.delete(
				"CommodityType.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("CommodityType.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("CommodityType.queryAllCount");
	}
}
