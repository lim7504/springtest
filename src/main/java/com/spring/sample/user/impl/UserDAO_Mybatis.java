package com.spring.sample.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.sample.board.BoardVO;
import com.spring.sample.user.UserVO;

@Repository("UserDAOMybatis")
public class UserDAO_Mybatis{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis로 getUser() 기능 처리");
		return (UserVO) mybatis.selectOne("UserDAO.getUser",vo);
	}
}
