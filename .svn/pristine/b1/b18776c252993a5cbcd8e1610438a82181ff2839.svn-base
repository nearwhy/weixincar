package com.palm360.airport.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import com.palm360.airport.util.stereotype.ForeignKey;
import com.palm360.airport.util.stereotype.ForeignKeyList;
import com.palm360.airport.util.stereotype.NoCache;
import com.palm360.airport.util.stereotype.PrimaryKey;

public class Commodityinfo extends BaseModel implements Serializable{
    
	@NoCache
	private static final long serialVersionUID = 3004773752026029229L;

	@PrimaryKey
    private Integer commodityid;

    @ForeignKey
    private Integer merchantid;

    @ForeignKey
    private Integer ctid;

    private String commodityname;

    private Float oldprice;

    private Float newprice;

    private Float discount;

    private Date recordtime;

    private String content;

    private String longkey;

    private String shortkey;
    @NoCache
    @ForeignKeyList(keyName="Commoditypic",fkClass=Commoditypic.class,fkField="commodityid",fkValue="commodityid")
    private List<Commoditypic> commoditypics;

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getCommodityname() {
        return commodityname;
    }
    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
        this.setLongkey(this.getPinyin(commodityname));
        this.setShortkey(this.getShortPinyin(commodityname));
    }

    public Float getOldprice() {
        return oldprice;
    }

    public void setOldprice(Float oldprice) {
        this.oldprice = oldprice;
    }

    public Float getNewprice() {
        return newprice;
    }

    public void setNewprice(Float newprice) {
        this.newprice = newprice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLongkey() {
        return longkey;
    }

    public void setLongkey(String longkey) {
        this.longkey = longkey;
    }

    public String getShortkey() {
        return shortkey;
    }

    public void setShortkey(String shortkey) {
        this.shortkey = shortkey;
    }

	public void setCommoditypics(List<Commoditypic> commoditypics) {
		this.commoditypics = commoditypics;
	}

	public List<Commoditypic> getCommoditypics() {
		return commoditypics;
	}
}
