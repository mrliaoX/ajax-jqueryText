package com.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo1Servlet
 */
@WebServlet("/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�ߵ�������");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		System.out.println("�ߵ���2����");
		System.out.println(name+"   "+password);
//	    System.out.println("�ߵ���3����");
	    response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("����һ����Ӧ");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��������һ��post���󣬽�Ҫȥ��get�Ĵ����ˡ�");
		doGet(request, response);
	}

}
