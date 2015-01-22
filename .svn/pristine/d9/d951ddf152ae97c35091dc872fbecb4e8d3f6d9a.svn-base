package com.palm360.airport.web.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.palm360.airport.model.Merchantinfo;
import com.palm360.airport.service.MerchantInfoService;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.AirportResult;
import com.palm360.airport.util.exception.AirportRuntimeException;

/**
 * 商户信息.controller
 * 
 * @author xzl
 * 
 */
@Controller("merchantInfoController")
public class MerchantInfoController extends BaseController {

	@Autowired
	private MerchantInfoService merchantInfoService;

	/**
	 * 第一次加载执行获取商户信息和前size条用户回复信息，第二次只执行查询用户回复信息
	 * 
	 * @param request
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/query_merchantInfo_{merchantId}_userComments_{page}_{size}", method = RequestMethod.GET)
	public ModelAndView queryMerchantInfoAndUserComments(HttpServletRequest request,
			@PathVariable Integer merchantId, @PathVariable Integer page, @PathVariable Integer size) {

		if (null == merchantId) {
			throw new AirportRuntimeException("user.err.merchant.id.required");
		}

		if (null == page || page < 1) {
			page = 1;
		}

		if (null == size || size < 1) {
			size = 10;
		}

		AirportQueryP qp = new AirportQueryP(page, size);
		qp.setValue(new Object[] { "*" });
		Map<String, Object> map = merchantInfoService.getMerchantInfoAndUserComments(qp,
				new Merchantinfo(merchantId));

		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> r1 = new HashMap<String, Object>();
		Map<String, Object> r2 = new HashMap<String, Object>();
		r1.put(MODEL_NAME_RESULT, map.get("merchantInfo_ar"));
		r2.put(MODEL_NAME_RESULT, map.get("userComments_ar"));
		model.put("merchantInfo", r1);
		model.put("userComments", r2);
		ModelAndView modelAndView = new ModelAndView("", model);
		return modelAndView;
	}
}
