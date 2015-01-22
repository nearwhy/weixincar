package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 省
 * 
 * @author xzl
 * 
 */
public class Province extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = -2712801232576515117L;

	@PrimaryKey
	private Integer provinceid;

	private String provincename;

	public Integer getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
}
