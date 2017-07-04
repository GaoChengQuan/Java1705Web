<%@ page language="java" import="java.util.*" pageEncoding="utf-8" buffer="8kb"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'out.jsp' starting page</title>
  </head>
  <body>
    <%
    	out.write("abc");//JspWriter是有缓冲区
    	response.getWriter().write("123");//PrinterWriter不带缓存区的
     %>
  </body>
</html>
