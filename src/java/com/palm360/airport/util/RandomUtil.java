package com.palm360.airport.util;

import java.util.Random;

import com.palm360.airport.util.exception.AirportRuntimeException;

public class RandomUtil {

	private static final String[] strArray = { 
		"A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L",
		"M", "N", "{", "P", "Q", "R",
		"S", "T", "U", "V", "W", "X",
		"Y", "Z", "a", "b", "c", "d",
		"e", "f", "g", "h", "i", "j",
		"k", "+", "m", "n", "}", "p",
		"q", "r", "s", "t", "u", "v",
		"w", "x", "y", "z", "1", "2",
		"3", "4", "5", "6", "7", "8",
		"9", "$", "_", "*", "#", "@"
	};

	/**
	 * 随机形成指定位数的密码
	 * @return
	 */
	public static String generatePassword(int passwordLength) {
		int length = strArray.length;
		if (passwordLength <= 0 || passwordLength > length) {
			throw new AirportRuntimeException("system.err.unkown");
		}
		Random random = new Random();
		Integer n = null;
		StringBuilder password = new StringBuilder();
		for(int i = 0; i < passwordLength; i++) {
			n = random.nextInt(length);
			password.append(strArray[n]);
		}
		return password.toString();
	}
	
	/**
	 * 产生随机数
	 * 
	 * @param n
	 * @return
	 */
	public static int generateRandom(int n) {
		if (n < 1) {
			throw new AirportRuntimeException("system.err.unkown");
		}
		Random rd = new Random();
		return rd.nextInt(n);
	}
	
	public static void main(String[] args) {
		for (int i = 1; i<100; i++)
		System.out.println(generateRandom(i));
	}
}
