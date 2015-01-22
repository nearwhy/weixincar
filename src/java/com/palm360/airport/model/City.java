package com.palm360.airport.model;

import java.io.Serializable;

import com.palm360.airport.util.stereotype.DBIndexKey;
import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

public class City extends BaseModel implements Serializable{
    
	@NoCache
	private static final long serialVersionUID = -5592394879675955880L;

	@PrimaryKey
    private Integer cityid;

    @ForeignKey
    private Integer provinceid;

    @DBIndexKey
    private String cityname;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}
