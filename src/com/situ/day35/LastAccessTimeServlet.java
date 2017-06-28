package com.situ.day35;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.记录当前的访问时间，以Cookie方式返回。
		Date date = new Date();
		//2017-06-28 15:26
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = simpleDateFormat.format(date);
		Cookie cookie = new Cookie("lastAccessTime", time);
		cookie.setMaxAge(60*60*24*30);//一定要持久化
		resp.addCookie(cookie);
		
		//2.获取客户端携带的Cookie
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals("lastAccessTime")) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		resp.setContentType("text/html;charset=utf-8");
		if (lastAccessTime == null) {
			resp.getWriter().println("您是第一次访问!");
		} else {
			resp.getWriter().println("您上次访问的时间：" + lastAccessTime);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
