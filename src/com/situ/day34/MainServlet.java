package com.situ.day34;


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

public class MainServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		if ("/addStudent.action".equals(servletPath)) {
			addStudent(req, resp);
		} else if ("/findStudents.action".equals(servletPath)) {
			findStudents(req, resp);
		}
	}

	private void findStudents(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1.接收参数
		// 2.业务处理
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		// 3.返回结果
		// 乱码问题
		resp.setContentType("text/html;charset=utf-8");
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
		printWriter.println("    </tr>");
		for (Student student : list) {
			printWriter.println("<tr>");
			printWriter.println("    <td>" + student.getId() + "</td>");
			printWriter.println("    <td>" + student.getName() + "</td>");
			printWriter.println("    <td>" + student.getAge() + "</td>");
			printWriter.println("    <td>" + student.getGender() + "</td>");
			printWriter.println("</tr>");
		}
		printWriter.println("</table>");
		printWriter.close();
	}

	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1.接收参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("gender:" + gender);
		byte[] bytes = gender.getBytes("iso8859-1");
		gender = new String(bytes, "utf-8");
		System.out.println("gender: " + gender);
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
		
		//findStudents(req, resp);
		
		// 3.输出响应
		resp.setContentType("text/html;charset=utf-8");
	
		// 重定向
		resp.sendRedirect("findStudents.action");
	}

}
