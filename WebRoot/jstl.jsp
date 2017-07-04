<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'jstl.jsp' starting page</title>
  </head>
  
  <body>
  	<%
  		request.setAttribute("age", 18);
  		request.setAttribute("gender", "女");
  		
  		Student student1 = new Student("小明", 22, "男");
 		Student student2 = new Student("小赵", 32, "女");
 		List<Student> list = new ArrayList<Student>();
 		list.add(student1);
 		list.add(student2);
 		application.setAttribute("list", list);
  	 %>
	 <!--  1、单条件判断 -->
	<c:if test="${age==18}">
		今年18岁
	</c:if>
	
	<c:if test="${gender=='男'}">
		男
	</c:if>
	<c:if test="${gender=='女'}">
		女 
	</c:if>
  	
  	<hr/>
  	
  	
  	 <%-- 2、多条件判断 --%>
  	<%
  		int score = 77;
  		pageContext.setAttribute("score", score);
  	 %>
  	<c:set var="score1" value="88"></c:set>
  	<c:choose>
  		<c:when test="${score1>=90 && score1<=100}">
  			优秀
  		</c:when>
  		<c:when test="${score1>=80 && score1<90}">
  			良好
  		</c:when>
  		<c:when test="${score1>=70 && score1<80}">
  			一般
  		</c:when>
  		<c:when test="${score1>=60 && score1<70}">
  			及格
  		</c:when>
  		<c:otherwise>
  			不及格
  		</c:otherwise>
  	</c:choose>
  	
  	
  	<hr/>
	 <!--  3、循环数据 -->
	 <!-- 
	 	for(int i=0;i<=5;i++) {
	 		syso(i);
	 	}
	  -->
	<c:forEach begin="0" end="5" var="i">
		${i}<br/>
	</c:forEach>
	<!-- 
		for(Student student:list){
			syso(student);
		}
	 -->
	<c:forEach items="${list}" var="student">
		${student.name}--${student.age}<br/>
	</c:forEach>
  	
  	
  	<!-- 
	遍历Map<String,String>的值
	    1. 遍历Map<String,Student>的值
	    1. 遍历Map<User,Map<String,Student>>的值
	entry.key-----User
	entry.value------List<String,Student> -->
	<%
		Map<String, Student> map = new HashMap<String, Student>();
		Student stu1 = new Student("小明", 22, "男");
		Student stu2 = new Student("小李", 32, "女");
		map.put("stu1", stu1);
		map.put("stu2", stu2);
		request.setAttribute("map", map);
	 %>
	<c:forEach items="${map}" var="entry">
		${entry.key}--${entry.value}<br/>
		${entry.key}--${entry.value.name}<br/>
	</c:forEach>
  	
  </body>
</html>
