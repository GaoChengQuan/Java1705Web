<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'PageContext.jsp' starting page</title>
    
  </head>
  
  <body>
	<%-- <%
		response.getWriter().write("是不是相等：" + (out == pageContext.getOut()) + "<br/>");
		response.getWriter().write("是不是相等：" + (session == pageContext.getSession()));
	 %> --%>
	 <br/>
	 <%
	 	pageContext.setAttribute("name1", "page scope zhangsan");//默认情况下，保存到page域中
	 	pageContext.setAttribute("name2", "request scope zhangsan", PageContext.REQUEST_SCOPE);//指定保存到request域
	 	pageContext.setAttribute("name3", "session scope zhangsan", PageContext.SESSION_SCOPE);//指定保存到session域
	 	pageContext.setAttribute("name4", "application scope zhangsan", PageContext.APPLICATION_SCOPE);//指定保存到context域
	  %>
	  <!-- 原则：在哪个域中保存数据，就从哪个域中取数据 -->
	 <%--  <%=pageContext.getAttribute("name") %><br/><!--Returns the object associated with the name in the page scope or null if not found.-->
	  <%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %><br/>
	  <%=pageContext.getAttribute("name", PageContext.SESSION_SCOPE) %><br/>
	  <%=pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE) %><br/> --%>
	  
	  <%=pageContext.findAttribute("name3") %>
	  
	 <%--  <jsp:forward page="/PageContext2.jsp" />  --%>
  </body>
</html>
