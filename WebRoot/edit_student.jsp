<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  <%
  		Student student = (Student)request.getAttribute("student");
   %>
  <form action="<%=request.getContextPath()%>/updateStudent.do" method="post">
  		<input type="hidden" name="id" value="<%=student.getId()%>"/>
  		姓名：<input type="text" name="name" value="<%=student.getName()%>"/><br/>
  		年龄：<input type="text" name="age" value="<%=student.getAge()%>"/><br/>
  		性别：<input type="text" name="gender" value="<%=student.getGender()%>"/><br/>
  		<p><button type="submit">确认修改</button></p>
  	</form>
  </body>
</html>
