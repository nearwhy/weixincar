package com.palm360.airport.util.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.palm360.airport.util.AirportResult;

public class AirportExceptionResolver implements HandlerExceptionResolver{
	private static Logger logger = Logger.getLogger(AirportExceptionResolver.class);
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		//logger.error("Catch Exception: ",ex);//把漏网的异常信息记入日志  
//        Map<String,Object> map = new HashMap<String,Object>();  
//        if(ex instanceof AirportRuntimeException){
//        	AirportRuntimeException e = (AirportRuntimeException) ex;
//        	request.setAttribute("err", e.getMessage());
//        	request.setAttribute("errCode", e.getCode());
//        	
//        }
//        
		AirportResult ar = new AirportResult();
      if(ex instanceof AirportRuntimeException){
    	AirportRuntimeException e = (AirportRuntimeException) ex;
    	ar.setCode(e.getCode());
    	ar.setErrMessage(e.getMessage());
//    	request.setAttribute("err", e.getMessage());
//    	request.setAttribute("errCode", e.getCode());
    	
      }
      else{
    	  ar.setCode(-1);
    	  ar.setErrMessage(ex.getMessage());
      }
        return new ModelAndView("","Result",ar);  
	}
}
