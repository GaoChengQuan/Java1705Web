package com.situ.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.获取参数
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		System.out.println("name: " + name);
		System.out.println("password: " + password);
		//2.业务处理
		//2.1获得请求行
		System.out.println("请求方式： " + req.getMethod());
		System.out.println("访问路径： " + req.getServletPath());
		System.out.println("Http协议： " + req.getProtocol());
		//2.1获得请求头（多个key-value）
		Enumeration<String> enumeration = req.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + " : " + value);
		}
		//3.返回响应结果
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("This is TestServlet!");
	}
}
