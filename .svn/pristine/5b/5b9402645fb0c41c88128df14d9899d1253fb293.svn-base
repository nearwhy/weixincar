package com.palm360.airport.dao;

import java.sql.SQLException;
import java.util.List;

import com.palm360.airport.model.Commodityinfo;
import com.palm360.airport.model.Commoditypic;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.Replication;

public interface CommoditypicDao extends BaseDao<Commoditypic>{
    
    void insert(Commoditypic record) throws SQLException;

    int updateByPrimaryKey(Commoditypic record) throws SQLException;

    int updateByPrimaryKeySelective(Commoditypic record) throws SQLException;

    Commoditypic selectByPrimaryKey(Integer id) throws SQLException;

    int deleteByPrimaryKey(Integer id) throws SQLException;
    
    @Replication(isQuery=true,isBeforeDB=true,isQueryFK=true,fkName="commodityid")
    List<Commoditypic> queryByFk(AirportQueryP info);

 
}
