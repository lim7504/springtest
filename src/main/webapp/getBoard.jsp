<%@ page import="com.spring.sample.board.impl.BoardDAO" %>
<%@ page import="com.spring.sample.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String seq = request.getParameter("seq");
	System.out.println(seq);
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
	
	if(board == null)
		System.out.println("널.....");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
<center>
	<h1>글 상세</h1>
	<a herf="logout_proc.jsp">Log-out</a>
	<hr>
	<form action="updateBoard_proc.jsp" method="post">
	<input name="seq" type="hidden" value="<%= board.getSeq() %>"/>
	
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">제목</td>
			<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"/></td>
		</tr>
		<tr>	
			<td bgcolor="orange">작성자</td>
			<td align="left"><%= board.getWriter() %></td> 
		</tr>
		<tr>
			<td bgcolor="orange">내용</td>
			<td align="left"><textarea rows="10" cols="40" name="content"><%= board.getContent() %></textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange">등록일</td>
			<td align="left"><%= board.getRegDate() %></td>
		</tr>
		<tr>
			<td bgcolor="orange">조회수</td>
			<td align="left"><%= board.getCnt() %>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="글 수정"/></td>
		</tr>
	</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">글목록</a>
</center>
</body>
</html>