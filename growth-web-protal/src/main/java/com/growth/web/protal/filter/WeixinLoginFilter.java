package com.growth.web.protal.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.growth.common.utils.WeixinUtil;
import com.growth.service.intf.hj.UserService;
import com.growth.service.intf.hj.dto.UserInfo;
import com.growth.web.protal.util.SessionUtil;

public class WeixinLoginFilter extends OncePerRequestFilter {
	/**
	 */
	private static String host = "http://www.yzczxy.cn";

	private static boolean initFlag = false;

	private UserService userService = null;

	private static String WEIXIN_URL_PRE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ WeixinUtil.mp_appId + "&redirect_uri=" + host + "/growth-web-protal";

	private static String WEIXIN_URL_SUFFIX = "response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!initFlag) {
			init();
		}

		String agent = request.getHeader("User-Agent");
		if (StringUtils.isNotEmpty("agent") && agent.indexOf("MicroMessenger") >= 0) {
			// access by wx
			String openid = SessionUtil.getOpenid(request);
			if (openid == null) {
				String code = request.getParameter("code");
				if (code == null) {
					String url = WEIXIN_URL_PRE + request.getServletPath();
					if (StringUtils.isEmpty(request.getQueryString())) {
						url = url + "?" + WEIXIN_URL_SUFFIX;
					} else {
						url = url + "?" + request.getQueryString() + "&" + WEIXIN_URL_SUFFIX;
					}
					response.sendRedirect(url);
					return;
				} else {
					openid = WeixinUtil.getUserInfo(code, WeixinUtil.WEIXIN_TYPE_MP);
					SessionUtil.setOpenid(request, openid);
				}
			}

			if (openid != null) {
				// 微信登陆
				UserInfo user = SessionUtil.getUserInfoNoThrow(request);
				if (user == null) {
					user = userService.getUserByOpenid(openid);
					if (user != null) {
						SessionUtil.setUserInfo(request, user);
					}
				}
			}
		}

		filterChain.doFilter(request, response);
	}

	private synchronized void init() {
		if (initFlag) {
			return;
		}
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		userService = (UserService) ctx.getBean("userServiceImpl");
	}
}
