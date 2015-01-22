package com.palm360.airport.dao;

import com.palm360.airport.model.Airport;
import com.palm360.airport.model.AirportExample;
import java.sql.SQLException;
import java.util.List;

public interface AirportDao extends BaseDao<Airport>{
    
    void insert(Airport record) throws SQLException;

    int updateByPrimaryKey(Airport record) throws SQLException;

    int updateByPrimaryKeySelective(Airport record) throws SQLException;

    List selectByExample(AirportExample example) throws SQLException;

    Airport selectByPrimaryKey(Integer airportid) throws SQLException;

    int deleteByExample(AirportExample example) throws SQLException;

    int deleteByPrimaryKey(Integer airportid) throws SQLException;

    int countByExample(AirportExample example) throws SQLException;

    int updateByExampleSelective(Airport record, AirportExample example) throws SQLException;

    int updateByExample(Airport record, AirportExample example) throws SQLException;
}
