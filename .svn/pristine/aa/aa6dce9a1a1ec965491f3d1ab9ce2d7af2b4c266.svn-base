package com.palm360.airport.web.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.service.UserService;
import com.palm360.airport.util.AirportResult;
import com.palm360.airport.util.Encryption;
import com.palm360.airport.util.exception.AirportRuntimeException;

@Controller("userController")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView Register(HttpServletRequest request) {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		String rePassword = request.getParameter("repassword");

		if (StringUtils.isBlank(email)) {
			throw new AirportRuntimeException("user.err.email.required");
		}

		if (!rfc2822.matcher(email).matches()) {
			throw new AirportRuntimeException("user.err.email.pattern");
		}

		if (StringUtils.isBlank(password)) {
			throw new AirportRuntimeException("user.err.password.required");
		}

		if (StringUtils.isBlank(rePassword)) {
			throw new AirportRuntimeException("user.err.repassword.required");
		}

		if (StringUtils.length(password) < 8 || StringUtils.length(rePassword) < 8) {
			throw new AirportRuntimeException("user.err.password.length");
		}

		if (!password.equals(rePassword)) {
			throw new AirportRuntimeException("user.err.password.notsame");
		}

		try {
			UserInfo ui = new UserInfo();
			ui.setEmail(email);
			ui.setNickName(StringUtils.substringBefore(email, "@"));
			ui.setPassword(Encryption.md5(password));
			ui = userService.register(ui);

			if (null == ui.getUserID() || ui.getUserID() < 0) {
				throw new AirportRuntimeException("user.err.register.fail");
			}
			AirportResult ar = new AirportResult();
			ar.setRsObject(ui);
			request.getSession().setAttribute(SESSION_KEY_USERINFO, ui);
			return new ModelAndView("", "Result", ar);
		} catch (NoSuchAlgorithmException e) {
			throw new AirportRuntimeException("system.err.unkown");
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		String uuid = request.getParameter("uuid");

		if (StringUtils.isBlank(email)) {
			throw new AirportRuntimeException("user.err.email.required");
		}

		if (StringUtils.isBlank(password)) {
			throw new AirportRuntimeException("user.err.password.required");
		}

		// airport_ios_iphone, airport_ios_ipad, airport_android_
		String userAgent = request.getHeader("USER-AGENT");
		String device = null;
		if (StringUtils.containsIgnoreCase(userAgent, "airport_ios")) {
			device = "ios";
		} else if (StringUtils.containsIgnoreCase(userAgent, "airport_android")) {
			device = "android";
		} else {
			device = "other";
		}
		UserInfo ui = userService.login(email, password, request.getRemoteAddr(), uuid, device);
		ui.setPassword(null);
		AirportResult ar = new AirportResult();
		ar.setRsObject(ui);
		request.getSession().setAttribute(SESSION_KEY_USERINFO, ui);
		return new ModelAndView("", "Result", ar);

	}

	/**
	 * 忘记密码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public ModelAndView forgotPassword(HttpServletRequest request) {

		String email = request.getParameter("email");

		String uuid = request.getParameter("uuid");

		if (StringUtils.isBlank(email)) {
			throw new AirportRuntimeException("user.err.email.required");
		}

		userService.forgotPassword(email, uuid);
		return new ModelAndView("");
	}
}
