package com.growth.common.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 微信接口
 * 
 * @author LFL
 *
 */
public class WeixinUtil {

	/**
	 * 微信类型 开放平台
	 */
	public static final int WEIXIN_TYPE_OPEN = 0;

	/**
	 * 微信类型 公众平台
	 */
	public static final int WEIXIN_TYPE_MP = 1;

	/**
	 * 开放平台 开发者
	 */
	public static String open_appId = "wx7b003cbf47237da1";
	/**
	 * 开放平台AppSecret
	 */
	private static String open_secret = "516759f9e6c02a116efaef4f9d22e286";

	/**
	 * 公众平台 开发者
	 */
	public static String mp_appId = "wx6e064ac0b7436d18";
	/**
	 * 公众平台AppSecret
	 */
	private static String mp_secret = "23de573835a2028226cbaefc939fb89c";

	public static String OPENID = "openid";

	/**
	 * 
	 */
	private static String open_accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
			+ open_appId
			+ "&secret="
			+ open_secret
			+ "&grant_type=authorization_code&code=";

	/**
	 * 
	 */
	private static String mp_accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
			+ mp_appId
			+ "&secret="
			+ mp_secret
			+ "&grant_type=authorization_code&code=";

	// /**
	// *
	// */
	// private static String userInfoUrl =
	// "https://api.weixin.qq.com/sns/userinfo";

	/**
	 * 通过code获取openid
	 * 
	 * @param code
	 * @param type
	 *            0:开放平台 1:公众平台
	 * @return
	 */
	public static String getUserInfo(String code, int type) {
		String url = null;
		switch (type) {
		case WEIXIN_TYPE_OPEN:
			url = open_accessTokenUrl + code;
			break;
		case WEIXIN_TYPE_MP:
			url = mp_accessTokenUrl + code;
		}
		String resp = HttpClientUtil.postData(url, "", null);
		String openid = null;
		try {
			JSONObject json = new JSONObject(resp);
			openid = json.getString(OPENID);
			return openid;
		} catch (JSONException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		String code = "0310RBnm18nvtl0w1prm1dMEnm10RBn2";
		String openId = WeixinUtil.getUserInfo(code, WeixinUtil.WEIXIN_TYPE_MP);
		System.out.println(openId);
	}

}
