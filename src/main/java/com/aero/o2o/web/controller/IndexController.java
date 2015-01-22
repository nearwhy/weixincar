package com.aero.o2o.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aero.o2o.model.Product;
import com.aero.o2o.model.QueryParam;

@Controller("IndexController")
public class IndexController  extends BaseController {
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "index";
	}

	
	@RequestMapping(value = "/mycar", method = RequestMethod.GET)
	public String mycar(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "mycar";
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

	
	@RequestMapping(value = "/carBrand", method = RequestMethod.GET)
	public String carBrand(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "carBrand";
	}
	
	@RequestMapping(value = "/carType", method = RequestMethod.GET)
	public String carType(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "carType";
	}
	
	@RequestMapping(value = "/carModel", method = RequestMethod.GET)
	public String carModel(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "carModel";
	}
	
	@RequestMapping(value = "/self", method = RequestMethod.GET)
	public String self(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "self";
	}
	
	@RequestMapping(value = "/change", method = RequestMethod.GET)
	public String change(HttpServletRequest request, Map<String, Object> map) throws Exception{
		return "changeList";
	}
	
	
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(HttpServletRequest request, Map<String, Object> map) throws Exception{
		QueryParam qp = new QueryParam();
		qp.put("id",1);
		Product product = (Product)o2oDao.queryForObject("Product.queryById", qp);
		System.out.println("name==="+product.getName());
		System.out.println("price==="+product.getPrice());
		return "productDetail";
	}
}
