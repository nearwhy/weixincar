package com.aero.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aero.o2o.dao.O2ODao;


public abstract class BaseServiceImpl {
	
	@Autowired
	protected O2ODao o2oDao;
}
