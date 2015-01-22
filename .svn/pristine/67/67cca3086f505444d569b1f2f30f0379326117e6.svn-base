package com.aero.o2o.util;

public class MapPackageUtil {
	
	public static final String NEWMAPVERSION = "1.0";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a.b".split("\\.")[0]);
		System.out.println(getNewBigMapVersion("1.12"));
	}
	
	/**
	 * 根据version获取下一个小版本Version 
	 * @param mapVersion
	 * @return
	 */
	public static String getNewSmallMapVersion(String mapVersion){
		String newMapVersion = mapVersion.split("\\.")[0]+"."+String.valueOf(Integer.valueOf(mapVersion.split("\\.")[1])+1);
		return newMapVersion;
	}
	
	/**
	 * 根据version获取下一个大版本Version 
	 * @param mapVersion
	 * @return
	 */
	public static String getNewBigMapVersion(String mapVersion){
		String newMapVersion = String.valueOf(Integer.valueOf(mapVersion.split("\\.")[0])+1)+".0";
		return newMapVersion;
	}
}
