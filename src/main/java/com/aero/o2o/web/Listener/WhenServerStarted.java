package com.aero.o2o.web.Listener;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WhenServerStarted extends HttpServlet {
	private final transient Logger log = Logger.getLogger(getClass());
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		Properties prop = new Properties();
		try {
			prop.load(ctx.getResource("classpath:application.properties").getInputStream());
		} catch (IOException e) {
			log.error(e);
		}
		String qrCodeDir = prop.getProperty("qrcode.dir");
		String servletContextPath = config.getServletContext().getRealPath("");
//		if (OSUtil.isWindows()) {
//			qrCodeDir = "C:/" + qrCodeDir;
//		}
		log.info("QR Code path: " + servletContextPath + qrCodeDir);
		String fullPath = servletContextPath + qrCodeDir;
		File file = new File(fullPath);
		if (!file.exists()) {
			boolean bool = file.mkdirs();
			log.info(fullPath);
			if (bool) {
				log.info("QR Code路径创建成功");
			} else {
				log.info("QR Code路径创建失败");
			}
		} else {
			log.info("QR Code路径已经存在");
		}
	}

}
