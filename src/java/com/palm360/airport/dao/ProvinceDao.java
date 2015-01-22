package com.palm360.airport.dao;

import java.sql.SQLException;

import com.palm360.airport.model.Province;

public interface ProvinceDao {
    
    void insert(Province record) throws SQLException;

    int updateByPrimaryKey(Province record) throws SQLException;

    int updateByPrimaryKeySelective(Province record) throws SQLException;

    Province selectByPrimaryKey(Integer provinceid) throws SQLException;

    int deleteByPrimaryKey(Integer provinceid) throws SQLException;

}
