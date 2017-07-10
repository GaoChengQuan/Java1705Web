package com.situ.day43.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DataFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//装饰者设计模式，在原来的基础上装饰一下，在调getParameter时处理好乱码
		EnhancedRequest enhancedRequest = new EnhancedRequest(req);
		//放行到下一个过滤器或者servlet
		chain.doFilter(enhancedRequest, response);
	}

	@Override
	public void destroy() {
	}

}

class EnhancedRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public EnhancedRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String parameter = request.getParameter(name);//带有非法的数据的字符串
		if (parameter != null && !parameter.equals("")) {
			//非法数据过滤
			List<String> list = WordsUtil.getWords();
			for (String word : list) {
				parameter = parameter.replaceAll(word, "*");
			}
		}
		return parameter;
	}
}
