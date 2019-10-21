<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.spring.sample.board.impl.BoardDAO" %>
<%@ page import="com.spring.sample.board.BoardVO" %>


<%
	String seq = request.getParameter("seq");

	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deletedBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>