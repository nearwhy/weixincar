package com.aero.o2o.util;

import java.io.Serializable;

public class CountResult implements Serializable{
	private static final long serialVersionUID = -901371342811311656L;
	private Integer recordId;
	private Integer recordCount;
	private String recordName;
	private double rate;//
	//getters and setters =========================
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
