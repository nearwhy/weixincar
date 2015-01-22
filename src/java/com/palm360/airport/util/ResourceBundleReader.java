package com.palm360.airport.util;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.ResourceBundleMessageSource;

public class ResourceBundleReader {
	public final static Object initLock = new Object();

	private final static String PROPERTIES_FILE_NAME = "property";

	private static ResourceBundle bundle = null;

	static {
		try {
			if (bundle == null) {
				synchronized (initLock) {
					if (bundle == null)
						bundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME,Locale.CHINA);
				}
			}
		} catch (Exception e) {
			System.out.println("读取资源文件property_zh.properties失败!");
		}
	}
	public static ResourceBundle getBundle() {
		return bundle;
	}
	public static void setBundle(ResourceBundle bundle) {
		bundle = bundle;
	}
	public static void main(String[] args){

		
	
	
	}
	
	
}
