package com.palm360.airport.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.palm360.airport.util.exception.AirportRuntimeException;

/**
 * 查询时候的传入参数
 * 
 * @author zhangtong
 * 
 */
public class AirportQueryP {
	/**
	 * 用于分页大小
	 */
	private int size = -1;
	/**
	 * 用于当前页数
	 */
	private int page;
	/**
	 * 用于分页 从多少开始分页
	 */
	private int start = 0;
	/**
	 * where 条件 可以是实体类的内容，也可以是hashmap
	 */
	private Object params;
	/**
	 * 要查询的内容, 这是一个数组 just List or array
	 */
	private Object value = null;
	/**
	 * 用什么排序
	 */
	private String orderBy;
	/**
	 * 排序asc or desc
	 */
	private boolean asc = true;

	private static final String split = "_";

	public AirportQueryP() {

	}

	public AirportQueryP(int page, int size) {
		this.page = page;
		this.size = size;
		calStart();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setPage(int page) {
		this.page = page;
		calStart();
	}

	public int getPage() {
		return page;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public Object getParams() {
		return params;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderBy() {
		return orderBy;
	}
	
	private void calStart() {
		if (size < 1) {
			throw new AirportRuntimeException("system.err.pagesize.wrong");
		}
		this.start = this.size * (this.page - 1);
	}

	/**
	 * 用于复制类
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		if (value != null) {
			// 判断是否是数组
			if (value.getClass().isArray()) {
				ret.append("value:");
				int length = Array.getLength(value);
				for (int i = 0; i < length; i++) {
					ret.append(Array.get(value, i));
					if (i < length)
						ret.append(",");
				}
				ret.append(split);
			}
			// 判断是否是list
			else if (value instanceof List) {
				List list = (List) value;
				for (int i = 0; i < list.size(); i++) {
					ret.append(Array.get(value, i));
					if (i < list.size())
						ret.append(",");
				}
				ret.append(split);
			}
		}
		if (params instanceof Map) {
			Map m = (Map) params;
			Set set = m.keySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String key = it.next().toString();
				ret.append(key);
				ret.append(":");
				ret.append(m.get(key));
				ret.append(split);
			}
			ret = new StringBuffer(ret.substring(0, ret.length() - 1));
		} else {
			ret.append(params.toString());
		}

		if (orderBy != null) {
			ret.append(split);
			ret.append("orderBy:");
			ret.append(orderBy);
		}
		ret.append(split);
		ret.append("start:");
		ret.append(this.start);
		ret.append(split);
		ret.append("page:");
		ret.append(page);
		ret.append(split);
		ret.append("size:");
		ret.append(this.size);
		ret.append(split);
		ret.append("asc:");
		ret.append(asc);
		return ret.toString();
	}
}
