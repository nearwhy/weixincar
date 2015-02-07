package com.aero.o2o.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aero.o2o.model.UpkeepCategory;

@Controller("UpkeepController")
public class UpkeepController extends BaseController{
	
	//自助保养项目查询
		@RequestMapping(value = "/self", method = RequestMethod.GET)
		public String removeMyCar(HttpServletRequest request, Map<String, Object> map) throws Exception{
			List<UpkeepCategory> list = o2oDao.queryForList("Upkeep.querySelf", null);
			map.put("upkeeps", list);
			return "self";
		}
}
