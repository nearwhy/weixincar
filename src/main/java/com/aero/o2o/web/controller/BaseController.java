package com.aero.o2o.web.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.aero.o2o.AirportConstant;
import com.aero.o2o.dao.O2ODao;
import com.aero.o2o.util.ImageUtil;

/**
 * 所有Controller的父类 实现生成JSON方法，获得session，获得request，获得resonse
 * 
 * @author zhangtong
 * 
 */
// @Controller
public abstract class BaseController implements ServletContextAware {

	
	protected ServletContext servletContext;

	@Autowired
	protected O2ODao o2oDao;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private static Locale locale = null;

	public BaseController() {

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
	public void savePic(byte[] srcData, String srcFileName,
			String destFileName, int width, int height) throws IOException {
		locale = RequestContextUtils.getLocaleResolver(this.getRequest())
				.resolveLocale(this.getRequest());
		// FIXME
		String path = "";// messageSource.getMessage("upload.dir", new Object[]
							// {}, locale);
		path = servletContext.getRealPath(path);

		FileCopyUtils.copy(srcData, new FileOutputStream(new File(path
				+ srcFileName)));
		if (width != 0 && height != 0) {
			srcData = ImageUtil.scaleImage(srcData, width, height);
		}
		FileCopyUtils.copy(srcData, new FileOutputStream(new File(path
				+ destFileName)));
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
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpSession contextSess = attr.getRequest().getSession(true);

		return contextSess;
	}

	/**
	 * 得到request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {

		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
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
	protected void download(String fileName, String filePath,
			final HttpServletResponse response) throws Exception {
		fileName = URLEncoder.encode(fileName, "UTF-8");
		File file = new File(filePath);
		byte[] data = new byte[BUFFER];
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");
		response.addHeader("Content-Length", "" + file.length());
		response.setContentType("application/octet-stream;charset=UTF-8");
		OutputStream outputStream = new BufferedOutputStream(
				response.getOutputStream());
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
	 * 多返回结果，组织成ModelAndView返回
	 * 
	 * @param viewName
	 *            视图名
	 * @param map
	 *            装载AirportResult的map
	 * @return
	 */
	protected ModelAndView getModelAndView(String viewName,
			Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Iterator<String> it = map.keySet().iterator();
		String key = null;
		Map<String, Object> pMap = null;
		while (it.hasNext()) {
			key = it.next();
			pMap = new HashMap<String, Object>();
			pMap.put(AirportConstant.MODEL_NAME_RESULT, map.get(key));
			resultMap.put(key, pMap);
		}
		return new ModelAndView(viewName, resultMap);
	}

}
