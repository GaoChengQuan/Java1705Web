package com.situ.day33;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Context上下文
		System.out.println(req.getContextPath());//  /Java1705Web
		System.out.println(req.getServletPath());//  /path
		System.out.println(req.getRequestURI());//   /Java1705Web/path
		System.out.println(req.getRequestURL());//	 http://localhost:8081/Java1705Web/path
	}
}
