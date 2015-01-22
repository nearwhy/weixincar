package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.DBIndexKey;
import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

public class Airport extends BaseModel implements Serializable{
    /**
	 * 
	 */
	@NoCache
	private static final long serialVersionUID = -3730351919849247576L;

	@PrimaryKey
    private Integer airportid;

    @ForeignKey
    private Integer countyid;

    @DBIndexKey
    private String airportname;

    public Integer getAirportid() {
        return airportid;
    }

    public void setAirportid(Integer airportid) {
        this.airportid = airportid;
    }

    public Integer getCountyid() {
        return countyid;
    }

    public void setCountyid(Integer countyid) {
        this.countyid = countyid;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }
}
