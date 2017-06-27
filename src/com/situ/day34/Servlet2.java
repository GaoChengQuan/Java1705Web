package com.situ.day34;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;

public class Servlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("servlet2 service");
		List<Student> list = (List<Student>) req.getAttribute("list");
		if (null != list) {
			for (Student student : list) {
				System.out.println(student);
			}
		}
	}
}
