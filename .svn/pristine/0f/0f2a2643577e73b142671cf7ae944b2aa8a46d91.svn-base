package com.palm360.airport.web.Listener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.palm360.airport.dao.BaseDao;
import com.palm360.airport.util.AirPortUtil;

//@Component("MirrorDB2Redis")
public class MirrorDB2Redis extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(getClass());

	@Override
	public void init(ServletConfig config) throws ServletException {

		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		List<File> lf = new ArrayList<File>();
		lf.add(new File(config.getServletContext().getRealPath(
				"WEB-INF/classes")));
		List<String> list = AirPortUtil.getClassInPackage(
				"com.palm360.airport.dao.impl", lf);
		Object o = null;
		BaseDao<?> bd = null;
		for (String str : list) {
			try {
				Class<?> c = Class.forName(str);
				if (c.isAnnotationPresent(Repository.class)) {
					Repository r = (Repository) c
							.getAnnotation(Repository.class);
					if (null != r.value() && !"".equals(r.value()))
						o = ctx.getBean(r.value());
					else
						o = ctx.getBean(c.getName());
					if (o != null) {
						if (o instanceof BaseDao<?>) {
							bd = (BaseDao<?>) o;
							int count = bd.queryAllCount();
							bd.queryAll(count, 1);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
