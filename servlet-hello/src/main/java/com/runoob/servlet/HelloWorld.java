package com.runoob.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet简单实例: HelloWorld
 * 
 * @author 	Lian
 * @date	2016年4月21日
 * @since	1.0
 */
@WebServlet("/hello")
public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String message;

	/**
	 * init HelloWorld Servlet
	 * this method is created for the first time invoked and only once
	 * 
	 * @throws ServletException
	 */
	@Override
	public void init() throws ServletException {
		message = "Hello World";
	}

	/**
	 * handle http get request
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set response content type
		response.setContentType("text/html");

		// the real handle logic
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	@Override
	public void destroy() {
		// do nothing
	}

}
