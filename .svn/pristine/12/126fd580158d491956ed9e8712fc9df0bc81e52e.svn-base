package com.palm360.airport.model;

import java.io.Serializable;
import java.util.List;

import com.palm360.airport.model.Merchanttype;
import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.ForeignKeyList;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;
import com.palm360.airport.util.stereotype.SortedSet;

/**
 * 商户信息
 * @author xzl
 *
 */
public class Merchantinfo extends BaseModel implements Serializable {
    
	@NoCache
	private static final long serialVersionUID = -4966231694925761943L;
	
	public Merchantinfo() {
	}
	
	public Merchantinfo(Integer merchantid) {
		this.merchantid = merchantid;
	}

	@PrimaryKey
    private Integer merchantid;
	
    @ForeignKey
    private Integer airterminalid;

    @ForeignKey
    private Integer mtid;

    private String merchantname;

    @SortedSet
    //@UnionSortedSetKey(keys={"airterminalid","floor"})
    private Float longitude;
    @SortedSet
    private Float latitude;

    private String tel;

    private String address;

    private String content;

    private Integer level;

    private Integer isolationarea;

    private Integer publicfacility;

    private String longkey;

    //@ForeignKey
    @SortedSet
    private Integer floor;

    private String businesshours;

    private Integer haspromotions;
    
    private Merchanttype type;
    
    private List<Usercomment> userComments;

    public List<Usercomment> getUserComments() {
		return userComments;
	}

	public void setUserComments(List<Usercomment> userComments) {
		this.userComments = userComments;
	}

	public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getMtid() {
        return mtid;
    }

    public void setMtid(Integer mtid) {
        this.mtid = mtid;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsolationarea() {
        return isolationarea;
    }

    public void setIsolationarea(Integer isolationarea) {
        this.isolationarea = isolationarea;
    }

    public Integer getPublicfacility() {
        return publicfacility;
    }

    public void setPublicfacility(Integer publicfacility) {
        this.publicfacility = publicfacility;
    }

    public String getLongkey() {
        return longkey;
    }

    public void setLongkey(String longkey) {
        this.longkey = longkey;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getBusinesshours() {
        return businesshours;
    }

    public void setBusinesshours(String businesshours) {
        this.businesshours = businesshours;
    }

    public Integer getHaspromotions() {
        return haspromotions;
    }

    public void setHaspromotions(Integer haspromotions) {
        this.haspromotions = haspromotions;
    }

	public void setAirterminalid(Integer airterminal) {
		this.airterminalid = airterminal;
	}

	public Integer getAirterminalid() {
		return airterminalid;
	}
	
//	public String toString(){
//		StringBuffer sb = new StringBuffer();
//		List<String> list = AirPortUtil.getClassFieldName(this.getClass());
//		for(String str:list){
//			Object o = AirPortUtil.getProperty(this, str);
//			if(o != null){
//				sb.append(str);
//				sb.append(":");
//				sb.append(o);
//				sb.append("_");
//			}
//		}
//		return sb.toString();
//	}
}
