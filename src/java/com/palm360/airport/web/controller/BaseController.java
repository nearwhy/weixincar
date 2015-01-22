package com.palm360.airport.web.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter; //import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.ServletContextAwareProcessor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.ImageUtil;
import com.sun.xml.internal.ws.client.ResponseContext;

/**
 * 所有Controller的父类 实现生成JSON方法，获得session，获得request，获得resonse
 * 
 * @author zhangtong
 * 
 */
// @Controller
public abstract class BaseController implements ServletContextAware {

	static final String SESSION_KEY_USERINFO = "userInfo";
	
	static final String MODEL_NAME_RESULT = "result";

	static final Pattern rfc2822 = Pattern
			.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");

	static final String COOKIE_NAME="AirportUser";//in ios client to set it
//	 @Autowired
	protected ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Autowired
	ReloadableResourceBundleMessageSource messageSource;

	private static Locale locale = null;

	public BaseController() {

	}
	
	/**
	 * 获得用户Cookie
	 * @param request
	 * @return 如果成功返回UserInfo，如果失败返回NULL（没有登陆，或过期）
	 */
	public UserInfo getCookie(HttpServletRequest request){
		Cookie cookie[] = request.getCookies();
		UserInfo userInfo = new UserInfo();
		for(int i = 0;i<cookie.length;i++){
			String name = cookie[i].getName();
			if(COOKIE_NAME.equals(name)){
				String value = cookie[i].getValue();	
				//NSString* cookieStr = 
				//[NSString stringWithFormat:@"UserId:%d;email:%@;password:%@;",userInfo.userID,userInfo.email,[AirportUtil base64forString:userInfo.password ]];
				String vals[] = value.split(";");
				if(vals.length>=3)
				{
					
					String userID = vals[0].split(":").length>1?vals[0].split(":")[0]:null;
					String email = vals[1].split(":").length>1?vals[1].split(":")[0]:null;
					String password = vals[2].split(":").length>1?vals[2].split(":")[0]:null;
					if(userId != null)
					{
						userInfo.setUserID(Integer.parseInt(userID));
						userInfo.setEmail(email);
						userInfo.setPassword(password);
						return userInfo;
					}
					else 
						return null;
				}
			}
	}
	
	/**
	 * 
	 * 判断cookie 或是是否已经登录
	 * 如果登陆了是true
	 * 其他返回flash
	 * TODO 这个地方可以返回数字，通过不同的数字表示不同的错误，来判断是否是需要重新登陆等动作
	 */
	public boolean checkCookie(HttpServletRequest request){
		Cookie cookie[] = request.getCookies();
		HttpSession session = request.getSession();
		UserInfo userInfo = this.getCookie(request);
		if(userInfo == null){
			//TODO it is not login
			return false;
		}
		else{
			//FIXME it is need to fix
			String sessUserId = session.getAttribute("userId");
			if(userInfo.getUserID() == null){
				//TODO  return error result:"errMessage:你还没登陆"
			}
			if(sessUserId == null){
				//TODO need to login use userId,email,password
				return false;
			}
			//if sessUserId == userId the user is logined
			if(sessUserId.equals(userInfo.getUserID())){
				return true;
			}
			else{
				//TODO it is unvalid userid
				return false;
			}
		}
//		for(int i = 0;i<cookie.length;i++){
//			String name = cookie[i].getName();
//			if(COOKIE_NAME.equals(name)){
//				String value = cookie[i].getValue();
//				//NSString* cookieStr = 
//				//[NSString stringWithFormat:@"UserId:%d;email:%@;password:%@;",userInfo.userID,userInfo.email,[AirportUtil base64forString:userInfo.password ]];
//				String vals[] = value.split(";");
//				if(vals.length>=3)
//				{
//					
//					String userID = vals[0].split(":").length>1?vals[0].split(":")[0]:null;
//					String email = vals[1].split(":").length>1?vals[1].split(":")[0]:null;
//					String password = vals[2].split(":").length>1?vals[2].split(":")[0]:null;
//					//check session => userid is equals userId
//					//FIXME it is need to fix
//					String sessUserId = session.getAttribute("userId");
//					if(userId == null){
//						//TODO  return error result:"errMessage:你还没登陆"
//					}
//					if(sessUserId == null){
//						//TODO need to login use userId,email,password
//					}
//					//if sessUserId == userId the user is logined
//					if(sessUserId.equals(userId)){
//						return true;
//					}
//					else{
//						//TODO it is unvalid userid
//						return false;
//					}
//					
//					
//				}
//			}
//		}
		
	}

	/**
	 * 将一个图片，按照比例缩放到固定大小 并保存成另外一个名称 同时保存两个图片 一个大图一个小图
	 * 
	 * @param srcData
	 * @param destFileName
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public void savePic(byte[] srcData, String srcFileName, String destFileName, int width, int height) throws IOException {
		locale = RequestContextUtils.getLocaleResolver(this.getRequest()).resolveLocale(this.getRequest());
		// FIXME
		String path = messageSource.getMessage("upload.dir", new Object[] {}, locale);
		path = servletContext.getRealPath(path);

		FileCopyUtils.copy(srcData, new FileOutputStream(new File(path + srcFileName)));
		if (width != 0 && height != 0) {
			srcData = ImageUtil.scaleImage(srcData, width, height);
		}
		FileCopyUtils.copy(srcData, new FileOutputStream(new File(path + destFileName)));
		// response.setContentType("image/jpeg");
		// response.setCharacterEncoding("UTF-8");
		// OutputStream outputSream = response.getOutputStream();
		// InputStream in = new ByteArrayInputStream(data);
		// int len = 0;
		// byte[] buf = new byte[1024];
		// while ((len = in.read(buf, 0, 1024)) != -1) {
		// outputSream.write(buf, 0, len);
		// }
		// outputSream.close();
	}

	/**
	 * 得到session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession contextSess = attr.getRequest().getSession(true);

		return contextSess;
	}

	/**
	 * 得到request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {

		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 是否网页后缀名为json
	 * 
	 * @return
	 */
	public boolean isJson() {
		HttpServletRequest request = this.getRequest();
		String uri = request.getServletPath().trim();
		if (uri.endsWith("json")) {
			return true;
		}
		return false;
	}

	private static final int BUFFER = 0x2000;// =8K

	/**
	 * 用于文件下载
	 * 
	 * @param fileName
	 * @param filePath
	 * @param response
	 * @throws Exception
	 */
	protected void download(String fileName, String filePath, final HttpServletResponse response) throws Exception {
		fileName = URLEncoder.encode(fileName, "UTF-8");
		File file = new File(filePath);
		byte[] data = new byte[BUFFER];
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		response.addHeader("Content-Length", "" + file.length());
		response.setContentType("application/octet-stream;charset=UTF-8");
		OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		InputStream fs = new FileInputStream(file);
		int length = -1;
		while ((length = fs.read(data, 0, BUFFER)) != -1) {
			outputStream.write(data, 0, length);
		}
		fs.close();
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 直接写成json数据
	 * 
	 * @param o
	 * @param outputMessage
	 * @throws HttpMessageNotWritableException
	 * @throws IOException
	 */
	@Deprecated
	protected void WriteJson(Object o, HttpOutputMessage outputMessage) throws HttpMessageNotWritableException, IOException {
		MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();
		MediaType jsonMimeType = MediaType.APPLICATION_JSON;
		jsonConverter.write(o, jsonMimeType, outputMessage);
	}

	private static JsonConfig jc = null;// = new JsonConfig();

	/**
	 * 获得json数据
	 * 
	 * @param o
	 * @return
	 */
	// @Deprecated
	protected String GetJson(Object o) {
		if (jc == null) {
			jc = new JsonConfig();
			jc.setJsonPropertyFilter(new PropertyFilter() {
				public boolean apply(Object jsonString, String field, Object value) {
					if (value == null)
						return true;
					return false;
				}
			});
		}
		return o == null ? "{}" : net.sf.json.JSONSerializer.toJSON(o, jc).toString();
	}
}
