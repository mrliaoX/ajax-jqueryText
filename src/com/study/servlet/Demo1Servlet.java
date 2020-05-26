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
		System.out.println("走到这了吗");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		System.out.println("走到这2了吗");
		System.out.println(name+"   "+password);
//	    System.out.println("走到这3了吗");
	    response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("给你一个响应");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("现在来了一个post请求，将要去走get的代码了。");
		doGet(request, response);
	}

}
