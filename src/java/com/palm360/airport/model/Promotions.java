package com.palm360.airport.model;

import java.io.Serializable;
import java.util.Date;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 优惠信息
 * 
 * @author xzl
 * 
 */
public class Promotions extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = -5481862972769376015L;

	@PrimaryKey
	private Integer promotionsid;

	@ForeignKey
	private Integer merchantid;

	private String promotionstitle;

	private Float oldprice;

	private Float newprice;

	private Float discount;

	private Date recoredtime;

	private String content;

	private Date outofdate;

	public Integer getPromotionsid() {
		return promotionsid;
	}

	public void setPromotionsid(Integer promotionsid) {
		this.promotionsid = promotionsid;
	}

	public Integer getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}

	public String getPromotionstitle() {
		return promotionstitle;
	}

	public void setPromotionstitle(String promotionstitle) {
		this.promotionstitle = promotionstitle;
	}

	public Float getOldprice() {
		return oldprice;
	}

	public void setOldprice(Float oldprice) {
		this.oldprice = oldprice;
	}

	public Float getNewprice() {
		return newprice;
	}

	public void setNewprice(Float newprice) {
		this.newprice = newprice;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Date getRecoredtime() {
		return recoredtime;
	}

	public void setRecoredtime(Date recoredtime) {
		this.recoredtime = recoredtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOutofdate() {
		return outofdate;
	}

	public void setOutofdate(Date outofdate) {
		this.outofdate = outofdate;
	}
}
