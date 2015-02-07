package com.aero.o2o.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aero.o2o.model.Car;
import com.aero.o2o.model.QueryParam;
import com.aero.o2o.model.User;
import com.aero.o2o.util.ConstantData;


@Controller("CarController")
public class CarController extends BaseController{
	
	//获取汽车品牌列表
	@RequestMapping(value = "/carBrand", method = RequestMethod.GET)
	public String carBrand(HttpServletRequest request, Map<String, Object> map) throws Exception{
		map.put("letters", ConstantData.getInstance(o2oDao).getLetters());
		return "carBrand";
	}
	

	@RequestMapping(value = "/carType", method = RequestMethod.GET)
	public String carType(HttpServletRequest request, Map<String, Object> map) throws Exception{
		String brand = request.getParameter("brand");
		brand = new String(brand.getBytes("ISO-8859-1"), "utf-8") ;
		Map<String,List<String>> firmMap = new HashMap<String, List<String>>();
		Map<String,List<String>> brandMap = new HashMap<String, List<String>>();
		brandMap = ConstantData.getInstance(o2oDao).getBrandMap();
		for(String firm:brandMap.get(brand)){
			firmMap.put(firm, ConstantData.getInstance(o2oDao).getFirmMap().get(firm));
		}
		map.put("firms",firmMap);
		return "carType";
	}
	
	
	@RequestMapping(value = "/carModel", method = RequestMethod.GET)
	public String carModel(HttpServletRequest request, Map<String, Object> map) throws Exception{
		String type = request.getParameter("type");
		type = new String(type.getBytes("ISO-8859-1"), "utf-8") ;
		Map<Integer,List<Car>> yearMap = new HashMap<Integer, List<Car>>();
		Map<String,List<Integer>> typeMap = new HashMap<String, List<Integer>>();
		typeMap = ConstantData.getInstance(o2oDao).getTypeMap();
		for(Integer year:typeMap.get(type)){
			yearMap.put(year, ConstantData.getInstance(o2oDao).getYearMap().get(year+"-"+type));
		}
		map.put("years",yearMap);
		return "carModel";
	}
	
	//查询我的车型
	@RequestMapping(value = "/mycar", method = RequestMethod.GET)
	public String mycar(HttpServletRequest request, Map<String, Object> map) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		System.out.println("user:"+user.getId()+","+user.getCarId());
		QueryParam qp = new QueryParam();
		qp.put("userId",user.getId());
		List<Car> list = o2oDao.queryForList("Car.queryMyCar", qp);
		map.put("cars", list);
		return "mycar";
	}
	
	//新增一个车型
	@RequestMapping(value = "/chooseCar", method = RequestMethod.POST)
	@Transactional
	public String chooseCar(HttpServletRequest request, Map<String, Object> map) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		System.out.println("user:"+user.getId()+","+user.getCarId());
		Integer carId = Integer.valueOf(request.getParameter("carId"));
		System.out.println("carid="+carId);
		QueryParam qp = new QueryParam();
		qp.put("userId",user.getId());
		qp.put("carId",carId);
		o2oDao.update("Car.updateUserCar", qp);
		o2oDao.insert("Car.insertUserCar", qp);
		return "redirect:/mycar.html";
	}

	//将某个车型设置为当前默认
	@RequestMapping(value = "/setMyCar", method = RequestMethod.POST)
	@Transactional
	public void setMyCar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		Integer carId = Integer.valueOf(request.getParameter("carId"));
		QueryParam qp = new QueryParam();
		qp.put("userId",user.getId());
		o2oDao.update("Car.updateUserCar", qp);
		qp.put("carId",carId);
		o2oDao.update("Car.updateUserCarUsed", qp);
		renderAjaxData(response, "");
	}

	//移除某个车型
	@RequestMapping(value = "/removeMyCar", method = RequestMethod.POST)
	@Transactional
	public String removeMyCar(HttpServletRequest request, Map<String, Object> map) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		Integer carId = Integer.valueOf(request.getParameter("carId"));
		QueryParam qp = new QueryParam();
		qp.put("userId",user.getId());
		qp.put("carId",carId);
		o2oDao.update("Car.deleteUserCar", qp);
		return "redirect:/mycar.html";
	}
	
	//添加车型时搜索车型
	@RequestMapping(value = "/searchCar", method = RequestMethod.GET)
	public void searchCar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String keyword = request.getParameter("keyword");
		keyword = new String(keyword.getBytes("ISO-8859-1"), "utf-8") ;
		QueryParam qp = new QueryParam();
		qp.put("keyword",keyword);
		List<Car> list = o2oDao.queryForList("Car.queryCar", qp);
		renderAjaxData(response,JSONArray.fromObject(list).toString());
	}
}
