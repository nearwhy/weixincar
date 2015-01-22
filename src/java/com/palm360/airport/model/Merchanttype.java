package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 商户类型
 * 
 * @author xzl
 * 
 */
public class Merchanttype extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = -3373754932002272227L;

	@PrimaryKey
	private Integer mtid;

	private String typename;

	public Integer getMtid() {
		return mtid;
	}

	public void setMtid(Integer mtid) {
		this.mtid = mtid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
