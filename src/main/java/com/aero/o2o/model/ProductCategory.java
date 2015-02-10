package com.aero.o2o.model;

import java.io.Serializable;
import java.util.List;

public class ProductCategory extends BasePojo implements Serializable {
	
	private static final long serialVersionUID = -2338026421066624924L;
	
	private Integer pCategoryId;
	
	private String pCategoryName;
	
	private Integer pCategoryDepth;
	
	private Integer parentId;
	
	private String hotCategory;
	
	private List<ProductCategory> childCategorys;

	public Integer getpCategoryId() {
		return pCategoryId;
	}

	public void setpCategoryId(Integer pCategoryId) {
		this.pCategoryId = pCategoryId;
	}

	public String getpCategoryName() {
		return pCategoryName;
	}

	public void setpCategoryName(String pCategoryName) {
		this.pCategoryName = pCategoryName;
	}

	public Integer getpCategoryDepth() {
		return pCategoryDepth;
	}

	public void setpCategoryDepth(Integer pCategoryDepth) {
		this.pCategoryDepth = pCategoryDepth;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<ProductCategory> getChildCategorys() {
		return childCategorys;
	}

	public void setChildCategorys(List<ProductCategory> childCategorys) {
		this.childCategorys = childCategorys;
	}

	public String getHotCategory() {
		return hotCategory;
	}

	public void setHotCategory(String hotCategory) {
		this.hotCategory = hotCategory;
	}
	
}
