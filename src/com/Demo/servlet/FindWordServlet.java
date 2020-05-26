package com.Demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Demo.dao.WordsDao;
import com.Demo.daoImpl.WordsDaoImpl;
import com.Demo.domain.WordsBean;


@WebServlet("/FindWordServlet")
public class FindWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String words = request.getParameter("wrod");
			
			WordsDao wd = new WordsDaoImpl();
			List<WordsBean> list = wd.findWord(words);
			
			/*for (WordsBean wordsBean : list) {
				
			}*/
			request.setAttribute("list", list);
			response.setContentType("text/html;charset=utf-8");
			//将数据转发到list
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
