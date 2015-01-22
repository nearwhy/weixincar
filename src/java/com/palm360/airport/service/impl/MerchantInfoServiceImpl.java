package com.palm360.airport.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.palm360.airport.model.Merchantinfo;
import com.palm360.airport.model.Usercomment;
import com.palm360.airport.service.MerchantInfoService;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.AirportResult;
import com.palm360.airport.util.exception.AirportRuntimeException;

@Service("merchantInfoService")
public class MerchantInfoServiceImpl extends BaseServiceImpl implements MerchantInfoService {

	public Merchantinfo getMerchantInfo(Merchantinfo record) {
		try {
			return merchantInfoDao.selectByPrimaryKey(record);
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown");
		}
	}

	public Map<String, Object> getMerchantInfoAndUserComments(AirportQueryP qp, Merchantinfo record) {
		List<Usercomment> userComments = null;
		Merchantinfo info = null;
		try {
			info = merchantInfoDao.selectByPrimaryKey(record);
			if (null != info) {
				userComments = userCommentDao.queryUserComments(qp);
			}
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown");
		}
		AirportResult merchantInfo_ar = new AirportResult();
		merchantInfo_ar.setRsObject(info);

		AirportResult userComments_ar = new AirportResult();
		userComments_ar.setPage(qp.getPage());
		userComments_ar.setSize(qp.getSize());
		userComments_ar.setRsObject(userComments);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("merchantInfo_ar", merchantInfo_ar);
		map.put("userComments_ar", userComments_ar);
		return map;
	}

}
