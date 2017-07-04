<%@page import="com.situ.student.service.impl.StudentServiceImpl"%>
<%@page import="com.situ.student.service.IStudentService"%>
<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'hello.jsp' starting page</title>
  </head>
  
  <body>
  <%=1/0 %>
    <!-- JSP脚本 -->
  	<%
  		String name = "zhangsan";
  		IStudentService studentService = new StudentServiceImpl();
  		List<Student> list = studentService.findAll();
  	 %>
  	 
  	 <!-- Jsp表达式 -->
  	 <%=name %><br/>
  	 <%
  	 	for(Student student : list) {
  	 %>
  	 		ID:<%=student.getId() %><br/>
  	 		名字:<%=student.getName() %><br/>
  	 		年龄:<%=student.getAge() %><br/>
  	 		性别:<%=student.getGender() %><br/>
  	 <%
  	 	}
  	  %>
  	  
  	  <!-- JSP声明 -->
  	  <%!
  	  		int age = 20;
  	  		
  	  		public int getAge() {
  	  			return age;
  	  		}
  	   %>
  	   
  	 <hr/>
	 <%
	 	for(int i = 1; i <= 6; i++) {
	 %>
	 		<h<%=i %>>标题<%=i %></h<%=i %>>
	 <%
	 	}
	  %>
	  
	  <!-- 9*9乘法表 -->
	   <%
	  		for(int i = 1;i <= 9; i++) {
	  			for(int j = 1; j <= i; j++) {
	   %>
	  				<%=i%> * <%=j %> = <%=i*j %>&nbsp;&nbsp;&nbsp;&nbsp;
	   <%
	  			}
	  	%>
	  			<br/>
	  	<%
	  		}
	   %>
  	 
  </body>
</html>
