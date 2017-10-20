package com.growth.web.admin.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.growth.service.intf.hj.dto.AdminInfo;

public class SessionUtil {

	public static final String SESSION_USERINFO = "userInfo";

	/**
	 * 获取session中的userId
	 * 
	 * @param request
	 * @return
	 */
	public static Long getUserId(HttpServletRequest request) {
		return getUserInfo(request).getId();
	}

	/**
	 * 获取session中的userId
	 * 
	 * @return
	 */
	public static Long getUserId() {
		if (isNeedThrowLoginException(getUserInfo())) {
			throw new NeedLoginException();
		} else {
			return getUserInfo().getId();
		}
	}

	/**
	 * 获取session中的userInfo
	 * 
	 * @return
	 */
	public static AdminInfo getUserInfo(HttpServletRequest request) {
		Object userInfo = request.getSession(true).getAttribute(SESSION_USERINFO);
		if (userInfo == null) {
			throw new NeedLoginException();
		} else {
			if (isNeedThrowLoginException((AdminInfo) userInfo)) {
				throw new NeedLoginException();
			} else {
				return (AdminInfo) userInfo;
			}
		}
	}

	/**
	 * 获取session中的userInfo
	 * 
	 * @return
	 */
	public static AdminInfo getUserInfo() {
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
	public static void setUserInfo(HttpServletRequest request, AdminInfo adminUser) {
		// HttpSession session = request.getSession();
		// if (null != session) {
		// session.invalidate();
		// }
		request.getSession(true).setAttribute(SESSION_USERINFO, adminUser);
	}

	/**
	 * 根据用户信息判断是否需要抛出登录异常
	 * 
	 * @param userInfo
	 *            用户信息
	 * @return
	 */
	private static boolean isNeedThrowLoginException(AdminInfo adminUser) {
		return adminUser == null || adminUser.getId() == null;
	}

}
