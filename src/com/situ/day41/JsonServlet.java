package com.situ.day41;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("{\"name\":\"zhangsan\", \"age\":18}");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost");
	}
}
