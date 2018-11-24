package com.dream.repository;

import com.dream.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserTemplateRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	String sql = "insert into user (name,age) values(?,?)";
	
	public void addUser(User user){
		jdbcTemplate.update(sql, user.getName(),user.getAge());
	}
}
