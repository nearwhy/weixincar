package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.OprationtypeDao;
import com.palm360.airport.model.Oprationtype;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("oprationTypeDao")
@EntityKeyName(entity = Oprationtype.class, keyName = "Oprationtype")
public class OprationtypeDaoImpl extends BaseDaoImpl implements OprationtypeDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public OprationtypeDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Oprationtype record) throws SQLException {
		sqlMapClient.insert("OprationType.insert", record);
	}

	public int updateByPrimaryKey(Oprationtype record) throws SQLException {
		int rows = sqlMapClient.update(
				"OprationType.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Oprationtype record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"OprationType.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Oprationtype selectByPrimaryKey(Integer oprationtypeid)
			throws SQLException {
		Oprationtype key = new Oprationtype();
		key.setOprationtypeid(oprationtypeid);
		Oprationtype record = (Oprationtype) sqlMapClient.queryForObject(
				"OprationType.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer oprationtypeid) throws SQLException {
		Oprationtype key = new Oprationtype();
		key.setOprationtypeid(oprationtypeid);
		int rows = sqlMapClient.delete(
				"OprationType.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("OprationType.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("OprationType.queryAllCount");
	}

}
