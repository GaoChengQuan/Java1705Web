package com.situ.day41;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet");
		String name = req.getParameter("name");
		System.out.println("name: " + name);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("lisi");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost");
		resp.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		System.out.println("name: " + name);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("lisi");
	}
}
