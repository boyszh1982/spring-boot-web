package com.nameless.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nameless.dao.IDBTest;

@Repository("DBTestImpl")
public class DBTestImpl implements IDBTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String hello(String msg) {
		String sql = "select '"+msg+"' as msg from dual";
		Map<String,Object> map = jdbcTemplate.queryForMap(sql);
		return String.valueOf(map.get("msg") );
	}

}
