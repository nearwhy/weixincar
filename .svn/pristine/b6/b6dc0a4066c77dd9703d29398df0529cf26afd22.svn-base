package com.aero.o2o.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	/**
	 * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
	 * 
	 * @param s
	 *            需要得到长度的字符串
	 * @return i得到的字符串长度
	 */
	public static int strlength(String s) {
		if (s == null)
			return 0;
		char[] c = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i])) {
				len++;
			}
		}
		return len;
	}

	/**
	 * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
	 * 
	 * 
	 * @param origin
	 *            原始字符串
	 * @param len
	 *            截取长度(一个汉字长度按2算的)
	 * @param c
	 *            后缀
	 * @return 返回的字符串
	 */
	public static String tosubstring(String origin, int len, String c) {
		if (origin == null || origin.equals("") || len < 1)
			return "";
		byte[] strByte = new byte[len];
		if (len > strlength(origin)) {
			return origin + c;
		}
		try {
			System.arraycopy(origin.getBytes("GBK"), 0, strByte, 0, len);
			int count = 0;
			for (int i = 0; i < len; i++) {
				int value = (int) strByte[i];
				if (value < 0) {
					count++;
				}
			}
			if (count % 2 != 0) {
				len = (len == 1) ? ++len : --len;
			}
			origin = "";
			return new String(strByte, 0, len, "GBK") + c;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	public static String ListtoString(List<String> list){
		String  s = "";
		for(int i = 0 ; i < list.size() ; i++){
			String L = list.get(i);
			s =s+","+L ;
		}
		if(list == null || list.size()==0){
			return s;
		}
		return s.substring(1);
	}
	
	public static String getSixLengthFilghNo(String str){
		String f_no = "";
		for(int i=0;i<str.length();i++){	
			if(Character.isDigit(str.charAt(i))){	
				 char s = str.charAt(i);
				 String[] sd = str.split(String.valueOf(s));
				  if(sd[0].length()==0){
					  return 0+str;
				  }else{
					  if(sd[0].length()==4){
						  f_no = sd[0]+0+String.valueOf(s);
							return f_no;
					  }else{
						  f_no = sd[0]+0+String.valueOf(s)+sd[1];
						   return f_no;
					  }
					   
				  }
				 
			 }
		}
		 return f_no;
	}
	
	public static int getWordCountRegex(String s) {
		s = s.replaceAll("[^\\x00-\\xff]", "**");
		int length = s.length();
		return length;
	}  
  
    /** 
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1 
     *  
     * @param s 需要得到长度的字符串 
     * @return i得到的字符串长度 
     */  
    public static int length(String s) {  
        if (s == null)  
            return 0;  
        char[] c = s.toCharArray();  
        int len = 0;  
        for (int i = 0; i < c.length; i++) {  
            len++;  
            if (!isLetter(c[i])) {  
                len++;  
            }  
        }  
        return len;  
    }  
  
    /** 
     * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位 
     *  
     *  
     * @param  origin 原始字符串 
     * @param len 截取长度(一个汉字长度按2算的) 
     * @param c 后缀            
     * @return 返回的字符串 
     */  
    public static String substring(String origin, int len) {  
        if (origin == null || origin.equals("") || len < 1)  
            return "";  
        byte[] strByte = new byte[len];  
        if (len > length(origin)) {  
            return origin;  
        }  
        try {  
            System.arraycopy(origin.getBytes("GBK"), 0, strByte, 0, len);  
            int count = 0;  
            for (int i = 0; i < len; i++) {  
                int value = (int) strByte[i];  
                if (value < 0) {  
                    count++;  
                }  
            }  
            if (count % 2 != 0) {  
                len = (len == 1) ? ++len : --len;  
            }  
            return new String(strByte, 0, len, "GBK");  
        } catch (UnsupportedEncodingException e) {  
            throw new RuntimeException(e);  
        }  
    } 
    
    private static final String pinyinRegex = "^[A-Za-z]*$";
    /**
     * 判断是否全是拼音或者字母
     * @param str
     * @return
     */
    public static boolean isPinyin(String str) {
    	if (null == str) {
    		return false;
    	}
    	Pattern pattern = Pattern.compile(pinyinRegex);
    	Matcher matcher = pattern.matcher(str);
    	matcher.find();
    	return matcher.matches();
    }
    
	public static void main(String[] args) {
		 String str = "xinwenlianbo";
		 System.out.println(isPinyin(null));
	}
}
