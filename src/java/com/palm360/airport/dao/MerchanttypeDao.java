package com.palm360.airport.dao;

import java.sql.SQLException;

import com.palm360.airport.model.Merchanttype;

public interface MerchanttypeDao {
    
    void insert(Merchanttype record) throws SQLException;

    int updateByPrimaryKey(Merchanttype record) throws SQLException;

    int updateByPrimaryKeySelective(Merchanttype record) throws SQLException;

    Merchanttype selectByPrimaryKey(Integer mtid) throws SQLException;

    int deleteByPrimaryKey(Integer mtid) throws SQLException;
}
