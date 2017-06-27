package com.situ.day34;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletConfig().getServletContext();
		ServletContext servletContext = getServletContext();
		String size = servletContext.getInitParameter("size");
		System.out.println(size);
		
		//servletContext.getRealPath(path);返回资源文件的绝对路径
		//获取路径 a.txt  b.txt  c.txt   d.txt
		//1. a.txt
		String aPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");
		System.out.println("aPath: " + aPath);
		//2. b.txt  
		// Servlet是运行在服务器端的代码，"/"代表的是部署到tomcat后Java1705Web这个应用根目录
		String bPath = servletContext.getRealPath("/b.txt");
		System.out.println("bPath: " + bPath);
		//3. c.txt
		String cPath = servletContext.getRealPath("/WEB-INF/c.txt");
		System.out.println("cPath: " + cPath);
		//4. d.txt 没有部署到tomcat服务器，所以没法获取路径。
		
		//servletContext.getResourceAsStream(path);返回资源文件的输入流 InputStream
		InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		String url = properties.getProperty("url");
		System.out.println(url);
	}
}
