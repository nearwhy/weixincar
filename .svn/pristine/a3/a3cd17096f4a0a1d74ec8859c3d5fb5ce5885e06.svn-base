package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.RegisterPromotionslistDao;
import com.palm360.airport.model.RegisterPromotionsList;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("registerPromotionsListDao")
@EntityKeyName(entity = RegisterPromotionsList.class, keyName = "RegisterPromotionslist")
public class RegisterPromotionsListDaoImpl extends BaseDaoImpl implements
		RegisterPromotionslistDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public RegisterPromotionsListDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(RegisterPromotionsList record) throws SQLException {
		sqlMapClient.insert("RegisterPromotionsList.insert", record);
	}

	public int updateByPrimaryKey(RegisterPromotionsList record) throws SQLException {
		int rows = sqlMapClient.update(
				"RegisterPromotionsList.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(RegisterPromotionsList record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"RegisterPromotionsList.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public RegisterPromotionsList selectByPrimaryKey(Integer promotionslistid)
			throws SQLException {
		RegisterPromotionsList key = new RegisterPromotionsList();
		key.setPromotionsListId(promotionslistid);
		RegisterPromotionsList record = (RegisterPromotionsList) sqlMapClient.queryForObject(
				"RegisterPromotionsList.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer promotionslistid) throws SQLException {
		RegisterPromotionsList key = new RegisterPromotionsList();
		key.setPromotionsListId(promotionslistid);
		int rows = sqlMapClient.delete(
				"RegisterPromotionsList.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("RegisterPromotionsList.queryAll", new AirportQueryP(
				page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("RegisterPromotionsList.queryAllCount");
	}
}
