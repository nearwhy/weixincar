package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 操作内容
 * 
 * @author xzl
 * 
 */
@Deprecated
public class Oprationcontent implements Serializable {

	@NoCache
	private static final long serialVersionUID = 2320295904486044216L;

	@PrimaryKey
	private Integer oprationcontentid;

	private String oprationcontent;

	public Integer getOprationcontentid() {
		return oprationcontentid;
	}

	public void setOprationcontentid(Integer oprationcontentid) {
		this.oprationcontentid = oprationcontentid;
	}

	public String getOprationcontent() {
		return oprationcontent;
	}

	public void setOprationcontent(String oprationcontent) {
		this.oprationcontent = oprationcontent;
	}
}
