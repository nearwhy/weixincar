package com.palm360.airport.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 注册后的优惠信息
 * 
 * @author xzl
 * 
 */
public class RegisterPromotions extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = -5481862972769376015L;

	@PrimaryKey
	private Integer promotionsId;
	
	private Integer merchantId;

	private String promotionsName;

	private Float oldPrice;

	private Float newPrice;

	private Float disCount;

	private Timestamp recordTime;

	private Integer isFree;

	private String content;

	private Timestamp outOfDate;

	private Integer count;
	
	private Integer probability;

	public Integer getPromotionsId() {
		return promotionsId;
	}

	public void setPromotionsId(Integer promotionsId) {
		this.promotionsId = promotionsId;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public String getPromotionsName() {
		return promotionsName;
	}

	public void setPromotionsName(String promotionsName) {
		this.promotionsName = promotionsName;
	}

	public Float getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Float oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Float getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Float newPrice) {
		this.newPrice = newPrice;
	}

	public Float getDisCount() {
		return disCount;
	}

	public void setDisCount(Float disCount) {
		this.disCount = disCount;
	}

	public Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public Integer getIsFree() {
		return isFree;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getOutOfDate() {
		return outOfDate;
	}

	public void setOutOfDate(Timestamp outOfDate) {
		this.outOfDate = outOfDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getProbability() {
		return probability;
	}

	public void setProbability(Integer probability) {
		this.probability = probability;
	}

}
