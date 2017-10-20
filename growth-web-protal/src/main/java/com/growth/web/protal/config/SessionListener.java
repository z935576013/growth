package com.growth.web.protal.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// 8小时
		event.getSession().setMaxInactiveInterval(28800);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
//		ClusterWebSessionMgr mgr = ClusterWebSessionMgr.single();
//		String loginId = mgr.getOldLoginIds().get(event.getSession().hashCode());
//		if (StringUtils.isNotBlank(loginId)) {
//			ClusterWebSessionMgr.ClusterWebSessionEvent e = new DefaultClusterWebSessionEvent(event.getSession(), loginId);
//			e.onSessionDestory();
//		}
	}
}