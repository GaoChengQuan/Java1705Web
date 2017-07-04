<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'el.jsp' starting page</title>
  </head>
  
 <body>
 	<!-- 1、EL从域中取出数据(EL最重要的作用) -->
 	<%
 		/* 1）获得普通字符串 */
 		pageContext.setAttribute("name", "lisi");
 		request.setAttribute("name", "zhangsan");
 		
 		/* 2）获得Student对象的值 */
 		Student student = new Student("wangwu", 20, "男");
 		session.setAttribute("student", student);
 		
 		/* 3）获得List<Student>的值 */
 		Student student1 = new Student("小明", 22, "男");
 		Student student2 = new Student("小赵", 32, "女");
 		List<Student> list = new ArrayList<Student>();
 		list.add(student1);
 		list.add(student2);
 		application.setAttribute("list", list);
 	 %>
 	<!-- 1）获得普通字符串 -->
 	<!-- 使用jsp表达式获取域中值 -->
 	<%=pageContext.getAttribute("name") %><br/>
 	<%=request.getAttribute("name") %><br/>
 	<!-- EL表达式获取域中值 -->
 	${pageScope.name}<br/>
 	${requestScope.name}<br/>
 	
 	<hr/>
	<!-- 2）获得Student对象的值 -->
	<!-- 使用jsp表达式获取域中值 -->
	<%
		Student stu = (Student)session.getAttribute("student");
	%>
	<%=stu.getName()%><br>
	<%=stu.getAge()%><br>
	<!-- EL表达式获取域中值 -->
	${sessionScope.student.name} -- ${sessionScope.student.age}
	
	<hr/>
	<!-- 3）获得List<Student>的值 -->
 	<!-- 使用jsp表达式获取域中值 -->
 	<%
 		List<Student> stuList = (List<Student>)pageContext.findAttribute("list");
 	 %>
 	<%=stuList.get(1).getName() %><br/>
 	<!-- EL表达式获取域中值 -->
 	${applicationScope.list[1].name}<br/>
 	
 	<hr/>
 	<!-- 使用el表达式全域查找 -->
 	${name}<br/>
 	${student.name} -- ${student.age}<br/>
 	${list[1].name}<br/>
 	
 	
 	<hr/>
 	<hr/>
	<!-- 2、EL执行表达式 -->
	<!-- 算数表达式 
		+ - * /
	-->
	<%=10+5 %><br/>
	${10+5}<br/>
	${10*5}<br/>
	
	<!-- 比较运算 
		>  <  >=  <=  !=
	-->
	${10>5}<br/>
	${10!=10}<br/>
	
	<!-- 逻辑运算 
		&& || !
	-->
	${true&&false}<br/>
	${!false}<br/>
	
	<!-- 判空
	 null 或空字符串：empty
	 -->
	 <%
	 	String address = "";
	 	pageContext.setAttribute("address", address);
	  %>
	  判断null:${address==null}<br/>
	  判断空字符串:${address==""}<br/>
	  判空：${address==null || address=="" }<br/>
	  ${empty address }
 </body>
</html>
