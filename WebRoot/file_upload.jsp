<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'file_upload.jsp' starting page</title>
  </head>
  
  <body>
<form action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data" method="post" >
	<input type="text" name="name"/><br/>
	<input type="file" name="fileName"/><br/>
	<input type="submit" value="提交"/>
</form>
  </body>
</html>
