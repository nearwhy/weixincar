package com.palm360.airport.util.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import com.palm360.airport.util.ErrorBundleReader;

/**
 * 常用异常基本类
 * @author zhangtong
 *
 */
public class AirportRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6483225199348182590L;
	private int code = 0x00;
	private String errKey = "system.err.unkown";
	private String message = "系统未知错误";
	private ErrorEnum errorEnum = ErrorEnum.USER;
//	Locale locale = null;
	public AirportRuntimeException(){
		
	}
	public AirportRuntimeException(Throwable throwable){
		super(throwable);
	}
	public AirportRuntimeException(int code){
		super();
		this.setCode(code);
	}
	public AirportRuntimeException(String errKey,Throwable throwable){
		super(throwable);
		this.setErrKey(errKey);
		ErrorBundleReader r = new ErrorBundleReader();
		if(r.readKeyCode(errKey).indexOf("x")!=-1
			||r.readKeyCode(errKey).indexOf("X")!=-1)
			this.code = Integer.parseInt(r.readKeyCode(errKey).substring(2),16);
		else
			this.code = Integer.parseInt(r.readKeyCode(errKey),16);
		this.setErrorEnum(ErrorEnum.getErrorEnum(code));
		this.message = r.readKeyMessage(errKey);		
	}
	public AirportRuntimeException(String errKey){
		super();
		this.setErrKey(errKey);
		ErrorBundleReader r = new ErrorBundleReader();
		if(r.readKeyCode(errKey).indexOf("x")!=-1
			||r.readKeyCode(errKey).indexOf("X")!=-1)
			this.code = Integer.parseInt(r.readKeyCode(errKey).substring(2),16);
		else
			this.code = Integer.parseInt(r.readKeyCode(errKey),16);
		this.setErrorEnum(ErrorEnum.getErrorEnum(code));
		this.message = r.readKeyMessage(errKey);
	}
	public AirportRuntimeException(int code,String message){
		super(message);
		this.setCode(code);
		this.message = message;
	}
	public AirportRuntimeException(int code,String message,Throwable throwable){
		super(throwable);
		this.setCode(code);
		this.message = message;
		
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
//		ErrorBundleReader r = new ErrorBundleReader();
//		this.message = r.readKeyMessage(errKey);
		if(null == this.message || "".equals(this.message))
			return super.getMessage();
		else
			return message;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setErrKey(String errKey) {
		this.errKey = errKey;
	}
	public String getErrKey() {
		return errKey;
	}
	public void setErrorEnum(ErrorEnum errorEnum) {
		this.errorEnum = errorEnum;
	}
	public ErrorEnum getErrorEnum() {
		return errorEnum;
	}
}
