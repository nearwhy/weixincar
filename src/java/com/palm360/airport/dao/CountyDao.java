package com.palm360.airport.dao;

import com.palm360.airport.model.County;
import com.palm360.airport.model.CountyExample;
import java.sql.SQLException;
import java.util.List;

public interface CountyDao {
    
    void insert(County record) throws SQLException;

    int updateByPrimaryKey(County record) throws SQLException;

    int updateByPrimaryKeySelective(County record) throws SQLException;

    List selectByExample(CountyExample example) throws SQLException;

    County selectByPrimaryKey(Integer countyid) throws SQLException;

    int deleteByExample(CountyExample example) throws SQLException;

    int deleteByPrimaryKey(Integer countyid) throws SQLException;

    int countByExample(CountyExample example) throws SQLException;

    int updateByExampleSelective(County record, CountyExample example) throws SQLException;

    int updateByExample(County record, CountyExample example) throws SQLException;
}
