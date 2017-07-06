<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'json1.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
   	$(function(){
    	var student = {
		    "id" : 12,
		    "name" : "gao",
		    "age"  :   30,
		    "gender" : "男"
		};
		alert(student.name);
		
		var list = [ 
		   {
				"id" : 12,
				"name" : "gao",
				"age" : 30,
				"gender" : "男"
			}, 
			{
				"id" : 13,
				"name" : "li",
				"age" : 30,
				"gender" : "男"
			}, 
			{
				"id" : 14,
				"name" : "wang",
				"age" : 20,
				"gender" : "男"
			}, 
	   ];
	   alert(list[1].name);

	    
	   var student2 = {
		    "id" : 12,
		    "name" : "gao",
		    "age"  :   30,
		    "gender" : "男",
		    "interest" : ["篮球", "爬山", "旅游"]
		};
		alert(student2.interest[2]);
		
		
		var student3 = {
		    "id" : 12,
		    "name" : "gao",
		    "age"  :   30,
		    "gender" : "男",
		    "interest" : [
		    		{"name":"篮球", "time":"2年"},
		    		{"name":"爬山", "time":"5年"}, 
		    		{"name":"旅游", "time":"3年"}
		     ]
		};
		alert(student3.interest[2].time);
	});
	 </script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
