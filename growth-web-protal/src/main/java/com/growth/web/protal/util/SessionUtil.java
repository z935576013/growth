package com.growth.web.protal.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.growth.service.intf.hj.dto.UserInfo;

public class SessionUtil {

	public static final String SESSION_USERINFO = "sessionUser";

	public static final String SESSION_OPENID = "sessionOpenid";

	public static void setOpenid(HttpServletRequest request, String openid) {
		request.getSession(true).setAttribute(SESSION_OPENID, openid);
	}

	public static String getOpenid(HttpServletRequest request) {
		Object openid = request.getSession(true).getAttribute(SESSION_OPENID);
		if (openid == null) {
			return null;
		} else {
			return (String) openid;
		}
	}

	/**
	 * 获取session中的userId
	 * 
	 * @param request
	 * @return
	 */
	public static Long getUserId(HttpServletRequest request) {
		UserInfo user = getUserInfo(request);
		if (user != null) {
			return user.getId();
		} else {
			return null;
		}
	}

	/**
	 * 获取session中的userId
	 * 
	 * @return
	 */
	public static Long getUserId() {
		UserInfo user = getUserInfo();
		if (user != null) {
			return user.getId();
		} else {
			return null;
		}
	}

	/**
	 * 获取session中的userInfo
	 * 
	 * @return
	 */
	public static UserInfo getUserInfo(HttpServletRequest request) {
		Object userInfo = request.getSession(true).getAttribute(SESSION_USERINFO);
		if (userInfo == null) {
			return null;
		} else {
			return (UserInfo) userInfo;
		}
	}

	public static UserInfo getUserInfoNoThrow(HttpServletRequest request) {
		Object userInfo = request.getSession(true).getAttribute(SESSION_USERINFO);
		if (userInfo == null) {
			return null;
		} else {
			return (UserInfo) userInfo;
		}
	}

	/**
	 * 获取session中的userInfo
	 * 
	 * @return
	 */
	public static UserInfo getUserInfo() {
		return getUserInfo(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
	}

	/**
	 * 将userInfo设置到session中
	 * 
	 * @param request
	 * @param userId
	 *            用户编号
	 * @return
	 */
	public static void setUserInfo(HttpServletRequest request, UserInfo userInfo) {
		// HttpSession session = request.getSession();
		// if (null != session) {
		// session.invalidate();
		// }
		request.getSession(true).setAttribute(SESSION_USERINFO, userInfo);
	}

	public static void removeSession(HttpSession session) {
		if (session != null) {
			session.removeAttribute(SESSION_USERINFO);
		}
	}

}
