package com.aero.o2o.web.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.aero.o2o.dao.O2ODao;
import com.aero.o2o.dao.impl.O2ODaoImpl;
import com.aero.o2o.model.Car;
import com.aero.o2o.util.ConstantData;

public class InitServlet extends HttpServlet {

	@Autowired
	protected O2ODao o2oDao;
	
	@Override
	public void init() throws ServletException {
		
		// TODO Auto-generated method stub
		List<Car> carList = o2oDao.queryForList("Product.queryAll", null);
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
		super.init();
	}
}
