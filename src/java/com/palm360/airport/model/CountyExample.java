package com.palm360.airport.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.palm360.airport.util.stereotype.NoCache;

public class CountyExample extends BaseModel implements Serializable{
    /**
	 * 
	 */
	@NoCache
	private static final long serialVersionUID = -3303631260748536664L;

	/**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public CountyExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    protected CountyExample(CountyExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table County
     *
     * @abatorgenerated Fri May 18 11:00:01 CST 2012
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andCountyidIsNull() {
            addCriterion("CountyID is null");
            return this;
        }

        public Criteria andCountyidIsNotNull() {
            addCriterion("CountyID is not null");
            return this;
        }

        public Criteria andCountyidEqualTo(Integer value) {
            addCriterion("CountyID =", value, "countyid");
            return this;
        }

        public Criteria andCountyidNotEqualTo(Integer value) {
            addCriterion("CountyID <>", value, "countyid");
            return this;
        }

        public Criteria andCountyidGreaterThan(Integer value) {
            addCriterion("CountyID >", value, "countyid");
            return this;
        }

        public Criteria andCountyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CountyID >=", value, "countyid");
            return this;
        }

        public Criteria andCountyidLessThan(Integer value) {
            addCriterion("CountyID <", value, "countyid");
            return this;
        }

        public Criteria andCountyidLessThanOrEqualTo(Integer value) {
            addCriterion("CountyID <=", value, "countyid");
            return this;
        }

        public Criteria andCountyidIn(List values) {
            addCriterion("CountyID in", values, "countyid");
            return this;
        }

        public Criteria andCountyidNotIn(List values) {
            addCriterion("CountyID not in", values, "countyid");
            return this;
        }

        public Criteria andCountyidBetween(Integer value1, Integer value2) {
            addCriterion("CountyID between", value1, value2, "countyid");
            return this;
        }

        public Criteria andCountyidNotBetween(Integer value1, Integer value2) {
            addCriterion("CountyID not between", value1, value2, "countyid");
            return this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("CityID is null");
            return this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("CityID is not null");
            return this;
        }

        public Criteria andCityidEqualTo(Integer value) {
            addCriterion("CityID =", value, "cityid");
            return this;
        }

        public Criteria andCityidNotEqualTo(Integer value) {
            addCriterion("CityID <>", value, "cityid");
            return this;
        }

        public Criteria andCityidGreaterThan(Integer value) {
            addCriterion("CityID >", value, "cityid");
            return this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CityID >=", value, "cityid");
            return this;
        }

        public Criteria andCityidLessThan(Integer value) {
            addCriterion("CityID <", value, "cityid");
            return this;
        }

        public Criteria andCityidLessThanOrEqualTo(Integer value) {
            addCriterion("CityID <=", value, "cityid");
            return this;
        }

        public Criteria andCityidIn(List values) {
            addCriterion("CityID in", values, "cityid");
            return this;
        }

        public Criteria andCityidNotIn(List values) {
            addCriterion("CityID not in", values, "cityid");
            return this;
        }

        public Criteria andCityidBetween(Integer value1, Integer value2) {
            addCriterion("CityID between", value1, value2, "cityid");
            return this;
        }

        public Criteria andCityidNotBetween(Integer value1, Integer value2) {
            addCriterion("CityID not between", value1, value2, "cityid");
            return this;
        }

        public Criteria andCountynameIsNull() {
            addCriterion("CountyName is null");
            return this;
        }

        public Criteria andCountynameIsNotNull() {
            addCriterion("CountyName is not null");
            return this;
        }

        public Criteria andCountynameEqualTo(String value) {
            addCriterion("CountyName =", value, "countyname");
            return this;
        }

        public Criteria andCountynameNotEqualTo(String value) {
            addCriterion("CountyName <>", value, "countyname");
            return this;
        }

        public Criteria andCountynameGreaterThan(String value) {
            addCriterion("CountyName >", value, "countyname");
            return this;
        }

        public Criteria andCountynameGreaterThanOrEqualTo(String value) {
            addCriterion("CountyName >=", value, "countyname");
            return this;
        }

        public Criteria andCountynameLessThan(String value) {
            addCriterion("CountyName <", value, "countyname");
            return this;
        }

        public Criteria andCountynameLessThanOrEqualTo(String value) {
            addCriterion("CountyName <=", value, "countyname");
            return this;
        }

        public Criteria andCountynameLike(String value) {
            addCriterion("CountyName like", value, "countyname");
            return this;
        }

        public Criteria andCountynameNotLike(String value) {
            addCriterion("CountyName not like", value, "countyname");
            return this;
        }

        public Criteria andCountynameIn(List values) {
            addCriterion("CountyName in", values, "countyname");
            return this;
        }

        public Criteria andCountynameNotIn(List values) {
            addCriterion("CountyName not in", values, "countyname");
            return this;
        }

        public Criteria andCountynameBetween(String value1, String value2) {
            addCriterion("CountyName between", value1, value2, "countyname");
            return this;
        }

        public Criteria andCountynameNotBetween(String value1, String value2) {
            addCriterion("CountyName not between", value1, value2, "countyname");
            return this;
        }

        public Criteria andLlongitudeIsNull() {
            addCriterion("llongitude is null");
            return this;
        }

        public Criteria andLlongitudeIsNotNull() {
            addCriterion("llongitude is not null");
            return this;
        }

        public Criteria andLlongitudeEqualTo(Float value) {
            addCriterion("llongitude =", value, "llongitude");
            return this;
        }

        public Criteria andLlongitudeNotEqualTo(Float value) {
            addCriterion("llongitude <>", value, "llongitude");
            return this;
        }

        public Criteria andLlongitudeGreaterThan(Float value) {
            addCriterion("llongitude >", value, "llongitude");
            return this;
        }

        public Criteria andLlongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("llongitude >=", value, "llongitude");
            return this;
        }

        public Criteria andLlongitudeLessThan(Float value) {
            addCriterion("llongitude <", value, "llongitude");
            return this;
        }

        public Criteria andLlongitudeLessThanOrEqualTo(Float value) {
            addCriterion("llongitude <=", value, "llongitude");
            return this;
        }

        public Criteria andLlongitudeIn(List values) {
            addCriterion("llongitude in", values, "llongitude");
            return this;
        }

        public Criteria andLlongitudeNotIn(List values) {
            addCriterion("llongitude not in", values, "llongitude");
            return this;
        }

        public Criteria andLlongitudeBetween(Float value1, Float value2) {
            addCriterion("llongitude between", value1, value2, "llongitude");
            return this;
        }

        public Criteria andLlongitudeNotBetween(Float value1, Float value2) {
            addCriterion("llongitude not between", value1, value2, "llongitude");
            return this;
        }

        public Criteria andLlatitudeIsNull() {
            addCriterion("llatitude is null");
            return this;
        }

        public Criteria andLlatitudeIsNotNull() {
            addCriterion("llatitude is not null");
            return this;
        }

        public Criteria andLlatitudeEqualTo(Float value) {
            addCriterion("llatitude =", value, "llatitude");
            return this;
        }

        public Criteria andLlatitudeNotEqualTo(Float value) {
            addCriterion("llatitude <>", value, "llatitude");
            return this;
        }

        public Criteria andLlatitudeGreaterThan(Float value) {
            addCriterion("llatitude >", value, "llatitude");
            return this;
        }

        public Criteria andLlatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("llatitude >=", value, "llatitude");
            return this;
        }

        public Criteria andLlatitudeLessThan(Float value) {
            addCriterion("llatitude <", value, "llatitude");
            return this;
        }

        public Criteria andLlatitudeLessThanOrEqualTo(Float value) {
            addCriterion("llatitude <=", value, "llatitude");
            return this;
        }

        public Criteria andLlatitudeIn(List values) {
            addCriterion("llatitude in", values, "llatitude");
            return this;
        }

        public Criteria andLlatitudeNotIn(List values) {
            addCriterion("llatitude not in", values, "llatitude");
            return this;
        }

        public Criteria andLlatitudeBetween(Float value1, Float value2) {
            addCriterion("llatitude between", value1, value2, "llatitude");
            return this;
        }

        public Criteria andLlatitudeNotBetween(Float value1, Float value2) {
            addCriterion("llatitude not between", value1, value2, "llatitude");
            return this;
        }

        public Criteria andRlongitudeIsNull() {
            addCriterion("rlongitude is null");
            return this;
        }

        public Criteria andRlongitudeIsNotNull() {
            addCriterion("rlongitude is not null");
            return this;
        }

        public Criteria andRlongitudeEqualTo(Float value) {
            addCriterion("rlongitude =", value, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeNotEqualTo(Float value) {
            addCriterion("rlongitude <>", value, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeGreaterThan(Float value) {
            addCriterion("rlongitude >", value, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("rlongitude >=", value, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeLessThan(Float value) {
            addCriterion("rlongitude <", value, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeLessThanOrEqualTo(Float value) {
            addCriterion("rlongitude <=", value, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeIn(List values) {
            addCriterion("rlongitude in", values, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeNotIn(List values) {
            addCriterion("rlongitude not in", values, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeBetween(Float value1, Float value2) {
            addCriterion("rlongitude between", value1, value2, "rlongitude");
            return this;
        }

        public Criteria andRlongitudeNotBetween(Float value1, Float value2) {
            addCriterion("rlongitude not between", value1, value2, "rlongitude");
            return this;
        }

        public Criteria andRlatitudeIsNull() {
            addCriterion("rlatitude is null");
            return this;
        }

        public Criteria andRlatitudeIsNotNull() {
            addCriterion("rlatitude is not null");
            return this;
        }

        public Criteria andRlatitudeEqualTo(Float value) {
            addCriterion("rlatitude =", value, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeNotEqualTo(Float value) {
            addCriterion("rlatitude <>", value, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeGreaterThan(Float value) {
            addCriterion("rlatitude >", value, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeGreaterThanOrEqualTo(Float value) {
            addCriterion("rlatitude >=", value, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeLessThan(Float value) {
            addCriterion("rlatitude <", value, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeLessThanOrEqualTo(Float value) {
            addCriterion("rlatitude <=", value, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeIn(List values) {
            addCriterion("rlatitude in", values, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeNotIn(List values) {
            addCriterion("rlatitude not in", values, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeBetween(Float value1, Float value2) {
            addCriterion("rlatitude between", value1, value2, "rlatitude");
            return this;
        }

        public Criteria andRlatitudeNotBetween(Float value1, Float value2) {
            addCriterion("rlatitude not between", value1, value2, "rlatitude");
            return this;
        }

        public Criteria andLongkeyIsNull() {
            addCriterion("LongKey is null");
            return this;
        }

        public Criteria andLongkeyIsNotNull() {
            addCriterion("LongKey is not null");
            return this;
        }

        public Criteria andLongkeyEqualTo(String value) {
            addCriterion("LongKey =", value, "longkey");
            return this;
        }

        public Criteria andLongkeyNotEqualTo(String value) {
            addCriterion("LongKey <>", value, "longkey");
            return this;
        }

        public Criteria andLongkeyGreaterThan(String value) {
            addCriterion("LongKey >", value, "longkey");
            return this;
        }

        public Criteria andLongkeyGreaterThanOrEqualTo(String value) {
            addCriterion("LongKey >=", value, "longkey");
            return this;
        }

        public Criteria andLongkeyLessThan(String value) {
            addCriterion("LongKey <", value, "longkey");
            return this;
        }

        public Criteria andLongkeyLessThanOrEqualTo(String value) {
            addCriterion("LongKey <=", value, "longkey");
            return this;
        }

        public Criteria andLongkeyLike(String value) {
            addCriterion("LongKey like", value, "longkey");
            return this;
        }

        public Criteria andLongkeyNotLike(String value) {
            addCriterion("LongKey not like", value, "longkey");
            return this;
        }

        public Criteria andLongkeyIn(List values) {
            addCriterion("LongKey in", values, "longkey");
            return this;
        }

        public Criteria andLongkeyNotIn(List values) {
            addCriterion("LongKey not in", values, "longkey");
            return this;
        }

        public Criteria andLongkeyBetween(String value1, String value2) {
            addCriterion("LongKey between", value1, value2, "longkey");
            return this;
        }

        public Criteria andLongkeyNotBetween(String value1, String value2) {
            addCriterion("LongKey not between", value1, value2, "longkey");
            return this;
        }

        public Criteria andSortkeyIsNull() {
            addCriterion("SortKey is null");
            return this;
        }

        public Criteria andSortkeyIsNotNull() {
            addCriterion("SortKey is not null");
            return this;
        }

        public Criteria andSortkeyEqualTo(String value) {
            addCriterion("SortKey =", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyNotEqualTo(String value) {
            addCriterion("SortKey <>", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyGreaterThan(String value) {
            addCriterion("SortKey >", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyGreaterThanOrEqualTo(String value) {
            addCriterion("SortKey >=", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyLessThan(String value) {
            addCriterion("SortKey <", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyLessThanOrEqualTo(String value) {
            addCriterion("SortKey <=", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyLike(String value) {
            addCriterion("SortKey like", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyNotLike(String value) {
            addCriterion("SortKey not like", value, "sortkey");
            return this;
        }

        public Criteria andSortkeyIn(List values) {
            addCriterion("SortKey in", values, "sortkey");
            return this;
        }

        public Criteria andSortkeyNotIn(List values) {
            addCriterion("SortKey not in", values, "sortkey");
            return this;
        }

        public Criteria andSortkeyBetween(String value1, String value2) {
            addCriterion("SortKey between", value1, value2, "sortkey");
            return this;
        }

        public Criteria andSortkeyNotBetween(String value1, String value2) {
            addCriterion("SortKey not between", value1, value2, "sortkey");
            return this;
        }
    }
}
