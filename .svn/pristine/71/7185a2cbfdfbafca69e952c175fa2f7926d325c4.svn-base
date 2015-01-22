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
public class RegisterPromotionsList extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = -3690661653949658152L;

	@PrimaryKey
	private Integer promotionsListId;

	@ForeignKey
	private Integer promotionsId;

	@ForeignKey
	private Integer commodityId;

	public Integer getPromotionsListId() {
		return promotionsListId;
	}

	public void setPromotionsListId(Integer promotionsListId) {
		this.promotionsListId = promotionsListId;
	}

	public Integer getPromotionsId() {
		return promotionsId;
	}

	public void setPromotionsId(Integer promotionsId) {
		this.promotionsId = promotionsId;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

}
