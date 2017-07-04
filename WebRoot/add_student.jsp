<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>add_student.html</title>
	
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
  </head>
  
  <body>
     <div class="container" style="width:40%">
     	<h2>添加学生信息</h2>
	  	<form action="${pageContext.request.contextPath}/student?method=add" method=post >
		  <div class="form-group">
		    <label for="name">姓名</label>
		    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
		  </div>
		  <div class="form-group">
		    <label for="age">年龄</label>
		    <input type="text" class="form-control" id="age" name="age" placeholder="Age">
		  </div>
		   <div class="form-group">
		    <label for="gender">性别</label>
		    <input type="text" class="form-control" id="gender" name="gender" placeholder="Gender">
		  </div>
		  <button type="submit" class="btn btn-default">添加学生</button>
		</form>
     </div>
  </body>
</html>
