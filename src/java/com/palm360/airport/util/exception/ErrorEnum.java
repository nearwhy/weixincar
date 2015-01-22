package com.palm360.airport.util.exception;

public enum ErrorEnum {
	
	SYSTEM(0x01,0xff),
	BUSINESS(0x100,0xfff),
	USER(0x1000,0xffff),
	UNKOWN(0,0){
		
	};
	private ErrorEnum(){
		
	}
	private ErrorEnum(int min){
		this.min = min;
	}
	private ErrorEnum(int min,int max){
		this.min = min;
		this.max = max;
	}
	public static ErrorEnum getErrorEnum(int code){
		if(code >= SYSTEM.getMin() && code <=SYSTEM.getMax())
			return ErrorEnum.SYSTEM;
		else if(code >= BUSINESS.getMin() && code <= BUSINESS.getMax())
			return ErrorEnum.BUSINESS;
		else if(code >= USER.getMin() && code <= USER.getMax())
			return ErrorEnum.USER;
		
		return ErrorEnum.UNKOWN;
	}
	private int min;
	private int max;
	public int getMin(){
		return min;
	}
	public int getMax(){
		return max;
	}
	//static final int SYSTEM_MIN=0X01;
}
