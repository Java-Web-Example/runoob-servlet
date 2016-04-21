package com.runoob.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年4月21日
 * @since	1.0	
 */
@WebServlet("/CheckBox")
public class CheckBox extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 处理 GET 方法请求的方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "读取复选框数据";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		StringBuffer buff = new StringBuffer();
		buff.append(docType);
		buff.append("<html>\n");
		buff.append("<head><title>");
		buff.append(title);
		buff.append("</title></head>\n");
		buff.append("<body bgcolor=\"#f0f0f0\">\n");
		buff.append("<h1 align=\"center\">");
		buff.append(title);
		buff.append("</h1>\n");
		buff.append("<ul>\n");
		buff.append("  <li><b>数学标识：</b>: ");
		buff.append(request.getParameter("maths"));
		buff.append("\n");
		buff.append("  <li><b>物理标识：</b>: ");
		buff.append(request.getParameter("physics"));
		buff.append("\n");
		buff.append("  <li><b>化学标识：</b>: ");
		buff.append(request.getParameter("chemistry"));
		buff.append("\n");
		buff.append("</ul>\n");
		buff.append("</body></html>");
		out.println(buff.toString());
	}

	// 处理 POST 方法请求的方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
