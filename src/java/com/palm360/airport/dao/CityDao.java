package com.palm360.airport.dao;

import java.sql.SQLException;

import com.palm360.airport.model.City;

public interface CityDao {

	void insert(City record) throws SQLException;

    int updateByPrimaryKey(City record) throws SQLException;

    int updateByPrimaryKeySelective(City record) throws SQLException;

    City selectByPrimaryKey(Integer cityid) throws SQLException;

    int deleteByPrimaryKey(Integer cityid) throws SQLException;

  
}
