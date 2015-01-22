package com.palm360.airport.web.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.palm360.airport.util.BaseThread;
import com.palm360.airport.util.ThreadOpration;

public class ReadFlyService implements ServletContextListener{
	//@Autowired
	ThreadOpration readFly;
	//@Autowired
	ThreadOpration recordLog;
	
	BaseThread readFlyThread = null;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(readFlyThread != null){
			readFlyThread.setStart(false);
		}
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO start get fly thread
		// start log thread(to log user login)	
		if(readFlyThread == null){
			readFlyThread = new BaseThread(false, 1000, readFly);
		}
		
		
	}

}
