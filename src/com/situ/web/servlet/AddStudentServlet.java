package com.situ.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.exception.NameRepeatException;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.接收参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("gender:" + gender);
		//2.处理业务
		Date date = new Date();
		Student student = new Student(name, Integer.parseInt(age), gender, date);
		IStudentService studentService = new StudentServiceImpl();
		boolean result = false;
		try {
			result = studentService.add(student);
		} catch (NameRepeatException e) {
			e.printStackTrace();
		}
		//3.输出响应
		resp.setContentType("text/html;charset=utf-8");
		/*PrintWriter printWriter = resp.getWriter();
		if (result) {
			printWriter.println("保存成功");
		} else {
			printWriter.println("保存失败");
		}*/
		//重定向
		resp.sendRedirect("findStudent");
	}
}
