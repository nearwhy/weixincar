package com.palm360.airport.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * 导出JSON解析类
 * 优化JSON数据导出时 数据value为null的数据不导出
 * @author zhangtong
 *
 */
public class MappingJacksonJsonViewEx extends MappingJacksonJsonView {
	private static JsonConfig jc = null;

	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (jc == null) {
			jc = new JsonConfig();
			jc.setJsonPropertyFilter(new PropertyFilter() {
				public boolean apply(Object jsonString, String field,
						Object value) {
					if (value == null)
						return true;
					return false;
				}
			});
		}
		response.getOutputStream().write(
				model == null ? "{}".toString().getBytes("utf-8")
						: net.sf.json.JSONSerializer.toJSON(model, jc)
								.toString().getBytes("utf-8"));
	}
}
