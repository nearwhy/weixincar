package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.OprationcontentDao;
import com.palm360.airport.model.Oprationcontent;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("oprationContentDao")
@EntityKeyName(entity = Oprationcontent.class, keyName = "Oprationcontent")
public class OprationcontentDaoImpl extends BaseDaoImpl implements
		OprationcontentDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public OprationcontentDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Oprationcontent record) throws SQLException {
		sqlMapClient.insert("OprationContent.insert", record);
	}

	public int updateByPrimaryKey(Oprationcontent record) throws SQLException {
		int rows = sqlMapClient.update(
				"OprationContent.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Oprationcontent record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"OprationContent.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Oprationcontent selectByPrimaryKey(Integer oprationcontentid)
			throws SQLException {
		Oprationcontent key = new Oprationcontent();
		key.setOprationcontentid(oprationcontentid);
		Oprationcontent record = (Oprationcontent) sqlMapClient.queryForObject(
				"OprationContent.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer oprationcontentid)
			throws SQLException {
		Oprationcontent key = new Oprationcontent();
		key.setOprationcontentid(oprationcontentid);
		int rows = sqlMapClient.delete(
				"OprationContent.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("OprationContent.queryAll", new AirportQueryP(
				page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("OprationContent.queryAllCount");
	}

}
