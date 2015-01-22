package com.palm360.airport.dao;

import java.util.List;

import com.palm360.airport.util.stereotype.Replication;

public interface BaseDao<T> {

	/**
	 * 
	 * @return
	 */
	int queryAllCount();

	/**
	 * 
	 * @param size
	 * @param page
	 * @return
	 */
	@Replication(isLoad = true, isBeforeDB = true)
	List<T> queryAll(int size, int page);
}
