package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.RegisterPromotionsDao;
import com.palm360.airport.model.RegisterPromotions;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("registerPromotionsDao")
@EntityKeyName(entity = RegisterPromotions.class, keyName = "RegisterPromotions")
public class RegisterPromotionsDaoImpl extends BaseDaoImpl implements RegisterPromotionsDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public RegisterPromotionsDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(RegisterPromotions record) throws SQLException {
		sqlMapClient.insert("RegisterPromotions.insert", record);
	}

	public int updateByPrimaryKey(RegisterPromotions record) throws SQLException {
		int rows = sqlMapClient.update(
				"RegisterPromotions.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(RegisterPromotions record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"RegisterPromotions.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public RegisterPromotions selectByPrimaryKey(Integer promotionsid)
			throws SQLException {
		RegisterPromotions key = new RegisterPromotions();
		key.setPromotionsId(promotionsid);
		RegisterPromotions record = (RegisterPromotions) sqlMapClient.queryForObject(
				"RegisterPromotions.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer promotionsid) throws SQLException {
		RegisterPromotions key = new RegisterPromotions();
		key.setPromotionsId(promotionsid);
		int rows = sqlMapClient.delete(
				"RegisterPromotions.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("RegisterPromotions.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("RegisterPromotions.queryAllCount");
	}

	public List<RegisterPromotions> queryPromotions(AirportQueryP qp) throws SQLException {
		return sqlMapClient.queryForList("RegisterPromotions.queryRegisterPromotions", qp);
	}

	public List<RegisterPromotions> queryPromotionsByCurrentTimestamp(AirportQueryP qp) throws SQLException {
		return sqlMapClient.queryForList("RegisterPromotions.queryRegisterByCurrentTimestamp", qp);
	}

}
