package com.aero.o2o.web.Listener;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

/**
 * 获取根路径
 * 
 * @author xzl
 * 
 */
public class WebRootListener extends ContextLoaderListener {

	private Logger log = Logger.getLogger(WebRootListener.class);
	
	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		String webAppRootKey = sce.getServletContext().getRealPath("/");
		System.setProperty("airport.root", webAppRootKey);
		log.info("airport.root: " + System.getProperty("airport.root"));
	}

}
