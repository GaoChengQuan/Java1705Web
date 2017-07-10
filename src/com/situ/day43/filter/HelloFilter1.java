package com.situ.day43.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter1 implements Filter{
	
	public HelloFilter1() {
		System.out.println("Filter1 HelloFilter()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter1 init()");
		String encodingValue = filterConfig.getInitParameter("encoding");
		System.out.println(encodingValue);
		//获取所有参数的名字
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		//根据名字遍历，取出所有的对应的value
		while (enumeration.hasMoreElements()) {
			//获取所有参数名称：encoding，path
			String name = enumeration.nextElement();
			//获取名称对应的值
			String value = filterConfig.getInitParameter(name);
			System.out.println("name: " + name + ", value: " + value);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter1 doFilter() before");
		//执行下一个过滤器或放行（访问servlet） 
		chain.doFilter(request, response);
		System.out.println("Filter1 doFilter() after");
	}

	@Override
	public void destroy() {
		System.out.println("Filter1 destroy()");
	}
}
