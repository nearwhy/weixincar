package com.palm360.airport.redis;

import java.util.List;

/**
 * 记录log
 * @author palm360
 *
 */
public interface OprationLog {
	void writeLog(String key,int logEnum/*LogEnum*/,OprationEnum olog,String logContent);
	void writeLog(String key,FunctionEnum logEnum/*LogEnum*/,OprationEnum olog,String logContent);
	List getLogList(String list);
}
