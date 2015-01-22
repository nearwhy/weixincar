package com.palm360.airport.util;

import java.io.Serializable;
import java.util.HashMap;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;
import net.sf.json.util.PropertyFilter;

import com.palm360.airport.model.UserInfo;

/**
 * 结果返回类,可以记录分页信息
 * 和错误信息
 * @author zhangtong
 *
 */
public class AirportResult extends HashMap implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3845888184912826794L;
	//private int code = 0;
	private String errMessage="";
	private Object rsObject;
//	private String rsType;
	
	private int page;
	private int count=0;
	private int totalPage=0;
	private int size=0;
	private int previousPage=1;
	private int nextPage=1;
	private int lastPage=1;
	private int fristPage=1;
	
	public void setCode(int code) {
		this.put("code", code);
		//this.code = code;
	}
	public int getCode() {
		if(this.containsKey("code"))
			return Integer.parseInt(this.get("code").toString());
		return 0;
	}
	public void setErrMessage(String errMessage) {
		this.put("errMessage", errMessage);
//		this.errMessage = errMessage;
	}
	public String getErrMessage() {
		if(this.containsKey("errMessage"))
			return this.get("errMessage").toString();
		return errMessage;
	}
	public void setRsObject(Object rsObject) {
		this.put("rsObject", rsObject);
		this.rsObject = rsObject;
//		if("".equals(rsType) || null == rsType){
//			rsType = (rsObject != null) ? rsObject.getClass().getName() : "";
//		}
	}
	public Object getRsObject() {
		if(this.containsKey("rsObject"))
			return this.get("rsObject");
		return rsObject;
	}
//	public void setRsType(String rsType) {
//		this.rsType = rsType;
//	}
//	public String getRsType() {
//		return rsType;
//	}
	public void setPage(int page) {
		this.put("page", page);
		this.page = page;
	}
	public int getPage() {
		if(this.containsKey("page"))
			return Integer.parseInt(this.get("page").toString());
		return page;
		//return 1;
	}
	public void setCount(int count) {
		this.put("count", count);
		this.count = count;
		if(this.getSize() != 0  && this.getCount() !=0){
			this.totalPage = this.getCount()/this.getSize()%2==0?this.getCount()/this.getSize():this.getCount()/this.getSize()+1;
			this.put("totalPage", totalPage);
		}
	}
	public int getCount() {
		if(this.containsKey("count"))
			return Integer.parseInt(this.get("count").toString());
		return count;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		this.put("totalPage", totalPage);
//		if(this.size != 0 && this.count !=0){
//			this.totalPage = this.count/this.size%2==0?this.count/this.size:this.count/this.size+1;
//			this.put("totalPage", totalPage);
//		}
	}
	public int getTotalPage() {
		if(this.containsKey("totalPage"))
			return Integer.parseInt(this.get("totalPage").toString());
		return totalPage;
	}
	public void setSize(int size) {
		this.size = size;
		this.put("size", size);
		if(this.getSize() != 0  && this.getCount() !=0){
			this.totalPage = this.getCount()/this.getSize()%2==0?this.getCount()/this.getSize():this.getCount()/this.getSize()+1;
			this.put("totalPage", totalPage);
		}
	}
	public int getSize() {
		if(this.containsKey("size"))
			return Integer.parseInt(this.get("size").toString());
		return size;
	}
//	public void setPreviousPage(int previousPage) {
//		this.previousPage = previousPage;
//	}
	public int getPreviousPage() {
		return this.getPage()-1<1?1:this.getPage()-1;
		
	}
//	public void setNextPage(int nextPage) {
//		this.nextPage = nextPage;
//	}
	public int getNextPage() {
		//return nextPage;
		return this.getPage()+1>this.getTotalPage()?this.getTotalPage():this.getPage()+1;
	}
//	public void setLastPage(int lastPage) {
//		this.lastPage = lastPage;
//	}
	public int getLastPage() {
//		return lastPage;
		return this.getTotalPage();
	}
//	public void setFristPage(int fristPage) {
//		this.fristPage = fristPage;
//	}
	public int getFristPage() {
		return 1;
	}
}
