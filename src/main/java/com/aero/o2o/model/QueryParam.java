package com.aero.o2o.model;

import java.util.HashMap;
import java.util.Map;

public class QueryParam extends HashMap<String,Object>{
	
	public QueryParam(Map<String,Object> map){
		this.putAll(map);
	}
	
	public QueryParam(){
		
	}
	
	public void setPage(Integer pageIndex,Integer pageSize) {
		this.put("pageTop", pageIndex*pageSize+1);
		this.put("pageRow", (pageIndex-1)*pageSize);
		this.put("pageCount", pageSize+1);
	}

	public void setPojo(BasePojo pojo){
		this.put("pojo", pojo);
	}
	
}
