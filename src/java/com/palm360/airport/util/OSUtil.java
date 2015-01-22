package com.palm360.airport.util;

import org.apache.commons.lang.StringUtils;

public class OSUtil {
	
	public static boolean isWindows() {
		final String os = System.getProperty("os.name");
		return StringUtils.containsIgnoreCase(os, "windows");
	}
	
	public static void main(String[] args) {
		boolean b = isWindows();
		System.out.println(b);
	}
}
