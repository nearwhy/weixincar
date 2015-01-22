package com.aero.o2o.web.util;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * web工具类
 * 
 * @author tan
 * @version 1.00 
 * 
 * 修改记录
 * 
 */
public class WebUtil {
    public static String addnbsp(String cardNum,int num){
		String cardNumNew = "";
		int b = cardNum.length()/num;
		for(int i=0;i<=b;i++){
			if(i==b){
				cardNumNew+=cardNum.substring(i*num,cardNum.length());
			}else{
				cardNumNew+=cardNum.substring(i*num,(i+1)*num)+" ";
			}				
		}
		return cardNumNew;
    }
    
    public static String fetchStringParameter(HttpServletRequest request, String key){
    	
    	return fetchStringParameter(request, key, null);    	 
    }	
   
    public static String fetchStringParameter(HttpServletRequest request, String key, String defaultValue){
    	String value = request.getParameter(key);
    	if(value == null || value.equals("null")){
    		return defaultValue;
    	}else{
    		return value.trim();
    	}
    }	
    
    public static int fetchIntParameter(HttpServletRequest request, String key){
    	String value = request.getParameter(key);    
    	return ConvertUtil.str2int(value);
    }
    
    public static Double fetchDoubleParameter(HttpServletRequest request, String key, Double defaultValue){
    	String v = request.getParameter(key);
    	if(v == null || v.equals("null"))
    		return defaultValue;
    	return ConvertUtil.str2Double(v, defaultValue);
    }
    
    public static double fetchdoubleParameter(HttpServletRequest request, String key){
    	String v = request.getParameter(key);
    	if(v == null || v.equals("null"))
    		return 0;
    	return ConvertUtil.str2double(v);
    }
    
    public static Integer fetchIntegerParameter(HttpServletRequest request, String key, Integer defaultValue){
    	String value = request.getParameter(key);    	
    	if(value == null ||"".equals(value)){
    		return defaultValue;
    	}else{
    		return ConvertUtil.str2Integer(value);
    	}
    }	
    
    public static boolean fetchBoolParameter(HttpServletRequest request, String key){
    	String value = request.getParameter(key);
    	if(value == null){
    		return false;
    	}else{
    		return ConvertUtil.str2bool(value);
    	}
    }
    
    public static Boolean fetchBooleanParameter(HttpServletRequest request, String key, Boolean defaultValue){
    	String value = request.getParameter(key);
    	if(value == null){
    		return defaultValue;
    	}else{
    		return ConvertUtil.str2Boolean(value, defaultValue);
    	}
    }
    
    public static Date fetchDateParameter(HttpServletRequest request, String key, Date defaultValue){
    	String value = request.getParameter(key);
    	if(value == null){
    		return defaultValue;
    	}else{
    		return ConvertUtil.str2date(value, defaultValue);
    	}
    }
    
    public static Date fetchDatetimeParameter(HttpServletRequest request, String key, Date defaultValue){
    	String value = request.getParameter(key);
    	if(value == null){
    		return defaultValue;
    	}else{
    		return ConvertUtil.str2datetime(value, defaultValue);
    	}
    }
    
    public static Timestamp fetchTimestampParameter(HttpServletRequest request, String key, Timestamp defaultValue){
    	String value = request.getParameter(key);
    	if(value == null){
    		return defaultValue;
    	}else{
    		return ConvertUtil.str2timestamp(value, defaultValue);
    	}
    }
    
    /**
     * 对字符串进行HTML格式编码
     * 转换：
     * 回车 => <br/>
     * 空格 => &nbsp;     
     * 
     * @param str 普通的具有格式的文本字符串
     * @return 编码后的HTML
     */
//    public static String escapeHtml(String str){    	
//    	String html = str.replace("\n", "<br/>")
//    		   			 .replace(" ", "&nbsp;");
//    	return html;
//    }
    
    /**
     * 对HTML进行解码
     * 
     * 转换：
     * <br/>  => 回车
     * &nbsp; => 空格
     * 
     * @param html HTML格式文本
     * @return 解码后的普通具有格式的文本
     */
//    public static String unescapeHtml(String html){
//    	String str = html.replace("<br/>", "\n")
//			 		     .replace("&nbsp;", " ");
//    	return str;	
//    }
    
    public static boolean isIE(HttpServletRequest request){
    	String userAgent = request.getHeader("user-agent");
    	userAgent = userAgent.toLowerCase();
    	return userAgent.indexOf("msie") != -1;
    }
    
    /**
     * 将字符串编码成UTF-8
     * @param request
     * @param str
     * @return
     */
    public static String encodeStr(HttpServletRequest request, String str, String... charset){
    	
    	try{
	    	if (WebUtil.isIE(request)) {
				return URLEncoder.encode(str, "utf-8");
			} else {
				return new String(str.getBytes("utf-8"), "iso8859-1");
			}
    	}catch(Exception e){
    		return null;
    	}
    }
    
    public static String keyGnerter(){
    	String uuid =UUID.randomUUID().toString();
		String suuid = uuid.substring(0,uuid.lastIndexOf("-"));
		return "TP-"+suuid.replaceAll("-","").toUpperCase();
    }
}
