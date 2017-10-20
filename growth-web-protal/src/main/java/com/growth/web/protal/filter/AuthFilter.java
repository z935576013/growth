package com.growth.web.protal.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.growth.service.intf.hj.dto.UserInfo;
import com.growth.web.protal.util.SessionUtil;

public class AuthFilter implements Filter {

	public static final List<String> NEED = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;

		{
			add("/game/joinGame.htm");
			add("/user/*");
		}
	};

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest requestSer, ServletResponse responseSer, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) requestSer;
		HttpServletResponse response = (HttpServletResponse) responseSer;

		// 不需要登录链接直接转发
		if (match(request)) {
			UserInfo user = SessionUtil.getUserInfo(request);
			if (user != null) {
				// 已登录直接转发
				chain.doFilter(request, response);
			} else {
				// 未登录跳转到登录页面
				response.sendRedirect("/growth-web-protal/login/loginPage.htm");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// do nothing
	}

	private boolean match(HttpServletRequest request) {
		boolean result = false;
		for (String mertUrl : NEED) {
			RequestMatcher urlMatcher = new AntPathRequestMatcher(mertUrl);
			if (urlMatcher.matches(request)) {
				result = true;
				break;
			}
		}
		return result;
	}

}
