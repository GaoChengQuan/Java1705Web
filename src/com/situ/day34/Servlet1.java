package com.situ.day34;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.test.StudentDaoMysqlImplTest;

public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("servlet1 service");
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		req.setAttribute("list", list);
		//RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
		//requestDispatcher.forward(req, resp);
		// 存储转发是给服务器看的，已经在tomcat下面的/Java1705Web下面所以这个"/"代表/Java1705Web
		//req.getRequestDispatcher("/servlet2").forward(req, resp);
		
		// 重定向是给浏览器看的，所以"/"代表的tomacat的目录
		String contextPath = req.getContextPath();
		//resp.sendRedirect("/Java1705Web/servlet2");
		resp.sendRedirect(contextPath + "/servlet2");
	}
}
