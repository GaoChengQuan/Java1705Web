<%@page import="com.situ.student.entity.Student"%>
<%@page import="com.situ.student.service.impl.StudentServiceImpl"%>
<%@page import="com.situ.student.service.IStudentService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'hello.jsp' starting page</title>
  </head>
  
  <body>
    <!-- JSP脚本 -->
    <%
    	//定义变量
    	String name = "张三";
    	IStudentService studentService = new StudentServiceImpl();
    	List<Student> list = studentService.findAll();
     %>
     <!-- JSP表达式 -->
     <%=1+2 %><br/>
     <%=name %><br/>
     <hr/>
     <%
     	for (Student student : list) {
     %>
     		id:<%=student.getId() %><br/>
     		姓名:<%=student.getName() %><br/>
     		年龄:<%=student.getAge() %><br/>
     		性别:<%=student.getGender() %><br/>
     <%
     	}
      %>
  </body>
</html>
