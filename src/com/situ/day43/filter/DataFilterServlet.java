package com.situ.day43.filter;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataFilterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String content = req.getParameter("content");
		System.out.println(content);
		req.setAttribute("content", content);
		req.getRequestDispatcher("/jsp/data_filter.jsp").forward(req, resp);
	}
}
