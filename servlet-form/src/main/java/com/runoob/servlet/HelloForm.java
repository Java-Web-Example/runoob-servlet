package com.runoob.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Use servlet to handle form data
 * 
 * @author 	Lian
 * @date	2016年4月21日
 * @since	1.0	
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {

	private static final long serialVersionUID = 6920011426103058245L;

	/**
	 * the handle logic
	 * @url	http://localhost:8080/servlet-form/HelloForm?first_name=ZARA&last_name=ALI
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set response content type
		response.setContentType("text/html;charset=UTF-8");

		// get response output object
		PrintWriter out = response.getWriter();
		String title = "使用 GET 方法读取表单数据";
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n");
		buffer.append("<html>\n");
		buffer.append("<head><title>");
		buffer.append(title);
		buffer.append("</title></head>\n");
		buffer.append("<body bgcolor=\"#f0f0f0\">\n");
		buffer.append("<h1 align=\"center\">");
		buffer.append(title);
		buffer.append("</h1>\n");
		buffer.append("<ul>\n");
		buffer.append("  <li><b>名字</b>：");
		buffer.append(request.getParameter("first_name"));
		buffer.append("\n");
		buffer.append("  <li><b>姓氏</b>：");
		buffer.append(request.getParameter("last_name"));
		buffer.append("\n");
		buffer.append("</ul>\n");
		buffer.append("</body></html>");
		out.println(buffer.toString());
	}

	/**
	 * forward to doGet() method
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
