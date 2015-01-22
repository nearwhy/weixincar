package com.aero.o2o.model;

import java.util.Locale;

import com.aero.o2o.util.ErrorBundleReader;

public class BasePojo {
	
	protected String servletContextPath = ErrorBundleReader.getMessageSource().getMessage(
			"o2o.servletContextPath",
			new Object[] {},
			Locale.CHINA);

	
	protected String yhtcloudPath = ErrorBundleReader.getMessageSource().getMessage(
			"o2o.yhtcloudPath",
			new Object[] {},
			Locale.CHINA);
	
	public String getServletContextPath() {
		return servletContextPath;
	}

	public void setServletContextPath(String servletContextPath) {
		this.servletContextPath = servletContextPath;
	}

	public String getYhtcloudPath() {
		return yhtcloudPath;
	}

	public void setYhtcloudPath(String yhtcloudPath) {
		this.yhtcloudPath = yhtcloudPath;
	}
	
	
}
