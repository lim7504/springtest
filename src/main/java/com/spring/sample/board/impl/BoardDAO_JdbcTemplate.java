//package com.spring.sample.board.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.spring.sample.board.BoardVO;
//
//@Repository("BoardDAO")
//public class BoardDAO_JdbcTemplate {
//
//	private Connection conn = null;
//	private PreparedStatement stmt = null;
//	private ResultSet rs = null;
//	
//	private final String BOARD_INSERT = "insert into BOARD(seq,title,writer,content) values(?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set title=?,"
//									  + "content=? where seq=?";
//	private final String BOARD_DELETE = "delete BOARD where seq=?";
//	private final String BOARD_GET = "select * from BOARD where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	public void insertBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� insertBoard()���ó��");
//		jdbcTemplate.update(BOARD_INSERT,vo.getSeq(), vo.getTitle(),vo.getWriter(),vo.getContent());
//	}
//	
//	public void updateBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� updateBoard() ��� ó��");
//		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(), vo.getSeq());
//	}
//	
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� deleteBoard() ��� ó��");
//		jdbcTemplate.update(BOARD_DELETE,vo.getSeq());		
//	}
//	
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� getBoard() ��� ó��");
//		Object[] args = {vo.getSeq()};
//		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper_JdbcTemplate());
//	}
//	
//	
//	public List<BoardVO> getBoardList(BoardVO vo){
//		System.out.println("===> JDBC�� getBoardList() ��� ó��");
//		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper_JdbcTemplate());
//	}
//}
