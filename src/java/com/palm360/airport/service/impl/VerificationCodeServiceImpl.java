package com.palm360.airport.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.palm360.airport.model.Commodityinfo;
import com.palm360.airport.model.RegisterPromotions;
import com.palm360.airport.model.UserInfo;
import com.palm360.airport.model.Verificationcode;
import com.palm360.airport.service.VerificationCodeService;
import com.palm360.airport.util.AirPortUtil;
import com.palm360.airport.util.AirportQueryP;
import com.palm360.airport.util.AirportResult;
import com.palm360.airport.util.Encryption;
import com.palm360.airport.util.OSUtil;
import com.palm360.airport.util.Encode.DimensionsCodeFatory;
import com.palm360.airport.util.exception.AirportRuntimeException;

@Service("verificationCodeService")
public class VerificationCodeServiceImpl extends BaseServiceImpl implements VerificationCodeService {

	@Value(value = "${qrcode.dir}")
	private String qrCodePath;

	public synchronized AirportResult addVerificationCode(UserInfo ui) {// 将方法设置为同步
		// 1.根据注册后的优惠列表里，拿出在有效期内的、数量大于0的数据。
		AirportQueryP qp = new AirportQueryP();
		qp.setValue(new Object[] { "*" });
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentTimeStamp", new Date());
		qp.setParams(params);
		qp.setOrderBy("Probability");
		List<RegisterPromotions> rpList = null;
		try {
			rpList = registerPromotionsDao.queryPromotionsByCurrentTimestamp(qp);
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new AirportRuntimeException("system.err.unkown", e);
		}

		// 2.在所有数据中，通过一定几率获得某一条数据。
		if (null == rpList || rpList.size() < 1) {// 如果当前没有优惠数据
			log.info("There are not register promotions");
			return null;
		}
		RegisterPromotions rp = rpList.get(getRandomByProbability(rpList));
		
		// 3.将该条数据进行二维码编制，然后存入到verificationCode表中。\
		List<Object> plist = new LinkedList<Object>();
		plist.add(AirPortUtil.fillStringBefore(rp.getPromotionsId().toString(), "0", 8));
		plist.add(AirPortUtil.fillStringBefore(ui.getUserID().toString(), "0", 8));
		plist.add(rp.getRecordTime().getTime());
		plist.add(rp.getOutOfDate().getTime());
		String content = StringUtils.join(plist.iterator(), "-");
		content = Encryption.EncodeThreeDES(content, "airport");
		if (OSUtil.isWindows()) {
			qrCodePath = "C:\\" + qrCodePath;
		}

		String path = DimensionsCodeFatory.getInstance().makeCode(qrCodePath, content);
		Verificationcode code = new Verificationcode();
		code.setContent(content);
		code.setFlag(0);
		code.setPath(path);
		code.setReleasedate(rp.getRecordTime());
		code.setUserid(ui.getUserID());
		code.setValiditydate(rp.getOutOfDate());
		code.setPromotionsId(rp.getPromotionsId());
		try {
			verificationCodeDao.insert(code);
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}

		// 4.将优惠表的count字段减一。
		RegisterPromotions updateRp = new RegisterPromotions();
		updateRp.setPromotionsId(rp.getPromotionsId());
		updateRp.setCount(rp.getCount() - 1);
		try {
			registerPromotionsDao.updateByPrimaryKeySelective(updateRp);
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
		
		// 5.返回抽到的结果，优惠表中的数据
		List<Commodityinfo> ciList = null;
		try {
			ciList = commodityInfoDao.selectByRegisterPromotionsId(rp.getPromotionsId());
		} catch (SQLException e) {
			throw new AirportRuntimeException("system.err.unkown", e);
		}
		AirportResult ar = new AirportResult();
		ar.put("registerPromotion", rp);
		ar.put("commodityList", ciList);

		return ar;
	}

	/**
	 * 根据几率进行随机
	 * 
	 * @param rps
	 * @return
	 */
	private int getRandomByProbability(List<RegisterPromotions> rps) {
		int index = 0;
		int probability = 10;
		boolean bingo = false;
		Random random = new Random();
		RegisterPromotions rp = null;
		for (int i = 0; i < rps.size(); i++) {
			rp = rps.get(i);
			probability = rp.getProbability();
			bingo = random.nextInt(probability) == 0; // 判断随机数是否等于0，此范围是[0,
														// probability)
			if (bingo) {
				index = i;
				break;
			}
		}
		return index;
	}

}
