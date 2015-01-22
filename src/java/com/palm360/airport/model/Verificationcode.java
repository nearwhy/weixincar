package com.palm360.airport.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 二维码内容
 * 
 * @author xzl
 * 
 */
public class Verificationcode extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = 8730958828551097000L;

	@PrimaryKey 
	private Integer verificationid;

	@ForeignKey
	private Integer userid;

	@ForeignKey
	private Integer promotionsId;

	private String content;

	private String path;

	private Timestamp validitydate;

	private Timestamp releasedate;

	private Integer flag;

	public Integer getVerificationid() {
		return verificationid;
	}

	public void setVerificationid(Integer verificationid) {
		this.verificationid = verificationid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getPromotionsId() {
		return promotionsId;
	}

	public void setPromotionsId(Integer promotionsId) {
		this.promotionsId = promotionsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Timestamp getValiditydate() {
		return validitydate;
	}

	public void setValiditydate(Timestamp validitydate) {
		this.validitydate = validitydate;
	}

	public Timestamp getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Timestamp releasedate) {
		this.releasedate = releasedate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
