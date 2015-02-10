package com.aero.o2o.model;

import java.io.Serializable;

public class StandardParam extends BasePojo implements Serializable {
	
	private static final long serialVersionUID = -2338026421066624924L;

	private Integer id;
	
	private String paramKey;
	
	private String paramValue;
	
	private Integer productId;
	
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
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

	public StandardParam() {
		super();
	}

	public StandardParam(Integer id) {
		super();
		this.id = id;
	}

	
}
