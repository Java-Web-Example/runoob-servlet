package com.runoob.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Get parameter values
 * 
 * @author 	Lian
 * @date	2016年4月21日
 * @since	1.0	
 */
@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "读取所有的表单数据";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		StringBuffer buff = new StringBuffer();
		buff.append(docType);
		buff.append("<html>\n");
		buff.append("<head><meta charset=\"utf-8\"><title>");
		buff.append(title);
		buff.append("</title></head>\n");
		buff.append("<body bgcolor=\"#f0f0f0\">\n");
		buff.append("<h1 align=\"center\">");
		buff.append(title);
		buff.append("</h1>\n");
		buff.append("<table width=\"100%\" border=\"1\" align=\"center\">\n");
		buff.append("<tr bgcolor=\"#949494\">\n");
		buff.append("<th>参数名称</th><th>参数值</th>\n");
		buff.append("</tr>\n");

		Enumeration paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			buff.append("<tr><td>");
			buff.append(paramName);
			buff.append("</td>\n");
			String[] paramValues = request.getParameterValues(paramName);
			// 读取单个值的数据
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					buff.append("<td><i>没有值</i></td>");
				else {
					buff.append("<td>");
					buff.append(paramValue);
					buff.append("</td>");
				}
			} else {
				// 读取多个值的数据
				buff.append("<td><ul>");
				for (int i = 0; i < paramValues.length; i++) {
					buff.append("<li>");
					buff.append(paramValues[i]);
				}
				buff.append("</ul></td>");
			}
			buff.append("</tr>");
		}
		buff.append("\n</table>\n</body></html>");
		out.println(buff.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
