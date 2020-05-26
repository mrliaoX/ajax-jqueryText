package com.study.dao;

import java.sql.SQLException;

public interface UserDao {
	
	boolean checkUserName(String name) throws SQLException;

}
