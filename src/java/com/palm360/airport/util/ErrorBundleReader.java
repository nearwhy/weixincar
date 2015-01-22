package com.palm360.airport.util;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Repository;
@Repository
public class ErrorBundleReader {

	private static ReloadableResourceBundleMessageSource messageSource;
	
	public static Locale locale = Locale.CHINA;
	
	
	public ErrorBundleReader(){
		//ReloadableResourceBundleMessageSource r = new ReloadableResourceBundleMessageSource();
	}
	
	public ErrorBundleReader(Locale locale){
		this.locale = locale;
	}
	public String readKeyCode(String errKey){
		return getMessageSource().getMessage(errKey+".code", new Object[0], locale);
	
	}
	public String readKeyMessage(String errKey){
		return getMessageSource().getMessage(errKey+".message", new Object[0], locale);
	}
//	public void setErrorMessage(ReloadableResourceBundleMessageSource messageSource) {
//		if(messageSource != null)
//			this.setMessageSource(messageSource);
//	}
//	public ReloadableResourceBundleMessageSource getErrorMessage() {
//		return getMessageSource();
//	}
	public static void setMessageSource(ReloadableResourceBundleMessageSource messageSource) {
		ErrorBundleReader.messageSource = messageSource;
	}
	public static ReloadableResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}
}
