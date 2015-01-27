package com.aero.o2o.web.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import com.aero.o2o.dao.O2ODao;
import com.aero.o2o.model.Car;
import com.aero.o2o.util.ConstantData;

/**
 * 获取根路径
 * 
 * @author xzl
 * 
 */
public class WebRootListener extends ContextLoaderListener {

//	private Logger log = Logger.getLogger(WebRootListener.class);
	
	@Autowired
	protected O2ODao o2oDao;
	
	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
//		String webAppRootKey = sce.getServletContext().getRealPath("/");
//		System.setProperty("airport.root", webAppRootKey);
//		log.info("airport.root: " + System.getProperty("airport.root"));
		List<Car> carList = o2oDao.queryForList("Car.queryAll", null);
		Map<String,List<String>> letterMap = new HashMap<String,List<String>>();
		Map<String,List<String>> brandMap = new HashMap<String,List<String>>();
		Map<String,List<String>> firmMap = new HashMap<String,List<String>>();
		Map<String,List<Integer>> typeMap = new HashMap<String,List<Integer>>();
		Map<Integer,List<String>> yearMap = new HashMap<Integer,List<String>>();
		
		for(Car car:carList){
			if(!letterMap.containsKey(car.getLetter())){
				List<String> list = new ArrayList<String>();
				letterMap.put(car.getLetter(), list);
			}
			letterMap.get(car.getLetter()).add(car.getBrand());

			if(!brandMap.containsKey(car.getBrand())){
				List<String> list = new ArrayList<String>();
				brandMap.put(car.getBrand(), list);
			}
			brandMap.get(car.getBrand()).add(car.getFirm());

			if(!firmMap.containsKey(car.getFirm())){
				List<String> list = new ArrayList<String>();
				firmMap.put(car.getFirm(), list);
			}
			firmMap.get(car.getFirm()).add(car.getType());

			if(!typeMap.containsKey(car.getType())){
				List<Integer> list = new ArrayList<Integer>();
				typeMap.put(car.getType(), list);
			}
			typeMap.get(car.getType()).add(car.getYear());

			if(!yearMap.containsKey(car.getYear())){
				List<String> list = new ArrayList<String>();
				yearMap.put(car.getYear(), list);
			}
			yearMap.get(car.getYear()).add(car.getModel());
		}
//		ConstantData.getInstance().setBrandMap(brandMap);
//		ConstantData.getInstance().setFirmMap(firmMap);
//		ConstantData.getInstance().setLetterMap(letterMap);
//		ConstantData.getInstance().setTypeMap(typeMap);
//		ConstantData.getInstance().setYearMap(yearMap);
		
	}

}
