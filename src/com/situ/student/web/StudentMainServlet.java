package com.situ.student.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class StudentMainServlet extends BaseServlet {
	IStudentService studentService = new StudentServiceImpl();
	
	private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		String searchValue = req.getParameter("searchValue");
		List<Student> list = studentService.findByName(searchValue);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		
		Student student = studentService.findById(Integer.parseInt(id));
		student.setName(name);
		student.setAge(Integer.parseInt(age));
		student.setGender(gender);
		studentService.update(student);
		
		resp.sendRedirect(req.getContextPath() + "/student?method=findAll");
	}

	private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student student = studentService.findById(Integer.parseInt(id));
		req.setAttribute("student", student);
		req.getRequestDispatcher("/edit_student.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String contextPath = req.getContextPath();
		String id = req.getParameter("id");
		boolean result = studentService.delete(Integer.parseInt(id));
		if (result) {
			resp.sendRedirect(contextPath + "/student?method=findAll");
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 1.接收参数
		// 2.业务处理
		List<Student> list = studentService.findAll();
		// 3.返回结果
		req.setAttribute("list", list);
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		// 1.接收参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("gender:" + gender);
		// 2.处理业务
		Date date = new Date();
		Student student = new Student(name, Integer.parseInt(age), gender, date);
		IStudentService studentService = new StudentServiceImpl();
		boolean result = false;
		try {
			result = studentService.add(student);
		} catch (NameRepeatException e) {
			e.printStackTrace();
		}
		// 3.输出响应
		resp.setContentType("text/html;charset=utf-8");
		// 重定向
		resp.sendRedirect(req.getContextPath() + "/student?method=findAll");
		
	}
}
