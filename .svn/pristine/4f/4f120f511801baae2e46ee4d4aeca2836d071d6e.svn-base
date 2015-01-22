package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

public class Commoditypic extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = 8887397278691819677L;

	@PrimaryKey
	private Integer id;

	@ForeignKey
	private Integer commodityid;

	private String fullPath;// 图片路径

	private String name;// 图片名称

	private String content;// 介绍内容

	private Integer isDefault;// 是否默认显示图片

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(Integer commodityid) {
		this.commodityid = commodityid;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
}
