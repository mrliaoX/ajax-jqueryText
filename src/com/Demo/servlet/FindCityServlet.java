package com.Demo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Demo.dao.CityDao;
import com.Demo.daoImpl.CityDaoImpl;
import com.Demo.domain.CityBean;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class FindCityServlet
 */
@WebServlet("/fs")
public class FindCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1、获取参数、
//			request.setCharacterEncoding("utf-8");
			int pid = Integer.parseInt(request.getParameter("pid")) ;
			
			//调用dao找到所有城市
			
			CityDao dao = new CityDaoImpl();
			System.out.println("走到数据库查找了吗");
			List<CityBean> list = dao.findCity(pid);
			
			//返回数据
			XStream xStream = new XStream();
			//给路径设置别名
			xStream.alias("city", CityBean.class);
			//转化成一个xml对象
			System.out.println("走到xml转换了吗");
			String xml = xStream.toXML(list);
			
			//给客户端一个响应
//			response.setContentType("text/xml;charset=utf-8");
			System.out.println("把xml写回去了吗");
			response.getWriter().write(xml);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
