package com.palm360.airport.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.palm360.airport.util.stereotype.DBIndexKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * PK和FK必须写在最上方: 1.PK 2.FK1 3.FK3 4.other...
 * 
 * @author palm360
 * 
 */
@Entity
@Table(name = "UserInfo")
public class UserInfo extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = 1L;

	public UserInfo() {
	}

	public UserInfo(Integer userID) {
		this.userID = userID;
	}
	
	public UserInfo(String email) {
		this.email = email;
	}

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID", nullable = false)
	@PrimaryKey
	private Integer userID;

	@Column(name = "password", nullable = false)
	@NotNull(message = "{user.err.passnull.message}")
	// @Length(min=3,message="{user.err.passnull}")
	private String password;

	// @Column(name = "fkId", nullable = false)
	// @ForeignKey(tableName = "tableName")
	// private int fkId;

	@Column(name = "nickName", nullable = false)
	@DBIndexKey
	private String nickName;

	@Column(name = "EMail", length = 100)
	@DBIndexKey
	private String email;

	@Column(name = "Mobile", length = 20)
	@DBIndexKey
	private String mobile;

	@Column(name = "Integral")
	private Integer integral;

	@Column(name = "Sex", length = 1)
	private Integer sex = 0;

	@Column(name = "IntegralValidity", length = 0)
	private Timestamp integralValidity;

	@Column(name = "RegTime", length = 0)
	private Timestamp regTime;

	@Column(name = "UUID", length = 50)
	private String uuid;

	@Column(name = "Comment", length = 500)
	private String comment;

	@Column(name = "birth", length = 0)
	private Timestamp birth;

	// @ForeignKeyClass(tableName = "tableName", fk = "fkId", fkFieldName =
	// "Name")
	// private String fkName;
	
	private String loginIp;
	
	private String loginUuid;
	
	private String loginDevice;

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginUuid() {
		return loginUuid;
	}

	public void setLoginUuid(String loginUuid) {
		this.loginUuid = loginUuid;
	}

	public String getLoginDevice() {
		return loginDevice;
	}

	public void setLoginDevice(String loginDevice) {
		this.loginDevice = loginDevice;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getUserID() {
		return userID;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Timestamp getIntegralValidity() {
		return integralValidity;
	}

	public void setIntegralValidity(Timestamp integralValidity) {
		this.integralValidity = integralValidity;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getBirth() {
		return birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

//	@Override
//	public String toString() {
//		return "UserInfo [birth=" + birth + ", comment=" + comment + ", email="
//				+ email + ", integral=" + integral + ", integralValidity="
//				+ integralValidity + ", mobile=" + mobile + ", nickName="
//				+ nickName + ", password=" + password + ", regTime=" + regTime
//				+ ", sex=" + sex + ", userID=" + userID + ", uuid=" + uuid
//				+ "]";
//	}

}
