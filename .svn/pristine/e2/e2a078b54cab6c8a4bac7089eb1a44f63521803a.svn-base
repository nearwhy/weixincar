package com.palm360.airport.model;

import java.io.Serializable;
import java.util.Date;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 历史记录
 * 
 * @author xzl
 * 
 */
@Deprecated
public class Loginhistroy implements Serializable {

	@NoCache
	private static final long serialVersionUID = -544759718028267924L;

	@PrimaryKey
	private Integer id;

	@ForeignKey
	private Integer userid;

	private String uuid;

	private Date logintime;

	private Date logouttime;

	private Integer islogined;

	private Float longitude;

	private Float latitude;

	private String sessionid;

	private Integer clienttype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public Date getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}

	public Integer getIslogined() {
		return islogined;
	}

	public void setIslogined(Integer islogined) {
		this.islogined = islogined;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Integer getClienttype() {
		return clienttype;
	}

	public void setClienttype(Integer clienttype) {
		this.clienttype = clienttype;
	}
}
