package com.situ.day44;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	//由setAttribute触发
	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		ServletContext servletContext = scab.getServletContext();
		System.out.println("attributeAdded name: " + scab.getName());
		System.out.println("attributeAdded value: " + scab.getValue());
	}
	
	//由removeAttribute触发
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("attributeRemoved name: " + scab.getName());
		System.out.println("attributeRemoved value: " + scab.getValue());
	}

	//由setAttribute触发,要求这个域对象之前已经有
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("attributeReplaced name: " + scab.getName());
		System.out.println("attributeReplaced value: " + scab.getValue());
	}

}
