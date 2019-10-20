<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "com.spring.sample.board.impl.BoardDAO" %>
<%@ page import = "com.spring.sample.board.BoardVO" %>
<%@ page import = "java.util.List" %>
    
<%
    	BoardVO vo = new BoardVO();
    	BoardDAO boardDAO = new BoardDAO();
    	List<BoardVO> boardList = boardDAO.getBoardList(vo);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>
<center>
	


</center>
</body>
</html>