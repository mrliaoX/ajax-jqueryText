package com.study.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.study.dao.UserDao;
import com.study.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean checkUserName(String name) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select count(*) from user where uname = ?";
		
		Long result = (Long) runner.query(sql, new ScalarHandler(), name);
		
		System.out.println(result);
		return result > 0 ;//因为返回的是一个boolent类型而result是long类型，long>0的结果是一个boolent类型
	}
	

}
