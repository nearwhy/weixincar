package com.aero.o2o.model;

import java.io.Serializable;

public class ProductPic extends BasePojo implements Serializable {
	
	private static final long serialVersionUID = -2338026421066624924L;

	private Integer id;
	
	private String picUrl;
	
	private Integer productId;
	
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
