<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'student_list.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script src="lib/jquery/jquery-1.11.1.js" type="text/javascript"
	charset="utf-8"></script>
<script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	function delStudent(id) {
		var isDel = confirm("您确认要删除吗？");
		if (isDel) {
			//要删除
			location.href = "${pageContext.request.contextPath}/student?method=delete&id="
					+ id;
		}
	}
	
	$(function(){
		$("#gender option[value='${searchCondition.gender}']").prop("selected", true);
	});
</script>
</head>
<body>
	<div class="container" style="width:70%">
		<h2 align="center">学生信息管理系统</h2>
	<div>
		<form action="${pageContext.request.contextPath}/student?method=searchByCondition" method="post">
			姓名:<input type="text" name="name" value="${searchCondition.name}"/>
			年龄:<input type="text" name="age" value="${searchCondition.age}"/>
			性别:<select id="gender" name="gender">
					<option value="">不限</option>
					<option value="男">男</option>
					<option value="女">女</option>
			    </select>&nbsp;&nbsp;&nbsp;
			<button class="btn btn-primary">搜索</button>
		</form>
	</div>
		<table class="table table-bordered table-hover table-striped">
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="student">
				<tr>
					<td>${student.getId()}</td>
					<td>${student.getName()}</td>
					<td>${student.getAge()}</td>
					<td>${student.getGender()}</td>
					<td><a href="javascript:void(0);"
						onclick="delStudent('${student.getId()}')">删除</a>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/student?method=toUpdate&id=${student.getId()}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/add_student.jsp">添加学生</a>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/student?method=findAll">查询所有</a>
	</div>
</body>
</html>
