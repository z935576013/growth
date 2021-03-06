package com.growht.web.admin.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.growth.common.utils.RequestUtil;
import com.growth.web.admin.util.SessionUtil;

public class AccessLogFilter extends OncePerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger("accesslog");

	private static final String STR_IP = "ip";

	private static final String STR_USER = "user";

	private static final String STR_SESSION_ID = "sessionId";

	private static final String STR_INVOKENO = "invokeNo";

	private static final String MIDDLE_LINE = "-";

	private static final String BLANK = "";

	private static final String SPACE = "   ";

	public Map<String, String> getParam(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = request.getParameter(key);
			paramMap.put(key, value);
		}
		return paramMap;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getRequestURI();
		String sessionId = request.getSession(true).getId();
		String userAgent = request.getHeader("User-Agent");
		Long userId = null;
		try {
			userId = SessionUtil.getUserId(request);
		} catch (Exception e) {
			userId = null;
		}
		String ip = RequestUtil.getClientIp(request);

		// 向MDC里面set ip、user
		MDC.put(STR_IP, ip);
		if (userId != null) {
			MDC.put(STR_USER, userId.toString());
		}
		MDC.put(STR_SESSION_ID, sessionId);

		// 调用流水号
		MDC.put(STR_INVOKENO,
				UUID.randomUUID().toString().replace(MIDDLE_LINE, BLANK));

		// 参数
		Map<String, String[]> paramMap = request.getParameterMap();

		// 计算action method执行方法
		long startTime = System.currentTimeMillis();
		long executionTime = 0L;

		// 拼接LOG信息
		StringBuilder message = new StringBuilder(500);
		try {// 调用用户访问的CONTROLLER
			filterChain.doFilter(request, response);
			executionTime = System.currentTimeMillis() - startTime;
		} finally {
			message.append(userAgent).append(SPACE).append(sessionId)
					.append(SPACE).append(path).append(SPACE)
					.append(JSON.toJSONString(paramMap)).append(SPACE)
					.append(executionTime);

			// 记录日志
			LOG.info(message.toString());
			// 清除MDC里面的历史信息
			MDC.remove(STR_IP);
			MDC.remove(STR_USER);
			MDC.remove(STR_SESSION_ID);
			MDC.remove(STR_INVOKENO);
		}
	}
}
