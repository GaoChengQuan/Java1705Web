package com.situ.day34;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;

public class ContextServlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String name = (String) servletContext.getAttribute("name");
		System.out.println(name);
		//从域中取出集合
		List<Student> list = (List<Student>) servletContext.getAttribute("list");
		for (Student student : list) {
			System.out.println(student);
		}
		
		int count = (int) servletContext.getAttribute("count");
		count++;
		servletContext.setAttribute("count", count);
		System.out.println("count: " + count);
	}
}
