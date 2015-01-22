package com.palm360.airport.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.exception.AirportRuntimeException;
/**
 * 解决ibatIS不能注入问题
 * @author palm360
 *
 */
public abstract class BaseDaoImpl extends SqlMapClientDaoSupport {

	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;

	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}
	protected int queryAllCount(String statementName){
		try{
			return Integer.parseInt(this.getSqlMapClientTemplate().queryForObject(statementName).toString());
		}catch(AirportRuntimeException e){
			throw new AirportRuntimeException("system.unkown.err");
		}
	}
	protected List queryAll(String statementName,AirportQueryP aqp){
		try{
			return this.getSqlMapClientTemplate().queryForList(statementName,aqp);
		}catch(AirportRuntimeException e){
			throw new AirportRuntimeException("system.unkown.err");
		}
	}
}
