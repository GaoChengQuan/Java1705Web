package com.situ.day43.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter2 implements Filter{
	
	public HelloFilter2() {
		System.out.println("Filter2 HelloFilter()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter2 init()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter2 doFilter() before");
		//执行下一个过滤器或放行（访问servlet） 
		chain.doFilter(request, response);
		System.out.println("Filter2 doFilter() after");
	}

	@Override
	public void destroy() {
		System.out.println("Filter2 destroy()");
	}

}
