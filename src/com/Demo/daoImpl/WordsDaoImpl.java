package com.Demo.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Demo.dao.WordsDao;
import com.Demo.domain.WordsBean;
import com.study.util.JDBCUtil;

public class WordsDaoImpl implements WordsDao {

	@Override
	public List<WordsBean> findWord(String words) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from words where words like ? limit ?";
		return runner.query(sql,new BeanListHandler<WordsBean>(WordsBean.class),words+"%",5);
		 
	}

}
