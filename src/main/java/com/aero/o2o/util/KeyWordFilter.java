package com.aero.o2o.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class KeyWordFilter extends TimerTask{
	private static Pattern pattern = null;

	Logger log = Logger.getLogger(getClass());
/*	static {
		initPattern();
	}*/
	
	// 从words.properties初始化正则表达式字符串
	private static void initPattern() {
		StringBuffer patternBuf = new StringBuffer("");
		String propFilePath = System.getProperty("airport.root");
		try {
			InputStream in = new FileInputStream(new File(propFilePath + "upload/words.properties"));
			Properties pro = new Properties();
			pro.load(in);
			Enumeration enu = pro.propertyNames();
			patternBuf.append("(");
			while (enu.hasMoreElements()) {
				patternBuf.append(pro.getProperty( (String)enu.nextElement()) + "|");
			}
			patternBuf.deleteCharAt(patternBuf.length() - 1);
			patternBuf.append(")");

			// unix换成UTF-8
			// pattern = Pattern.compile(new
			// String(patternBuf.toString().getBes("ISO-8859-1"), "UTF-8"));yt
			// win下换成gb2312
			//pattern = Pattern.compile(new String(patternBuf.toString().getBytes("ISO-8859-1"), "UTF-8"));
			pattern = Pattern.compile(patternBuf.toString());
		} catch (IOException ioEx) {
		}
	}
	/***
	 * 是否存在敏感词并替换
	 * @param str
	 * @return
	 */
	public static String doFilter(String str) {
		Matcher m = pattern.matcher(str);
		str = m.replaceAll("*");
		return str;
	}
	/**
	 * 是否存在敏感词
	 * @param str
	 * @return
	 */
	public static Boolean IsFilter(String str) {
		Matcher m = pattern.matcher(str);
		return m.find();
	}
	@Override
	public void run() {
		initPattern();
//		System.out.println("keyWordFilter 你启动了么 ？");
		log.info("keyWordFilter 你启动了么 ？");
	}

//	public static void main(String[] args) {
//		String str = "胡景涛 ddgcd江泽民所得税时的的 撒共产党 gcd 旦的撒旦首都师大但是多少多少的是的撒旦首都师大国敏感词一院学位办就敏感词三的报道表示敏感词二aa啊十大的撒旦首都师大打到撒旦的大嵩岛的撒旦单位省大量开发阶段了快捷方式打开老骥伏枥撒娇发生凌凤街道连接符的思考连接符打开连接符十六大会计法共产党TMD";
//		System.out.println("str:" + str);
//		initPattern();
//		Date d1 = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat(
//				"EEE, d MMM yyyy HH:mm:ss:SSS Z");
//		System.out.println("start:" + formatter.format(d1));
//		System.out.println("共" + str.length() + "个字符，查到"
//				+ KeyWordFilter.doFilter(str));
//		Date d2 = new Date();
//		System.out.println("end:" + formatter.format(d2));
//		System.out.println(KeyWordFilter.class.getClassLoader().getResource("/").getPath());
//	}
}
