package com.Demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.Demo.domain.WordsBean;

public interface WordsDao {
	
	List<WordsBean> findWord(String words) throws SQLException;

}
