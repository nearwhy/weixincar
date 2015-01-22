package com.palm360.airport.service;


import com.palm360.airport.model.OprationContentEnum;
import com.palm360.airport.model.OprationTypeEnum;
import com.palm360.airport.model.Useroprationlog;

public interface LogService extends BaseService {
	static final String SPLIT="\r\n";
	void writeLoginLog(Object ui);//Log
	void writeOpLog(Object o);
	void writeLog(Useroprationlog uod);
	void writeLog(OprationTypeEnum op,OprationContentEnum oc,Object oprationObject,String content,String uuid,Integer userID);
}
