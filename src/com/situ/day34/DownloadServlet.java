package com.situ.day34;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获得请求文件名  
		String fileName = req.getParameter("fileName");
		//获取目标文件的绝对路径  
		String filePath = getServletContext().getRealPath("/download/" + fileName);
		
		//设置文件MIME类型 
		resp.setContentType(getServletContext().getMimeType(fileName));
		//设置响应头Content-Disposition  告诉浏览器以附件的形式下载，而不是解析
		resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);  
		
		//读取文件
		InputStream inputStream = new FileInputStream(filePath);
		//获得输出流---通过response获得的输出流 用于向客户端写内容
		OutputStream outputStream = resp.getOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, length);
		}
		outputStream.close();
		inputStream.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
