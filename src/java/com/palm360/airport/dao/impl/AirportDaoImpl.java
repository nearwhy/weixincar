package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.AirportDao;
import com.palm360.airport.model.Airport;
import com.palm360.airport.model.AirportExample;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("airportDao")
@EntityKeyName(entity=Airport.class, keyName="Airport")
public class AirportDaoImpl extends BaseDaoImpl implements AirportDao {
    //private SqlMapClientTemplate sqlMapClient;

//    public AirportDaoImpl() {
//        super();
//        this.sqlMapClient =  this.getSqlMapClientTemplate();
//    }

    public void insert(Airport record) throws SQLException {
    	getSqlMapClientTemplate().insert("AirPort.insert", record);
    }

    public int updateByPrimaryKey(Airport record) throws SQLException {
        int rows = getSqlMapClientTemplate().update("AirPort.updateByPrimaryKey", record);
        return rows;
    }

    public int updateByPrimaryKeySelective(Airport record) throws SQLException {
        int rows = getSqlMapClientTemplate().update("AirPort.updateByPrimaryKeySelective", record);
        return rows;
    }

    public List selectByExample(AirportExample example) throws SQLException {
        List list = getSqlMapClientTemplate().queryForList("AirPort.selectByExample", example);
        return list;
    }

    public Airport selectByPrimaryKey(Integer airportid) throws SQLException {
        Airport key = new Airport();
        key.setAirportid(airportid);
        Airport record = (Airport) getSqlMapClientTemplate().queryForObject("AirPort.selectByPrimaryKey", key);
        return record;
    }

    public int deleteByExample(AirportExample example) throws SQLException {
        int rows = getSqlMapClientTemplate().delete("AirPort.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer airportid) throws SQLException {
        Airport key = new Airport();
        key.setAirportid(airportid);
        int rows = getSqlMapClientTemplate().delete("AirPort.deleteByPrimaryKey", key);
        return rows;
    }

    public int countByExample(AirportExample example) throws SQLException {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("AirPort.countByExample", example);
        return count.intValue();
    }

    public int updateByExampleSelective(Airport record, AirportExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AirPort.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(Airport record, AirportExample example) throws SQLException {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("AirPort.updateByExample", parms);
        return rows;
    }

    private static class UpdateByExampleParms extends AirportExample {
        private Object record;

        public UpdateByExampleParms(Object record, AirportExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	public List queryAll(int size, int page) {
		return super.queryAll("AirPort.queryAll", new AirportQueryP(page,size));
	}

	public int queryAllCount() {
		return super.queryAllCount("AirPort.queryAllCount");
	}
}
