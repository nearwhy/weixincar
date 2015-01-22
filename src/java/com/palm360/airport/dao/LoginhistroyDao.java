package com.palm360.airport.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.palm360.airport.model.Loginhistroy;
import com.palm360.airport.util.stereotype.Replication;
@Repository
public interface LoginhistroyDao extends BaseDao<Loginhistroy> {
	
	void insertDB(Loginhistroy recore);
    
	@Replication(isInsert=true,isBeforeDB=true,key="LoginHistroy")
    void insert(Loginhistroy record) throws SQLException;

    int updateByPrimaryKey(Loginhistroy record) throws SQLException;

    int updateByPrimaryKeySelective(Loginhistroy record) throws SQLException;

    Loginhistroy selectByPrimaryKey(Integer id) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;

  
  
}
