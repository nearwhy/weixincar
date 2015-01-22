package com.palm360.airport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 用户操作日志，记录用户的所有操作日志
 * 
 * @author xzl
 * 
 */
@Entity
@Table(name = "Useroprationlog")
public class Useroprationlog extends BaseModel implements Serializable {
	
	@NoCache
	private static final long serialVersionUID = 9208649199687055939L;

	@PrimaryKey
	private Integer logid;

	@ForeignKey
	private Integer userid;

	//@ForeignKey
	private String oprationtype;

	//@ForeignKey
	private String oprationcontent;

	private String content;

	private Date oprationdate;

	private String uuid;

	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOprationdate() {
		return oprationdate;
	}

	public void setOprationdate(Date oprationdate) {
		this.oprationdate = oprationdate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setOprationtype(String oprationtype) {
		this.oprationtype = oprationtype;
	}

	public String getOprationtype() {
		return oprationtype;
	}

	public void setOprationcontent(String oprationcontent) {
		this.oprationcontent = oprationcontent;
	}

	public String getOprationcontent() {
		return oprationcontent;
	}
}
