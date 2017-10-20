package com.growth.service.hj;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growth.common.dal.DalClient;
import com.growth.common.sms.AliyunSmsUtils;
import com.growth.service.intf.hj.SmsService;
import com.growth.service.intf.hj.dto.SmsCode;

@Service
public class SmsServiceImpl implements SmsService {

	@Autowired
	DalClient dalClient;

	private static final String SMS_TEMP_REGIST = "SMS_56730193";

	private static final String SMS_TEMP_RESET = "SMS_57280001";

	@Override
	public void sendSmsCode(String mobile, Integer regist) {
		if (StringUtils.isNotEmpty(mobile)) {
			String valCode = genValCode();
			boolean smsFlag = false;
			if (regist == null || regist == 1) {
				smsFlag = AliyunSmsUtils.send(mobile, valCode, SMS_TEMP_REGIST);
			} else {
				smsFlag = AliyunSmsUtils.send(mobile, valCode, SMS_TEMP_RESET);
			}
			if (smsFlag) {
				SmsCode sms = new SmsCode();
				sms.setMobile(mobile);
				sms.setCreateTime(new Date());
				sms.setValCode(valCode);
				dalClient.persist(sms);
			}
		}
	}

	@Override
	public boolean validSmsCode(String mobile, String valCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", mobile);
		map.put("orderBy", "CREATE_TIME");
		map.put("orderByDesc", "DESC");
		map.put("startIndex", 0);
		map.put("maxCount", 1);
		SmsCode smsCode = dalClient.queryForObject("SMS_CODE.SELECT_BY_FIELDS", map, SmsCode.class);
		if (smsCode != null && Objects.equals(smsCode.getValCode(), valCode)) {
			return true;
		} else {
			return false;
		}
	}

	private String genValCode() {
		int r = ThreadLocalRandom.current().nextInt(1000000);
		String valiCode = String.valueOf(r);
		int length = valiCode.length();
		switch (length) {
		case 0:
			valiCode = valiCode + "000000";
			break;
		case 1:
			valiCode = valiCode + "00000";
			break;
		case 2:
			valiCode = valiCode + "0000";
			break;
		case 3:
			valiCode = valiCode + "000";
			break;
		case 4:
			valiCode = valiCode + "00";
			break;
		case 5:
			valiCode = valiCode + "0";
			break;
		}
		return valiCode;
	}

}
