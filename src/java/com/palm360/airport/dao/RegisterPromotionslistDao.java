package com.palm360.airport.dao;

import java.sql.SQLException;

import com.palm360.airport.model.RegisterPromotionsList;

public interface RegisterPromotionslistDao {
    
    void insert(RegisterPromotionsList record) throws SQLException;

    int updateByPrimaryKey(RegisterPromotionsList record) throws SQLException;

    int updateByPrimaryKeySelective(RegisterPromotionsList record) throws SQLException;

    RegisterPromotionsList selectByPrimaryKey(Integer promotionslistid) throws SQLException;

    int deleteByPrimaryKey(Integer promotionslistid) throws SQLException;

}
