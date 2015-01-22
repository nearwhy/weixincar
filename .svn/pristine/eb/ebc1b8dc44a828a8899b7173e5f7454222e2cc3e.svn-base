package com.palm360.airport.redisimpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.lang.time.StopWatch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.palm360.airport.dao.MerchantinfoDao;
import com.palm360.airport.model.Merchantinfo;
import com.palm360.airport.util.AirportQueryP;

public class MerchantinfoRedisImpl extends BaseRedis {

	// public List queryMerchatinInfoByGisForMap(AirportQueryP qp) throws
	// NumberFormatException, IllegalAccessException, InvocationTargetException,
	// NoSuchMethodException{
	// Object params = qp.getParams();
	//
	// BeanUtilsBean bub = BeanUtilsBean2.getInstance();
	// double la = Double.parseDouble(bub.getProperty(params, "latitude"));
	// double lo = Double.parseDouble(bub.getProperty(params, "longitude"));
	// int F = Integer.parseInt(bub.getProperty(params, "floor"));
	// int T = Integer.parseInt(bub.getProperty(params, "airterminalid"));
	// int S = Integer.parseInt(bub.getProperty(params, "isolationarea"));
	// //Jedis redis = this.getRedisUtilEx().getEdis().getConnection();
	//
	// String key1 =
	// this.getRedisUtilEx().saveSortedSetForGis(this.getKey(),"latitude",la-MIN,la+MAX);
	// String key2 =
	// this.getRedisUtilEx().saveSortedSetForGis(this.getKey(),"longitude",lo-MIN,
	// lo+MAX);
	// Set set = this.getRedisUtilEx().interStoreForGis(key1,key2);
	// List<String> pks = new ArrayList<String>();
	// List rlist = new ArrayList();
	// pks.addAll(set);
	//		
	// for(String pk:pks){
	// Object value = this.getRedisUtilEx().getObjectByHash(this.getKey(),
	// this.getEntity(), pk, false);
	// if(F == Integer.parseInt(bub.getProperty(value, "floor"))
	// && S == Integer.parseInt(bub.getProperty(value, ""))
	// && T == Integer.parseInt(bub.getProperty(value, ""))){
	// rlist.add(value);
	// }
	// }
	// //this.getRedisUtilEx().getEdis().returnResource(redis);
	// return rlist;
	// }

	public static void main(String[] a) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-servlet2.xml");
		// RedisUtilEx rue = (RedisUtilEx) ctx.getBean("redisEx");
		MerchantinfoDao mi = (MerchantinfoDao) ctx.getBean("merchantInfoDao");
		// MerchantinfoRedisImpl mi = new MerchantinfoRedisImpl();
		// mi.setKey("Merchantinfo");
		// mi.setEntity(Merchantinfo.class);
		// mi.setRedisUtilEx(rue);
		AirportQueryP qp = new AirportQueryP();
		Merchantinfo m = new Merchantinfo();
		// m.setLatitude(116.0698f);
		// m.setLongitude(39.0345f);//116.0211f);
		// m.setFloor(4);
		// m.setLevel(3);
		// m.setIsolationarea(2);
		// m.setAirterminalid(3);
		m.setLatitude(116.1562f);
		m.setLongitude(39.0921f);
		m.setPublicfacility(1);
		// m.setFloor(4);
		// m.setIsolationarea(1);
		// m.setAirterminalid(1);

