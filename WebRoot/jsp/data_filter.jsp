<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'data_filter.jsp' starting page</title>
	<script src="${pageContext.request.contextPath}/lib/ckeditor/ckeditor.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/ckeditor/samples/sample.css">
  </head>
  
  <body>
  	${content}
  	<form action="${pageContext.request.contextPath}/dataFilter" method="post">
  		<textarea class="ckeditor" rows="10" cols="40" name="content"></textarea><br/>
  		<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
