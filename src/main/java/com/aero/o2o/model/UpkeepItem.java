package com.aero.o2o.model;

import java.io.Serializable;

public class UpkeepItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338026421066624924L;

	private Integer id;
	
	private String name;
	
	private Float manhourprice;

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

	public Float getManhourprice() {
		return manhourprice;
	}

	public void setManhourprice(Float manhourprice) {
		this.manhourprice = manhourprice;
	}
	
	
}
