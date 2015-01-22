package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.CommoditypicDao;
import com.palm360.airport.model.Commodityinfo;
import com.palm360.airport.model.Commoditypic;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("commodityPicDao")
@EntityKeyName(entity = Commoditypic.class, keyName = "Commoditypic")
public class CommoditypicDaoImpl extends BaseDaoImpl implements CommoditypicDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public CommoditypicDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Commoditypic record) throws SQLException {
		sqlMapClient.insert("CommodityPic.insert", record);
	}

	public int updateByPrimaryKey(Commoditypic record) throws SQLException {
		int rows = sqlMapClient.update(
				"CommodityPic.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Commoditypic record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"CommodityPic.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Commoditypic selectByPrimaryKey(Integer id) throws SQLException {
		Commoditypic key = new Commoditypic();
		key.setId(id);
		Commoditypic record = (Commoditypic) sqlMapClient.queryForObject(
				"CommodityPic.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Commoditypic key = new Commoditypic();
		key.setId(id);
		int rows = sqlMapClient.delete(
				"CommodityPic.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("CommodityPic.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("CommodityPic.queryAllCount");
	}
	
	public List<Commoditypic> queryByFk(AirportQueryP qp) {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("queryByFk",qp);
	}

}
