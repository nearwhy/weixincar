package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.PromotionslistDao;
import com.palm360.airport.model.Promotionslist;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("promotionsListDao")
@EntityKeyName(entity = Promotionslist.class, keyName = "Promotionslist")
public class PromotionslistDaoImpl extends BaseDaoImpl implements
		PromotionslistDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public PromotionslistDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Promotionslist record) throws SQLException {
		sqlMapClient.insert("PromotionsList.insert", record);
	}

	public int updateByPrimaryKey(Promotionslist record) throws SQLException {
		int rows = sqlMapClient.update(
				"PromotionsList.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Promotionslist record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"PromotionsList.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Promotionslist selectByPrimaryKey(Integer promotionslistid)
			throws SQLException {
		Promotionslist key = new Promotionslist();
		key.setPromotionslistid(promotionslistid);
		Promotionslist record = (Promotionslist) sqlMapClient.queryForObject(
				"PromotionsList.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer promotionslistid) throws SQLException {
		Promotionslist key = new Promotionslist();
		key.setPromotionslistid(promotionslistid);
		int rows = sqlMapClient.delete(
				"PromotionsList.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("PromotionsList.queryAll", new AirportQueryP(
				page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("PromotionsList.queryAllCount");
	}
}
