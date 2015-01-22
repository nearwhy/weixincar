package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.AirterminalDao;
import com.palm360.airport.model.Airterminal;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("airTerminalDao")
@EntityKeyName(entity=Airterminal.class, keyName="Airterminal")
public class AirterminalDaoImpl extends BaseDaoImpl  implements AirterminalDao {
    
	 private SqlMapClientTemplate sqlMapClient;

    public AirterminalDaoImpl() {
    	 super();
         this.sqlMapClient =  this.getSqlMapClientTemplate();
    }

    public void insert(Airterminal record) throws SQLException {
        sqlMapClient.insert("AirTerminal.insert", record);
    }

    public int updateByPrimaryKey(Airterminal record) throws SQLException {
        int rows = sqlMapClient.update("AirTerminal.updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Airterminal record) throws SQLException {
        int rows = sqlMapClient.update("AirTerminal.updateByPrimaryKeySelective", record);
        return rows;
    }

    public Airterminal selectByPrimaryKey(Integer airterminalid) throws SQLException {
        Airterminal key = new Airterminal();
        key.setAirterminalid(airterminalid);
        Airterminal record = (Airterminal) sqlMapClient.queryForObject("AirTerminal.selectByPrimaryKey", key);
        return record;
    }

    public int deleteByPrimaryKey(Integer airterminalid) throws SQLException {
        Airterminal key = new Airterminal();
        key.setAirterminalid(airterminalid);
        int rows = sqlMapClient.delete("AirTerminal.deleteByPrimaryKey", key);
        return rows;
    }

    public List queryAll(int size, int page) {
		return super.queryAll("AirTerminal.queryAll", new AirportQueryP(page, size));
	}

	public int queryAllCount() {
		return super.queryAllCount("AirTerminal.queryAllCount");
	}
   
   

   
}
