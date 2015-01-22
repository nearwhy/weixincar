package com.palm360.airport.model;

import java.io.Serializable;

/**
 * 商品类型
 * 
 * @author xzl
 * 
 */
public class CommodityType extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ctid;

	private String typeName;

	private Integer ctParentId;

	public Integer getCtid() {
		return ctid;
	}

	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getCtParentId() {
		return ctParentId;
	}

	public void setCtParentId(Integer ctParentId) {
		this.ctParentId = ctParentId;
	}

}
