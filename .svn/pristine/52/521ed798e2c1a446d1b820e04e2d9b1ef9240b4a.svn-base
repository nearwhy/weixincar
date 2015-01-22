package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

/**
 * 航站楼，楼层所对应的地图
 * 
 * @author xzl
 * 
 */
public class Terminalmaps extends BaseModel implements Serializable {

	@NoCache
	private static final long serialVersionUID = 6895740670218157769L;

	@PrimaryKey
	private Integer terminalmapsid;

	@ForeignKey
	private Integer airterminalid;

	private Integer floor;

	private String map;

	private Float x;

	private Float y;

	private Float width;

	private Float height;

	public Integer getTerminalmapsid() {
		return terminalmapsid;
	}

	public void setTerminalmapsid(Integer terminalmapsid) {
		this.terminalmapsid = terminalmapsid;
	}

	public Integer getAirterminalid() {
		return airterminalid;
	}

	public void setAirterminalid(Integer airterminalid) {
		this.airterminalid = airterminalid;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}
}
