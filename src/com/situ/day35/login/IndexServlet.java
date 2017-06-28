package com.situ.day35.login;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//1.得到Session对象
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendRedirect(req.getContextPath() + "/html/login.html");
			return;
		}
		//2.得到会话数据
		String userName = (String) session.getAttribute("userName");
		if (userName == null) {
			resp.sendRedirect(req.getContextPath() + "/html/login.html");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("	<body>");
		builder.append("		欢迎回来:" + userName + "<a href=/Java1705Web/logout>退出登陆</a>");
		builder.append("	</body>");
		builder.append("</html>");
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(builder);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
