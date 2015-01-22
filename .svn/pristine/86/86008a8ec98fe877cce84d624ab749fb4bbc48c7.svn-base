package com.palm360.airport.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.ForeignKeyList;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 用户评价表
 * 
 * @author xzl
 * 
 */
@Entity
@Table(name="Usercomment")
public class Usercomment extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = 2651350347215574765L;

	@PrimaryKey
	private Integer commentid;

	@ForeignKey
	private Integer userid;
	
	@ForeignKeyList(fkClass=UserInfo.class,fkField="userid",fkValue="userid",keyName="UserInfo")
	private UserInfo userInfo;

	@ForeignKey
	private Integer commodityid;

	@ForeignKey
	private Integer merchantid;

	/**
	 * 0：未审核 <br/>
	 * 1：已审核 <br/>
	 * 2：已删除
	 */
	private Integer flag = 0;

	private String comment;

	private Timestamp updatetime = new Timestamp(new Date().getTime());

	private String uuid;

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(Integer commodityid) {
		this.commodityid = commodityid;
	}

	public Integer getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}
}
