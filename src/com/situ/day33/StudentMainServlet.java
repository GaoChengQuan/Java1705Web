package com.situ.day33;


import java.io.IOException;
import java.io.PrintWriter;
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

public class StudentMainServlet extends HttpServlet {
	IStudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		if ("/addStudent.do".equals(servletPath)) {
			addStudent(req, resp);
		} else if ("/findStudents.do".equals(servletPath)) {
			findStudents(req, resp);
		} else if ("/deleteStudent.do".equals(servletPath)) {
			deleteStudent(req, resp);
		} else if ("/toUpdateStudent.do".equals(servletPath)) {
			toUpdateStudent(req, resp);
		} else if ("/updateStudent.do".equals(servletPath)) {
			updateStudent(req, resp);
		}
	}

	private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
		
		resp.sendRedirect(req.getContextPath() + "/findStudents.do");
	}

	private void toUpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student student = studentService.findById(Integer.parseInt(id));
		req.setAttribute("student", student);
		req.getRequestDispatcher("/edit_student.jsp").forward(req, resp);
	}

	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String contextPath = req.getContextPath();
		String id = req.getParameter("id");
		boolean result = studentService.delete(Integer.parseInt(id));
		if (result) {
			resp.sendRedirect(contextPath + "/findStudents.do");
		}
	}

	private void findStudents(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 1.接收参数
		// 2.业务处理
		List<Student> list = studentService.findAll();
		// 3.返回结果
		req.setAttribute("list", list);
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
		// 乱码问题
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		// 当前：/Java1705Web/findServlet
		// 目标：/Java1705Web/html/add_student.html
		printWriter.println("<a href='html/add_student.html' >添加</a>");
		printWriter
				.println("<table border='1' cellspacing='0' align='center'>");
		printWriter.println("    <tr>");
		printWriter.println("         <td>编号</td>");
		printWriter.println("         <td>姓名</td>");
		printWriter.println("         <td>年龄</td>");
		printWriter.println("         <td>性别</td>");
		printWriter.println("         <td>删除</td>");
		printWriter.println("         <td>修改</td>");
		printWriter.println("    </tr>");
		for (Student student : list) {
			printWriter.println("<tr>");
			printWriter.println("    <td>" + student.getId() + "</td>");
			printWriter.println("    <td>" + student.getName() + "</td>");
			printWriter.println("    <td>" + student.getAge() + "</td>");
			printWriter.println("    <td>" + student.getGender() + "</td>");
			printWriter.println("    <td><a href=/Java1705Web/deleteStudent.do?id=" + student.getId() + ">删除<a/></td>");
			printWriter.println("    <td><a href=/Java1705Web/updateStudent.do?id=" + student.getId() + ">修改<a/></td>");
			printWriter.println("</tr>");
		}
		printWriter.println("</table>");
		printWriter.close();*/
	}

	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		// 1.接收参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("gender:" + gender);
	/*	byte[] bytes = gender.getBytes("iso8859-1");
		gender = new String(bytes, "utf-8");
		System.out.println("gender: " + gender);*/
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
		//resp.setCharacterEncoding("utf-8");
		/*
		 * PrintWriter printWriter = resp.getWriter(); if (result) {
		 * printWriter.println("保存成功"); } else { printWriter.println("保存失败"); }
		 */
		// 重定向
		resp.sendRedirect("findStudents.do");
		
	}
}
