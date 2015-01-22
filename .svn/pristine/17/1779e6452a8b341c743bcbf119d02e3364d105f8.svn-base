package com.palm360.airport.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.palm360.airport.dao.UserInfoDao;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.service.UserService;
import com.palm360.airport.util.AirportResult;
import com.palm360.airport.util.ErrorBundleReader;
import com.palm360.airport.util.exception.AirportRuntimeException;

/**
 * test code
 */
//@RequestMapping("/")
@Controller("IndexContorller")
public class IndexContorller extends BaseController{// implements Controller{
	
	@Autowired
	@Qualifier("userService")
	UserService userService ;
	
	@Autowired
	ErrorBundleReader r;
	
	/**
	 * 前台验证 例子
	 * @param ui
	 * @param result
	 * @return
	 */
	@RequestMapping("valid")
	public ModelAndView validpage(@ModelAttribute("ui") @Valid UserInfo ui,BindingResult result){
		AirportResult ar = new AirportResult();
		if(result.hasErrors()){
			if(this.isJson()){
				ar.setCode(result.getErrorCount());
				ar.setErrMessage(result.getFieldError().getDefaultMessage());
				ar.setRsObject(ui);
				return new ModelAndView("userinfoform","ui",ar);
			}
		}
		return new ModelAndView("userinfoform","ui",ui);
		
	}
	/**
	 * 消息传递例子
	 * @param accountId
	 * @param userAgent
	 * @param loginId
	 * @return
	 */
	@RequestMapping("inactive")
	public boolean inactive(@RequestParam("accountId") Long accountId,
	            @RequestHeader("User-Agent") String userAgent,
	            @CookieValue("loginId") String loginId) {
	    return true;
	}

	/**
	 * rest例子
	 * @param request
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value="test_{id}_{name}",method=RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request,@PathVariable Long id,@PathVariable String name){
		String tt = request.getParameter("tt");
		UserInfo ui = new UserInfo();
		request.setAttribute("print", id+","+name+","+tt);
		ui.setUserID(3);
		ui.setNickName("1111");
		ui.setPassword("fdasfdsafsa");
		AirportResult ar = new AirportResult();
		ar.setRsObject(ui);
		return new ModelAndView("heihei","test",ar);
		
	}
	/**
	 * 最简单的例子
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/index",method = {RequestMethod.GET})
	public ModelAndView  Index(HttpServletRequest request){
//		UserInfo ui = new UserInfo();
//		ui.setUserID(4);
//		ui.setNickName("test4");
//		ui.setPassword("ghfgfg");
//		System.out.println(userService.register(ui));
//		RedisUtilEx rue = new RedisUtilEx();
//		try {
//			rue.setList("userinfo", list,false);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new ModelAndView("redirect:test_1_ss.html");
	}
	/**
	 * 原始json例子,已经废弃
	 * @param response
	 * @return
	 */
	@Deprecated
	@RequestMapping("/indexJson")
	//@ResponseBody
	public ModelAndView IndexJson(HttpServletResponse response){
		List<String> list = new ArrayList<String>();
		String test = "fdsafasl";
		JSONPObject jo = new JSONPObject("test", test);
		list.add(test);
		list.add("你好");
		list.add("bbb");
//		try {
//			this.WriteJson(list, new ServletServerHttpResponse(response));
//		} catch (HttpMessageNotWritableException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		throw new AirportRuntimeException("system.err.unkown");		
		//return null;
	}

}
