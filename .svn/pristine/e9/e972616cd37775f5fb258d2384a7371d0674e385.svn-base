package com.palm360.airport.dao;

import java.sql.SQLException;
import java.util.List;

import com.palm360.airport.model.Commodityinfo;
import com.palm360.airport.model.Commoditypic;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.Replication;

public interface CommodityinfoDao extends BaseDao<Commoditypic>{
    
    void insert(Commodityinfo record) throws SQLException;

    int updateByPrimaryKey(Commodityinfo record) throws SQLException;

    int updateByPrimaryKeySelective(Commodityinfo record) throws SQLException;

    Commodityinfo selectByPrimaryKey(Integer commodityid) throws SQLException;

    int deleteByPrimaryKey(Integer commodityid) throws SQLException;

    List<Commodityinfo> selectByRegisterPromotionsId(Integer rpId) throws SQLException;
    @Replication(isQuery=true,isPkQuery=true,isBeforeDB=true,key="Commodityinfo")
    Commodityinfo queryByPk(Commodityinfo commodityinfo);
    @Replication(isQuery=true,isQueryFK=true,isBeforeDB=true,key="Commodityinfo",fkName="params.merchantid")
    List queryCommodityinfoByFk(AirportQueryP qp);
}
