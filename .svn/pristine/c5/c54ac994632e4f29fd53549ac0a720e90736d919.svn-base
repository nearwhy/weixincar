package com.palm360.airport.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.palm360.airport.model.OprationContentEnum;
import com.palm360.airport.model.OprationTypeEnum;
import com.palm360.airport.model.Useroprationlog;
import com.palm360.airport.service.LogService;


/**
 * log记录业务类
 * @author palm360
 *
 */
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl implements LogService {
	
	public void writeLog(Useroprationlog uod) {
		System.out.println(uod);
		userOprationlogDao.insert(uod);
		
	}
	/**
	 * 
	 */
	public void writeLog(OprationTypeEnum op, OprationContentEnum oc,
			Object oprationObject,String content, String uuid,Integer userID) {
		// TODO Auto-generated method stub
		Useroprationlog ul = new Useroprationlog();
		if(oprationObject !=null)
			ul.setContent(content+LogService.SPLIT+oprationObject);
		else
			ul.setContent(content);
		ul.setUuid(uuid);
		ul.setOprationcontent(oc.toString());
		ul.setOprationdate(new Timestamp(new Date().getTime()));
		ul.setUserid(userID);
		this.writeLog(ul);
	}

	public void writeLoginLog(Object ui) {
		// TODO Auto-generated method stub
		
	}

	public void writeOpLog(Object o) {
		// TODO Auto-generated method stub
		
	}
	
}
