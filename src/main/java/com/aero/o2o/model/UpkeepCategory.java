package com.aero.o2o.model;

import java.io.Serializable;
import java.util.List;

public class UpkeepCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8397339146781267500L;

	private Integer id;
	
	private String name;
	
	private List<UpkeepItem> items;

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

	public List<UpkeepItem> getItems() {
		return items;
	}

	public void setItems(List<UpkeepItem> items) {
		this.items = items;
	}
	
	
}
