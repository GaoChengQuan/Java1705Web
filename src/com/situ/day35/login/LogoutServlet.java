package com.situ.day35.login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.得到session
		HttpSession session = req.getSession(false);
		if (session != null) {
			//2、在session域对象中删除
			session.removeAttribute("userName");
		}
		//3.回到登陆界面
		resp.sendRedirect(req.getContextPath() + "/html/login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
