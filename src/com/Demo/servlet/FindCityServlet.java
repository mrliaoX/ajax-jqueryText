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
			//1����ȡ������
//			request.setCharacterEncoding("utf-8");
			int pid = Integer.parseInt(request.getParameter("pid")) ;
			
			//����dao�ҵ����г���
			
			CityDao dao = new CityDaoImpl();
			System.out.println("�ߵ����ݿ��������");
			List<CityBean> list = dao.findCity(pid);
			
			//��������
			XStream xStream = new XStream();
			//��·�����ñ���
			xStream.alias("city", CityBean.class);
			//ת����һ��xml����
			System.out.println("�ߵ�xmlת������");
			String xml = xStream.toXML(list);
			
			//���ͻ���һ����Ӧ
//			response.setContentType("text/xml;charset=utf-8");
			System.out.println("��xmlд��ȥ����");
			response.getWriter().write(xml);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
