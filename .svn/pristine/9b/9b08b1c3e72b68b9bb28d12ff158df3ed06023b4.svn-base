package com.palm360.airport.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.service.VerificationCodeService;
import com.palm360.airport.util.AirportResult;

@Controller("verificationCodeController")
public class VerificationCodeController extends BaseController {

	@Autowired
	VerificationCodeService verificationCodeService;

	@RequestMapping(value = "/Lottery", method = RequestMethod.GET)
	public ModelAndView Lottery(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		AirportResult ar =verificationCodeService.addVerificationCode(userInfo);
		return new ModelAndView("", "", ar);
	}
}
