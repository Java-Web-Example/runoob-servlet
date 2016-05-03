package com.runoob.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Http状态码实例
 * 该例子把 407 错误代码发送到客户端浏览器，浏览器会显示 "Need authentication!!!" 消息。
 * 
 * @author 	Lian
 * @date	2016年5月3日
 * @since	1.0	
 */
@WebServlet("/showError.do")
public class ShowError extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(407, "Need authentication!!!");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
