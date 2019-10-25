package com.spring.sample.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.sample.board.BoardVO;

@Repository("BoardDAOMybatis")
public class BoardDAO_Mybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis�� insertBoard()���ó��");
		mybatis.insert("BoardDAO.insertBoard",vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis�� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis�� deleteBoard() ��� ó��");
		mybatis.delete("BoardDAO.deleteBoard",vo);		
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis�� getBoard() ��� ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Mybatis�� getBoardList() ��� ó��");
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
}
