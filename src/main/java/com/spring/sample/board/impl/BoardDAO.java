package com.spring.sample.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.sample.board.BoardVO;
import com.spring.sample.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	
	private final String BOARD_INSERT = "insert into BOARD(seq,title,writer,content) values(1,?,?,?)";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard()기능처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
}
