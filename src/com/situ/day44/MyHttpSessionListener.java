package com.situ.day44;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session创建 SessionID: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session销毁");
	}
}
