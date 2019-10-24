package com.spring.sample.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.sample.user.UserVO;

@Repository("UserDAO")
public class UserDAO{
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
//	private Connection conn = null;
//	private PreparedStatement stmt = null;
//	private ResultSet rs = null;
	
	private final String USER_GET = "select * from USERS where id=? and password=?";
	
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		Object[] args = {vo.getId() ,vo.getPassword()};	
		return jdbctemplate.queryForObject(USER_GET, args, new UserRowMapper());
		
		
//		UserVO user = null;
//		try {
//			System.out.println("===> JDBC로 getUser() 기능 처리");
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(USER_GET);
//			stmt.setString(1, vo.getId());
//			stmt.setString(2, vo.getPassword());
//			rs = stmt.executeQuery();
//			if(rs.next())
//			{
//				user = new UserVO();
//				user.setId(rs.getString("ID"));
//				user.setPassword(rs.getString("PASSWORD"));
//				user.setName(rs.getString("NAME"));
//				user.setRole(rs.getString("ROLE"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return user;
	}
}
