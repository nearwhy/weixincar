package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.PromotionsDao;
import com.palm360.airport.model.Promotions;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("promotionsDao")
@EntityKeyName(entity = Promotions.class, keyName = "Promotions")
public class PromotionsDaoImpl extends BaseDaoImpl implements PromotionsDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public PromotionsDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Promotions record) throws SQLException {
		sqlMapClient.insert("Promotions.insert", record);
	}

	public int updateByPrimaryKey(Promotions record) throws SQLException {
		int rows = sqlMapClient.update(
				"Promotions.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Promotions record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"Promotions.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Promotions selectByPrimaryKey(Integer promotionsid)
			throws SQLException {
		Promotions key = new Promotions();
		key.setPromotionsid(promotionsid);
		Promotions record = (Promotions) sqlMapClient.queryForObject(
				"Promotions.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer promotionsid) throws SQLException {
		Promotions key = new Promotions();
		key.setPromotionsid(promotionsid);
		int rows = sqlMapClient.delete(
				"Promotions.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("Promotions.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("Promotions.queryAllCount");
	}

}
