<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'josn2.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
 	function fn1() {
 	   /*  $.get(url, [data], [callback], [type]) */
 		$.get(
 			"${pageContext.request.contextPath}/json", //url
 			{"name":"lis", "age":20}, //date
 			function(data) {
 				//{\"name\":\"zhangsan\", \"age\":18}
 				alert(data.name + " " + data.age);
 			}, //callback
 			"json" //type
 		);
 	}
    </script>
  </head>
  
  <body>
    <body>
	<input type="button" value="get访问服务器端" onclick="fn1()"><span id="span1"></span><br/>
	<input type="button" value="post访问服务器端" onclick="fn2()"><span id="span2"></span><br/>
</body>
  </body>
</html>
