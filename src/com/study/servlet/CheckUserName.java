package com.study.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.UserDao;
import com.study.daoImpl.UserDaoImpl;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/CheckUserName")
public class CheckUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			String name = request.getParameter("name");
			System.err.println("name="+name);
			UserDao dao = new UserDaoImpl();
			boolean isExist = dao.checkUserName(name);
			
			if (isExist) {
				response.getWriter().println(1);
			}else {
				response.getWriter().println(2);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
