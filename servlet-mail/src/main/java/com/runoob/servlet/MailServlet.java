package com.runoob.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用Servlet简单发送邮件
 * failed
 * 
 * @author 	Lian
 * @date	2016年5月3日
 * @since	1.0	
 */
@WebServlet("/mail")
public class MailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 收件人的电子邮件ID
		String to = "738978190@qq.com";

		// 发件人的电子邮件ID
		String from = "lianxinzhong@126.com";

		// 假设是从本地主机发送电子邮件
		String host = "localhost";

		// 获取系统的属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.user", "738978190@qq.com");
		properties.setProperty("mail.password", "lian199188");

		// 获取默认的Session对象
		Session session = Session.getDefaultInstance(properties);

		// 设置响应内容类型
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// 创建一个默认的MimeMessage对象
			MimeMessage message = new MimeMessage(session);
			// 设置From: header field of the header
			message.setFrom(new InternetAddress(from));
			// 设置To: header field of header
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// 设置Subject: header field
			message.setSubject("This is the Subject Line!");
			// 设置实际消息
			message.setText("This is actual message");

			// 发送消息
			Transport transport = session.getTransport();
			transport.connect("smtp.qq.com", "738978190@qq.com", "Lian199188");
			Transport.send(message);

			String title = "发送电子邮件";
			String res = "成功发送消息...";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
					+ "<h1 align=\"center\">" + title + "</h1>\n" + "<p align=\"center\">" + res + "</p>\n" + "</body></html>");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
