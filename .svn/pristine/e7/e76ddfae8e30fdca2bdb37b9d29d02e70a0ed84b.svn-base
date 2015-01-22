package com.aero.o2o.web.util;

import java.util.Random;
import java.util.UUID;

/**
 * Java UUID Generator
 * @author John
 *
 */

public class UuidGenerator {
	
	/**
	 * synchronized static 方法 用于生成UUID
	 * @return
	 */
	public synchronized static String generateUniqueId() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		return uuid;
	}
	/***
	 * 
	 * @param s  不能大于10
	 * @return
	 */
	public synchronized static String generateid(int s) {
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
		    int index = rand.nextInt(i);
		    int tmp = array[index];
		    array[index] = array[i - 1];
		    array[i - 1] = tmp;
		}
		int result = 0;
		for(int i = 0; i <s; i++){
		    result = result *6 + array[i];
	      }
		 
		return ""+result;
	}
	
	public static void main(String[] args) {
		 
		System.out.println(generateid(2));

	}

}
