package com.growth.service.intf.hj;

public interface SmsService {

	/**
	 * 发送短信验证码
	 */
	void sendSmsCode(String mobile, Integer regist);

	/**
	 * 交验短信验证码
	 */
	boolean validSmsCode(String mobile, String valCode);

}
