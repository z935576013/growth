/*
 * Copyright (C), 2013-2014, 
 * FileName: AccessLog.java
 * Author:   zhuliang
 * Date:     2014年10月16日 下午1:30:32
 */
package com.growth.web.protal.filter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 访问日志
 * 
 * @author zhuliang
 */
public class AccessLog implements Serializable {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1L;
	private static final String SPACE = "   ";
	/**
	 * 日期格式
	 */
	private static String datePattern = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

	/**
	 * 
	 */
	private String path;

	/**
	 * 
	 */
	private String clientIp;

	/**
	 * 
	 */
	private String userAgent;

	/**
	 * 
	 */
	private String request;

	/**
	 * 
	 */
	private Map<String, String[]> realRequest;

	/**
	 * 
	 */
	private String response;

	/**
	 * 
	 */
	private String encResponse;

	/**
	 * 
	 */
	private Date requestTime;

	/**
	 * 
	 */
	private String randomPwd;

	/**
	 * 
	 */
	private Long userId;

	private Long cost;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 * @param clientIp
	 *            the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * @return the realRequest
	 */
	public Map<String, String[]> getRealRequest() {
		return realRequest;
	}

	/**
	 * @param realRequest
	 *            the realRequest to set
	 */
	public void setRealRequest(Map<String, String[]> realRequest) {
		this.realRequest = realRequest;
	}

	/**
	 * @return the encResponse
	 */
	public String getEncResponse() {
		return encResponse;
	}

	/**
	 * @param encResponse
	 *            the encResponse to set
	 */
	public void setEncResponse(String encResponse) {
		this.encResponse = encResponse;
	}

	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * @param userAgent
	 *            the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * @return the requestTime
	 */
	public Date getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime
	 *            the requestTime to set
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the randomPwd
	 */
	public String getRandomPwd() {
		return randomPwd;
	}

	/**
	 * @param randomPwd
	 *            the randomPwd to set
	 */
	public void setRandomPwd(String randomPwd) {
		this.randomPwd = randomPwd;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the cost
	 */
	public Long getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(Long cost) {
		this.cost = cost;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(sdf.format(this.requestTime)).append(SPACE).append(cost)
				.append(SPACE).append(this.clientIp).append(SPACE)
				.append(this.userAgent).append(SPACE).append(this.path)
				.append(SPACE).append(JSON.toJSONString(this.request))
				.append(SPACE).append(JSON.toJSONString(this.realRequest))
				.append(SPACE).append(this.response).append(SPACE)
				.append(this.encResponse).append(SPACE).append(this.userId)
				.append(SPACE).append(this.randomPwd);
		return sb.toString();
	}
}
