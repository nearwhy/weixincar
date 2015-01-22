package com.palm360.airport.dao;

import java.sql.SQLException;

import com.palm360.airport.model.Useroprationlog;
import com.palm360.airport.util.stereotype.Replication;

public interface UseroprationlogDao {
    
	@Replication(isInsert=true,isCustomKey=true,key="Useroprationlog",isAfterDB=true)
    void insert(Useroprationlog record) ;
	void insertDB(Useroprationlog record);
    
    int updateByPrimaryKey(Useroprationlog record) throws SQLException;

    int updateByPrimaryKeySelective(Useroprationlog record) throws SQLException;

    Useroprationlog selectByPrimaryKey(Integer logid) throws SQLException;

    int deleteByPrimaryKey(Integer logid) throws SQLException;

}
