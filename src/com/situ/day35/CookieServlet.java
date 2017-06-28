package com.situ.day35;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、创建Cookie
		Cookie cookie1 = new Cookie("goods1", "IPhone7");
		Cookie cookie2 = new Cookie("goods2", "MI 5s");
		//2、设置Cookie在客户端的持久化时间,两分钟
		//cookie.setMaxAge(2*60);
		//3、设置Cookie的携带路径：
		//cookie.setPath("/");
		//cookie.setPath("/Java1705Web/cookie");
		//4、将创建的Cookie发动给浏览器
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
