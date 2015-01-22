package com.palm360.airport.dao;

import java.sql.SQLException;

import com.palm360.airport.model.Airterminal;

public interface AirterminalDao {
    
    void insert(Airterminal record) throws SQLException;

    int updateByPrimaryKey(Airterminal record) throws SQLException;

    int updateByPrimaryKeySelective(Airterminal record) throws SQLException;

    Airterminal selectByPrimaryKey(Integer airterminalid) throws SQLException;
    
    int deleteByPrimaryKey(Integer airterminalid) throws SQLException;

    
}
