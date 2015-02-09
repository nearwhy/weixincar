package com.aero.o2o.model;

import java.io.Serializable;
import java.util.List;

public class Product extends BasePojo implements Serializable {
	
	private static final long serialVersionUID = -2338026421066624924L;

	private Integer id;
	
	private String name;
	
	private Double price;
	
	private Double oldPrice;
	
	private String description;
	
	private Integer upkeepItemId;
	
	private Integer categoryId;
	
	private String categoryName;
	
	private String image;
	
	private List<ProductPic> productPics;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUpkeepItemId() {
		return upkeepItemId;
	}

	public void setUpkeepItemId(Integer upkeepItemId) {
		this.upkeepItemId = upkeepItemId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ProductPic> getProductPics() {
		return productPics;
	}

	public void setProductPics(List<ProductPic> productPics) {
		this.productPics = productPics;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
}
