package com.palm360.airport.service;

import com.palm360.airport.model.UserInfo;
import com.palm360.airport.util.AirportResult;

public interface VerificationCodeService extends BaseService {

	/**
	 * 新增验证码
	 * 
	 * @return
	 */
	AirportResult addVerificationCode(UserInfo ui);
}
