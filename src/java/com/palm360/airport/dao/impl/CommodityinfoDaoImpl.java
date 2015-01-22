package com.palm360.airport.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.palm360.airport.dao.CommodityinfoDao;
import com.palm360.airport.model.Commodityinfo;
import com.palm360.airport.model.RegisterPromotions;
import com.palm360.airport.redis.RedisUtilEx;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.stereotype.EntityKeyName;

@Repository("commodityInfoDao")
@EntityKeyName(entity = Commodityinfo.class, keyName = "Commodityinfo")
public class CommodityinfoDaoImpl extends BaseDaoImpl implements
		CommodityinfoDao {
	
	private SqlMapClientTemplate sqlMapClient;

	public CommodityinfoDaoImpl() {
		super();
		this.sqlMapClient = this.getSqlMapClientTemplate();
	}

	public void insert(Commodityinfo record) throws SQLException {
		sqlMapClient.insert("CommodityInfo.insert", record);
	}

	public int updateByPrimaryKey(Commodityinfo record) throws SQLException {
		int rows = sqlMapClient.update(
				"CommodityInfo.updateByPrimaryKey", record);
		return rows;
	}

	public int updateByPrimaryKeySelective(Commodityinfo record)
			throws SQLException {
		int rows = sqlMapClient.update(
				"CommodityInfo.updateByPrimaryKeySelective",
				record);
		return rows;
	}

	public Commodityinfo selectByPrimaryKey(Integer commodityid)
			throws SQLException {
		Commodityinfo key = new Commodityinfo();
		key.setCommodityid(commodityid);
		Commodityinfo record = (Commodityinfo) sqlMapClient.queryForObject(
				"CommodityInfo.selectByPrimaryKey", key);
		return record;
	}

	public int deleteByPrimaryKey(Integer commodityid) throws SQLException {
		Commodityinfo key = new Commodityinfo();
		key.setCommodityid(commodityid);
		int rows = sqlMapClient.delete(
				"CommodityInfo.deleteByPrimaryKey", key);
		return rows;
	}

	public List queryAll(int size, int page) {
		return super.queryAll("CommodityInfo.queryAll", new AirportQueryP(page,
				size));
	}

	public int queryAllCount() {
		return super.queryAllCount("CommodityInfo.queryAllCount");
	}
	
	
	public static void main(String[] args) throws SQLException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-servlet2.xml");
		CommodityinfoDao cd = (CommodityinfoDao) ctx.getBean("commodityInfoDao");
		Commodityinfo ci = new Commodityinfo();
//		ci.setCommodityid(1);
		ci.setMerchantid(1);
		AirportQueryP qp = new AirportQueryP();
		qp.setParams(ci);
		qp.setSize(0);
		qp.setSize(10);
//		ci = cd.queryByPk(ci);
		StopWatch sw = new StopWatch();
		for(int i=0;i<10;i++){
			sw.reset();
			sw.start();
		List<Commodityinfo> list = cd.queryCommodityinfoByFk(qp);
//		if(list != null)
//			System.out.println(list.size());
//		RedisUtilEx redisUtilEx = (RedisUtilEx) ctx.getBean("redisUtilEx");
//		List list = redisUtilEx.getListByFk("Commodityinfo", "merchantid", 1, Commodityinfo.class, 0,10);
		System.out.println(list.get(0).getCommoditypics());
		sw.stop();
		System.out.println("----------------------:"+sw.getTime());
		}
	}
	/**
	 * 通过主键查询一条记录
	 */
	public Commodityinfo queryByPk(Commodityinfo commodityinfo) {
		// TODO Auto-generated method stub
		return (Commodityinfo) sqlMapClient.queryForObject("CommodityInfo.queryByPk",commodityinfo);
	}

	public List<Commodityinfo> selectByRegisterPromotionsId(Integer rpId) throws SQLException {
		RegisterPromotions rp = new RegisterPromotions();
		rp.setPromotionsId(rpId);
		List<Commodityinfo> record = sqlMapClient.queryForList("CommodityInfo.selectCommodityByRpId", rp);
		return record;
	}
	/**
	 * 通过merchantid外键查询记录
	 */
	public List queryCommodityinfoByFk(AirportQueryP qp) {
		// TODO Auto-generated method stub
		return (List) sqlMapClient.queryForList("CommodityInfo.queryCommodityinfoByFk",qp);
	}

}
