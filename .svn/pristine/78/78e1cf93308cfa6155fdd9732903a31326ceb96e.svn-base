package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.DBIndexKey;
import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

public class Airterminal extends BaseModel implements Serializable{
    /**
	 * 
	 */
	@NoCache
	private static final long serialVersionUID = -652007448255923632L;

	@PrimaryKey
    private Integer airterminalid;

    @ForeignKey
    private Integer airportid;

    @DBIndexKey
    private String airterminalname;

    @DBIndexKey
    private Integer floorcount;

    private Integer defaultfloor;

    private Float llongitude;

    private Float llatitude;

    private Float rlongitude;

    private Float rlatitude;

    private String maps;

    public Integer getAirterminalid() {
        return airterminalid;
    }

    public void setAirterminalid(Integer airterminalid) {
        this.airterminalid = airterminalid;
    }

    public Integer getAirportid() {
        return airportid;
    }

    public void setAirportid(Integer airportid) {
        this.airportid = airportid;
    }

    public String getAirterminalname() {
        return airterminalname;
    }

    public void setAirterminalname(String airterminalname) {
        this.airterminalname = airterminalname;
    }

    public Integer getFloorcount() {
        return floorcount;
    }

    public void setFloorcount(Integer floorcount) {
        this.floorcount = floorcount;
    }

    public Integer getDefaultfloor() {
        return defaultfloor;
    }

    public void setDefaultfloor(Integer defaultfloor) {
        this.defaultfloor = defaultfloor;
    }

    public Float getLlongitude() {
        return llongitude;
    }

    public void setLlongitude(Float llongitude) {
        this.llongitude = llongitude;
    }

    public Float getLlatitude() {
        return llatitude;
    }

    public void setLlatitude(Float llatitude) {
        this.llatitude = llatitude;
    }

    public Float getRlongitude() {
        return rlongitude;
    }

    public void setRlongitude(Float rlongitude) {
        this.rlongitude = rlongitude;
    }

    public Float getRlatitude() {
        return rlatitude;
    }

    public void setRlatitude(Float rlatitude) {
        this.rlatitude = rlatitude;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }
}
