package com.palm360.airport.dao;

import java.sql.SQLException;
import java.util.List;

import com.palm360.airport.model.Merchantinfo;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.Replication;

public interface MerchantinfoDao extends BaseDao<Merchantinfo> {

	@Replication(isQuery = true, isBeforeDB = true, key = "Merchantinfo")
	List queryMerchantInfoByGps(AirportQueryP qp);

	/**
	 * 新增一条数据
	 * 
	 * @param record
	 * @throws SQLException
	 */
	@Replication(isInsert = true, key = "Merchantinfo", isAfterDB = true)
	Object insert(Merchantinfo record) throws SQLException;

	/**
	 * 根据主键更新所有列
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	@Replication(isUpdate = true, isAfterDB = true, key = "Merchantinfo")
	int updateByPrimaryKey(Merchantinfo record) throws SQLException;

	/**
	 * 根据主键对需要更新的列进行更新
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	@Replication(isUpdate = true, isAfterDB = true, key = "Merchantinfo")
	int updateByPrimaryKeySelective(Merchantinfo record) throws SQLException;

	/**
	 * 根据主键进行查询商户信息
	 * 
	 * @param merchantid
	 * @return
	 * @throws SQLException
	 */
//	@Replication(isQuery = true, key = "Merchantinfo", isPkQuery = true, isBeforeDB = true)
	Merchantinfo selectByPrimaryKey(Merchantinfo record) throws SQLException;

	/**
	 * 根据主键查询商户信息和回复信息
	 * 
	 * @param record
	 * @return
	 * @throws SQLException
	 */
	@Replication(isQuery = true, key = "Merchantinfo", isPkQuery = true, isBeforeDB = true)
	Merchantinfo selectMerchantInfoAndUserCommentsByPrimaryKey(Merchantinfo record)
			throws SQLException;

	/**
	 * 根据主键进行删除
	 * 
	 * @param merchantid
	 * @return
	 * @throws SQLException
	 */
	@Replication(isDelete = true, key = "Merchantinfo", isAfterDB = true)
	int deleteByPrimaryKey(Merchantinfo record) throws SQLException;

	/**
	 * 根据航站楼，楼层，商户名称查询
	 * 
	 * @return
	 */
	@Replication(isQuery = true, isBeforeDB = true, key = "Merchantinfo")
	List<Merchantinfo> queryMerchantinfoList(AirportQueryP qp);

}
