package com.aero.o2o.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

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
