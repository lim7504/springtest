//package com.spring.sample.board.impl;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.sql.Connection;
//
//import org.springframework.stereotype.Repository;
//
//import com.spring.sample.board.BoardVO;
//import com.spring.sample.common.JDBCUtil;
//
//@Repository("BoardDAO_JDBCUtil")
//public class BoardDAO_JdbcUtil {
//
//	private Connection conn = null;
//	private PreparedStatement stmt = null;
//	private ResultSet rs = null;
//	
//	private final String BOARD_INSERT = "insert into BOARD(seq,title,writer,content) values(1,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set title=?,"
//									  + "content=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD where seq=?";
//	private final String BOARD_GET = "select * from BOARD where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";
//	
//	
//	public void insertBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� insertBoard()���ó��");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_INSERT);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getWriter());
//			stmt.setString(3, vo.getContent());
//			stmt.executeUpdate();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
//	}
//	
//	public void updateBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� updateBoard() ��� ó��");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_UPDATE);
//			stmt.setString(1,vo.getTitle());
//			stmt.setString(2,vo.getContent());
//			stmt.setInt(3,vo.getSeq());
//			stmt.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt,conn);
//		}	
//	}
//	
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� deleteBoard() ��� ó��");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_DELETE);
//			stmt.setInt(1, vo.getSeq());
//			stmt.executeUpdate();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
//		
//	}
//	
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> JDBC�� getBoard() ��� ó��");
//		BoardVO board = null;
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_GET);
//			stmt.setInt(1, vo.getSeq());
//			rs = stmt.executeQuery();
//			if(rs.next())
//			{
//				board = new BoardVO();
//				board.setSeq(rs.getInt("SEQ"));
//				board.setTitle(rs.getString("TITLE"));
//				board.setWriter(rs.getString("WRITER"));
//				board.setContent(rs.getString("CONTENT"));
//				board.setRegDate(rs.getDate("REGDATE"));
//				board.setCnt(rs.getInt("CNT"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(stmt, conn);
//		}
//		return board;
//		
//	}
//	
//	
//	public List<BoardVO> getBoardList(BoardVO vo){
//		System.out.println("===> JDBC�� getBoardList() ��� ó��");
//		List<BoardVO> boardList = new ArrayList<BoardVO>();
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next())
//			{
//				BoardVO board = new BoardVO();
//				board.setSeq(rs.getInt("SEQ"));
//				board.setTitle(rs.getString("TITLE"));
//				board.setWriter(rs.getString("WRITER"));
//				board.setContent(rs.getString("CONTENT"));
//				board.setRegDate(rs.getDate("REGDATE"));
//				board.setCnt(rs.getInt("CNT"));
//				boardList.add(board);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(stmt, conn);
//		}
//		return boardList;
//	}
//}