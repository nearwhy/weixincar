package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.MerchantinfoDao;
import com.palm360.airport.model.Merchantinfo;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("merchantInfoDao")
@EntityKeyName(entity = Merchantinfo.class, keyName = "Merchantinfo", replicationClass = "com.palm360.airport.redisimpl.MerchantinfoRedisImpl")
public class MerchantinfoDaoImpl extends BaseDaoImpl implements MerchantinfoDao {

	private SqlMapClientTemplate sqlMapClient;

	public MerchantinfoDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public Object insert(Merchantinfo record) throws SQLException {
		Object o = sqlMapClient.insert("MerchantInfo.insert", record);
		System.out.println(o);
		record.setMerchantid(Integer.parseInt(o.toString()));
		return record;
	}

	public int updateByPrimaryKey(Merchantinfo record) throws SQLException {
		int rows = sqlMapClient.update("MerchantInfo.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Merchantinfo record) throws SQLException {
		int rows = sqlMapClient.update("MerchantInfo.updateByPrimaryKeySelective", record);
		return rows;
	}

	public Merchantinfo selectByPrimaryKey(Merchantinfo record) throws SQLException {
		return (Merchantinfo) sqlMapClient.queryForObject("MerchantInfo.selectByPrimaryKey", record);
	}

	public Merchantinfo selectMerchantInfoAndUserCommentsByPrimaryKey(Merchantinfo record)
			throws SQLException {
		return (Merchantinfo) sqlMapClient.queryForObject("MerchantInfo.selectMerchantInfoAndUserCommentsByPrimaryKey", record);
	}

	public int deleteByPrimaryKey(Merchantinfo record) throws SQLException {
		Merchantinfo key = new Merchantinfo();
		key.setMerchantid(record.getMerchantid());
		int rows = sqlMapClient.delete("MerchantInfo.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("MerchantInfo.queryAll", new AirportQueryP(page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("MerchantInfo.queryAllCount");
	}

	public List<Merchantinfo> queryMerchantinfoList(AirportQueryP qp) {
		return sqlMapClient.queryForList("MerchantInfo.AirTerminal_Floor_MerchantName", qp);
	}

	public List queryMerchantInfoByGps(AirportQueryP qp) {
		return sqlMapClient.queryForList("MerchantInfo.queryMerchantByGps", qp);
	}

}
