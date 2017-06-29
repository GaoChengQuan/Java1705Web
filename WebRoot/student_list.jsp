<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'student_list.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css" />
    <script src="lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="lib/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
  </head>
  <body>
  	<%
  		List<Student> list= (List<Student>)request.getAttribute("list");
  	 %>
  	 <h2 align="center">学生信息管理系统</h2>
  	<table class="table table-bordered table-hover table-striped">
  		<tr>
  			<td>ID</td>
  			<td>姓名</td>
  			<td>年龄</td>
  			<td>性别</td>
  			<td>删除</td>
  			<td>修改</td>
  		</tr>
  		<%
  			for (Student student : list) {
  		%>
  			<tr>
	  			<td><%=student.getId() %></td>
	  			<td><%=student.getName() %></td>
	  			<td><%=student.getAge() %></td>
	  			<td><%=student.getGender() %></td>
	  			<td><a href="<%=request.getContextPath()%>/deleteStudent.do?id=<%=student.getId() %>">删除</a></td>
	  			<td><a href="<%=request.getContextPath()%>/toUpdateStudent.do?id=<%=student.getId() %>">修改</a></td>
  			</tr>
  		<%
  			}
  		 %>
  	</table>
  	<a class="btn btn-primary" href="<%=request.getContextPath()%>/html/add_student.html">添加学生</a>
  </body>
</html>
