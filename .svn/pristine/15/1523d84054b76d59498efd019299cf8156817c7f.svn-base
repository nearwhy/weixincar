package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 优惠活动商品信息
 * 
 * @author xzl
 * 
 */
public class Promotionslist extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = -3690661653949658152L;

	@PrimaryKey
	private Integer promotionslistid;

	@ForeignKey
	private Integer promotionsid;

	@ForeignKey
	private Integer commodityid;

	@ForeignKey
	private Integer merchantid;

	public Integer getPromotionslistid() {
		return promotionslistid;
	}

	public void setPromotionslistid(Integer promotionslistid) {
		this.promotionslistid = promotionslistid;
	}

	public Integer getPromotionsid() {
		return promotionsid;
	}

	public void setPromotionsid(Integer promotionsid) {
		this.promotionsid = promotionsid;
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
}
