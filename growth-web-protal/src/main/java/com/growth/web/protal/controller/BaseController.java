package com.growth.web.protal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 请求控制基类
 * 
 * @author LiuCongwen
 * 
 */
public abstract class BaseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger("BaseController");

	/**
	 * 获取请求参数
	 * 
	 * @param paramName
	 *            参数名
	 * @param request
	 * @return
	 */
	protected String getParam(String paramName, HttpServletRequest request) {
		return request.getParameter(paramName);
	}

	/**
	 * 获取请求参数整数
	 * 
	 * @param paramName
	 *            参数名
	 * @param request
	 * @return
	 */
	protected Integer getIntParam(String paramName, HttpServletRequest request) {
		String param = request.getParameter(paramName);

		Integer intParam = null;
		try {
			intParam = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			LOGGER.warn(paramName + " is not a number, paramName=" + param);
		}

		return intParam;
	}

	/**
	 * 获取请求参数长整数
	 * 
	 * @param paramName
	 *            参数名
	 * @param request
	 * @return
	 */
	protected Long getLongParam(String paramName, HttpServletRequest request) {
		String param = request.getParameter(paramName);

		Long intParam = null;
		try {
			intParam = Long.parseLong(param);
		} catch (NumberFormatException e) {
			LOGGER.warn(paramName + " is not a number, paramName=" + param);
		}

		return intParam;
	}

	/**
	 * 验证请求参数是否非空
	 * 
	 * @param paramName
	 *            参数名
	 * @param request
	 * @return
	 */
	protected void checkParamEmpty(Object paramValue, String paramName)
			throws RuntimeException {
		if (paramValue == null
				|| (paramValue instanceof String && ""
						.equals((String) paramValue))) {
			LOGGER.warn(paramName + " is empty");
			throw new RuntimeException(paramName + " is empty");
		}
	}
}
