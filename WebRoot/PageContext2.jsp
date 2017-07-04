<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'PageContext2.jsp' starting page</title>
    
  </head>
  
  <body>
<%=pageContext.getAttribute("name") %><br/>
<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %><br/>
<%=pageContext.getAttribute("name", PageContext.SESSION_SCOPE) %><br/>
<%=pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE) %><br/>
  </body>
</html>
