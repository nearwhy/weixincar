package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.TerminalmapsDao;
import com.palm360.airport.model.Terminalmaps;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("terminalMapsDao")
@EntityKeyName(entity = Terminalmaps.class, keyName = "Terminalmaps")
public class TerminalmapsDaoImpl extends BaseDaoImpl implements TerminalmapsDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public TerminalmapsDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Terminalmaps record) throws SQLException {
		sqlMapClient.insert("TerminalMaps.insert", record);
	}

	public int updateByPrimaryKey(Terminalmaps record) throws SQLException {
		int rows = sqlMapClient.update(
				"TerminalMaps.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Terminalmaps record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"TerminalMaps.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Terminalmaps selectByPrimaryKey(Integer terminalmapsid)
			throws SQLException {
		Terminalmaps key = new Terminalmaps();
		key.setTerminalmapsid(terminalmapsid);
		Terminalmaps record = (Terminalmaps) sqlMapClient.queryForObject(
				"TerminalMaps.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer terminalmapsid) throws SQLException {
		Terminalmaps key = new Terminalmaps();
		key.setTerminalmapsid(terminalmapsid);
		int rows = sqlMapClient.delete(
				"TerminalMaps.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("TerminalMaps.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("TerminalMaps.queryAllCount");
	}
}
