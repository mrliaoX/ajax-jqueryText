package com.Demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.Demo.domain.CityBean;

public interface CityDao {
	
	 List<CityBean>findCity(int pid) throws SQLException;

}
