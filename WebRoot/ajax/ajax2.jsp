<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ajax.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript">
   	function fn1() {
   		//步骤：
		//1）创建Ajax引擎对象
		var xmlHttpRequest = new XMLHttpRequest();
		//2）为Ajax引擎对象绑定监听（监听服务器已将数据响应给引擎）
		xmlHttpRequest.onreadystatechange = function() {
			//5）接受响应数据
			if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
				var result = xmlHttpRequest.responseText;
				alert(result);
			}
		};
		//3）绑定提交地址
		xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/ajax2?name=zhangsan", true);
		//4）发送请求
		xmlHttpRequest.send();
   	}
   	
   	function fn2() {
   		//步骤：
		//1）创建Ajax引擎对象
		var xmlHttpRequest = new XMLHttpRequest();
		//2）为Ajax引擎对象绑定监听（监听服务器已将数据响应给引擎）
		xmlHttpRequest.onreadystatechange = function() {
			//5）接受响应数据
			if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
				var result = xmlHttpRequest.responseText;
				alert(result);
			}
		};
		//3）绑定提交地址
		xmlHttpRequest.open("POST", "${pageContext.request.contextPath}/ajax2", false);
		//4）发送请求
		xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
		xmlHttpRequest.send("name=wangwu");
   	}
  </script>
</head>

<body>
	<input type="button" value="get访问服务器端" onclick="fn1()"><span id="span1"></span><br/>
	<input type="button" value="post访问服务器端" onclick="fn2()"><span id="span2"></span><br/>
	<a href="${pageContext.request.contextPath}/ajax?name=zhangsan">超链接</a>
</body>
</html>
