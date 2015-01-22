package com.aero.o2o.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.aero.o2o.model.BasePojo;
import com.aero.o2o.model.QueryParam;
import com.ibatis.sqlmap.client.SqlMapClient;
/**
 * 解决ibatIS不能注入问题
 * @author palm360
 *
 */
public abstract class BaseDaoImpl extends SqlMapClientDaoSupport {
	Logger log = Logger.getLogger(getClass()); 
	@Resource(name = "sqlMapClient")
	protected SqlMapClient sqlMapClient;

	public BaseDaoImpl(){
		
	}
	
	@PostConstruct
	public void initSqlMapClient() {
		super.setSqlMapClient(sqlMapClient);
	}
	
	public void insert(BasePojo pojo){
		System.out.println("name======"+pojo.getClass().getSimpleName());
		this.getSqlMapClientTemplate().insert(pojo.getClass().getSimpleName()+".insert", pojo);
	}
	

	public BasePojo queryDetail(BasePojo pojo){
		return (BasePojo)this.getSqlMapClientTemplate().queryForObject(pojo.getClass().getSimpleName()+".queryDetail",pojo);
	}

	
	public void delete(BasePojo pojo){
		this.getSqlMapClientTemplate().delete(pojo.getClass().getSimpleName()+".delete", pojo);
	}

	public void update(BasePojo pojo){
		this.getSqlMapClientTemplate().update(pojo.getClass().getSimpleName()+".update", pojo);
	}
	


	
	public List queryList(String statementName,QueryParam qp){
		return this.getSqlMapClientTemplate().queryForList(statementName,qp);
	}

	public int queryListCount(String statementName,QueryParam qp){
		return (Integer)this.getSqlMapClientTemplate().queryForObject(statementName,qp);
	}
	
}