		qp.setParams(m);
		qp.setAsc(true);
		qp.setStart(0);
		qp.setSize(100);
		StopWatch sw = new StopWatch();
		for(int i=0;i<3;i++){
			sw.reset();
			sw.start();
			List list = mi.queryMerchantInfoByGps(qp);
			System.out.println(list.size());
			sw.stop();
			System.out.println("++++++++++++++total++++++" + sw.getTime());
			// System.out.println(list);
	//		for (int i = 0; i < list.size(); i++) {
	//			Merchantinfo o = (Merchantinfo) list.get(i);
	//			System.out.println(o);
	////			System.out.println(o.getMerchantid()
	////					+ "--------"
	////					+ o.getLatitude()
	////					+ "----"
	////					+ o.getLongitude()
	////					+ "-----"
	////					+ MerchantinfoRedisImpl.getDis(Double.parseDouble(o.getLatitude().toString()), Double.parseDouble(o.getLongitude().toString()), (Double) 116.1562d,
	////							(Double) 39.0921d));
	//		}
			System.out.println("------------------" + list.size());
		}
		System.exit(0);

	}

	/**
	 * 检索地图或是poi 或商户信息内容
	 * 
	 * @throws Exception
	 */
	public List queryMerchantInfoByGps(AirportQueryP qp) throws Exception {
		Object params = qp.getParams();
		// if(true) return null;
		BeanUtilsBean bub = BeanUtilsBean2.getInstance();
		double la = Double.parseDouble(bub.getProperty(params, "latitude"));
		double lo = Double.parseDouble(bub.getProperty(params, "longitude"));
		int F = 0;
		boolean bf = false;
		if (null != bub.getProperty(params, "floor")) {
			F = Integer.parseInt(bub.getProperty(params, "floor"));
			bf = true;
		}
		int T = 0;
		boolean bt = false;
		if (null != bub.getProperty(params, "airterminalid")) {
			T = Integer.parseInt(bub.getProperty(params, "airterminalid"));
			bt = true;
		}

		int S = 0;
		boolean bs = false;
		if (null != bub.getProperty(params, "isolationarea")) {
			S = Integer.parseInt(bub.getProperty(params, "isolationarea"));
			bs = true;
		}
		int L = 0;
		boolean bl = false;
		if (bub.getProperty(params, "level") != null) {
			L = Integer.parseInt(bub.getProperty(params, "level"));
			bl = true;
		}
//		setPublicfacility
		int P=0;
		boolean bp=false;
		if (bub.getProperty(params, "publicfacility") != null) {
			P = Integer.parseInt(bub.getProperty(params, "publicfacility"));
			bp=true;
		}
		boolean asc = true;
		if (!qp.isAsc())
			asc = false;
		String key1 = this.getRedisUtilEx().saveSortedSetForGis(this.getKey(), "latitude", la - MIN, la + MAX);
		String key2 = this.getRedisUtilEx().saveSortedSetForGis(this.getKey(), "longitude", lo - MIN, lo + MAX);
		Set set = this.getRedisUtilEx().interStoreForGis(key1, key2);
		List<String> pks = new ArrayList<String>();
		if (set == null) {
			log.info("have no more latitude");
			return null;
		}
		List rlist = new ArrayList();
		pks.addAll(set);
		int st = qp.getStart();

		int j = 0;
		List pkss = this.getRedisUtilEx().getListByHash(this.getKey(), this.getEntity(), pks);
		for (int i = 0; i < pkss.size(); i++) {
			String pk = pks.get(i);
			Object value = pkss.get(i);
			boolean badd = true;
			if (bf) {
				if (F != Integer.parseInt(bub.getProperty(value, "floor")))
					badd = false;
			}
			if (bs) {
				if (S != Integer.parseInt(bub.getProperty(value, "isolationarea")))
					badd = false;
			}
			if (bl) {
				if (L > Integer.parseInt(bub.getProperty(value, "level")))
					badd = false;
			}
			if (bt) {
				if (T != Integer.parseInt(bub.getProperty(value, "airterminalid")))
					badd = false;
			}
			if(bp){
				if(P != Integer.parseInt(bub.getProperty(value, "publicfacility")))
					badd = false;
			}
			if (badd) {
				rlist.add(value);
			}
		}
		Merchantinfo[] rls = (Merchantinfo[]) rlist.toArray(new Merchantinfo[] {});
		Merchantinfo temp = null;
		for (int i = 1; i < rls.length; i++) {
			for (int m = rls.length - 1; m >= i; m--) {
				double ds0 = getDis(Double.parseDouble(((Merchantinfo) rls[m - 1]).getLatitude().toString()), Double.parseDouble(((Merchantinfo) rls[m - 1]).getLongitude()
						.toString()), (Double) la, (Double) lo);
				double ds1 = getDis(Double.parseDouble(((Merchantinfo) rls[m]).getLatitude().toString()), Double.parseDouble(((Merchantinfo) rls[m]).getLongitude().toString()),
						(Double) la, (Double) lo);
				if (asc) {
					if (ds1 < ds0) {
						temp = rls[m];
						rls[m] = rls[m - 1];
						rls[m - 1] = temp;
					}
				} else {
					if (ds1 > ds0) {
						temp = rls[m];
						rls[m] = rls[m - 1];
						rls[m - 1] = temp;
					}
				}
			}
		}
		rlist.clear();
		for (int i = 0; i < qp.getSize(); i++) {
			if ((i + qp.getStart()) > (rls.length - 1))
				break;
			rlist.add(rls[qp.getStart() + i]);
		}
		return rlist;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0d;
	}

	private static double getDis(Double lat1, Double lng1, Double lat2, Double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137d;
		s = Math.round(s * 10000d) / 10000d;
		return s;
	}
}
