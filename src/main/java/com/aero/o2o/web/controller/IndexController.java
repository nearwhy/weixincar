package com.aero.o2o.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aero.o2o.model.Product;
import com.aero.o2o.model.QueryParam;
import com.aero.o2o.model.User;
import com.aero.o2o.util.ConstantData;

@Controller("IndexController")
public class IndexController  extends BaseController {
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Map<String, Object> map) throws Exception{
		User user = new User();
		user.setId(1);
		user.setCarId(10);
		request.getSession().setAttribute("user", user);
		return "index";
	}

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "test";
	}
	
	@RequestMapping(value = "/regular", method = RequestMethod.GET)
	public String regular(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "regular";
	}

	@RequestMapping(value = "/regular2", method = RequestMethod.GET)
	public String regular2(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "regular2";
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "order";
	}


	@RequestMapping(value = "/selectShop", method = RequestMethod.GET)
	public String selectShop(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "selectShop";
	}
	
	@RequestMapping(value = "/maintenance", method = RequestMethod.GET)
	public String maintenance(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "maintenance";
	}

	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public String change(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "changeList";
	}
	
}
