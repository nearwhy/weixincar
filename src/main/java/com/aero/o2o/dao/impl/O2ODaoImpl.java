package com.aero.o2o.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.aero.o2o.dao.O2ODao;
import com.aero.o2o.model.QueryParam;

@Repository("O2ODaoImpl")
public class O2ODaoImpl extends BaseDaoImpl  implements O2ODao{
	
	public List queryForList(String statementName,QueryParam qp){
		return this.getSqlMapClientTemplate().queryForList(statementName,qp);
	}

	public List queryListPage(String statementName,QueryParam qp){
		List list = this.getSqlMapClientTemplate().queryForList(statementName,qp);
		if(list.size()==(Integer)qp.get("pageCount")){
			list.remove(list.size()-1);
			qp.put("end",1);
		}else{
			qp.put("end",0);
		}
		return list;
	}
	
	public Object queryForObject(String statementName,QueryParam qp){
		return this.getSqlMapClientTemplate().queryForObject(statementName,qp);
	}

	public void insert(String statementName,QueryParam qp){
		this.getSqlMapClientTemplate().insert(statementName,qp);
	}

	@Override
	public void update(String statementName, QueryParam qp) {
		this.getSqlMapClientTemplate().update(statementName,qp);
	}
}
