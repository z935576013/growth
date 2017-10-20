package com.growth.common.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;

/**
 * 
 * @author zhuliang
 */
public class AliyunSmsUtils {

	public static boolean send(String mobile, String valCode, String tempID) {
		try {
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI9z2P60LAU5ZI",
					"DufGZxQcfX5yZvP27Dx7ZB5P78BEzA");
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName("成长学院");
			request.setTemplateCode(tempID);
			request.setParamString("{\"validation_code\":\"" + valCode + "\"}");
			request.setRecNum(mobile);// 接收号码
			client.getAcsResponse(request);
			return true;
		} catch (ServerException e) {
			e.printStackTrace();
			return false;
		} catch (ClientException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String args[]) {
		AliyunSmsUtils.send("18512528547", "1", "SMS_57280001");
	}

}
