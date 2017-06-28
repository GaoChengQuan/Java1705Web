package com.situ.day35.login;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.获取参数
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		//2.业务处理
		if (name.equals("zhangsan") && password.equals("123")) {
			//登陆成功
			/**
			 * request域对象：不适合，整个网站必须用存储转发跳转界面才可以。
			 * ServletContext：不合适，可能会覆盖数据。
			 * session域对象：合适。
			 * 登陆成功后把用户名保存到session中
			 */
			//1.构造seesion域对象
			HttpSession session = req.getSession();
			//2.把数据存到域对象中
			session.setAttribute("userName", name);
			//3.跳转到用户主页IndexServlet
			resp.sendRedirect(req.getContextPath() + "/index");
		} else {
			//登陆失败
			resp.sendRedirect(req.getContextPath() + "/html/fail.html");
		}
		//3.返回数据
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
