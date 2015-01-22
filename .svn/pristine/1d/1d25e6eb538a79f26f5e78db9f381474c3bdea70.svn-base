package com.palm360.airport.dao;

import java.sql.SQLException;
import java.util.List;

import com.palm360.airport.model.RegisterPromotions;
import com.palm360.airport.util.AirportQueryP;

public interface RegisterPromotionsDao {

	void insert(RegisterPromotions record) throws SQLException;

	int updateByPrimaryKey(RegisterPromotions record) throws SQLException;

	int updateByPrimaryKeySelective(RegisterPromotions record) throws SQLException;

	RegisterPromotions selectByPrimaryKey(Integer promotionsid) throws SQLException;

	int deleteByPrimaryKey(Integer promotionsid) throws SQLException;

	/**
	 * 根据条件查询
	 * 
	 * @param qp
	 * @return
	 * @throws SQLException
	 */
	List<RegisterPromotions> queryPromotions(AirportQueryP qp) throws SQLException;

	/**
	 * 根据当前时间查询
	 * 
	 * @param qp
	 * @return
	 * @throws SQLException
	 */
	List<RegisterPromotions> queryPromotionsByCurrentTimestamp(AirportQueryP qp) throws SQLException;

}
