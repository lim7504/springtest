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
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ��</title>
</head>
<body>
<center>
	<h1>�� ��</h1>
	<a herf="logout_proc.jsp">Log-out</a>
	<hr>
	<form action="updateBoard_proc.jsp" method="post">
	<input name="seq" type="hidden" value="${ board.seq }"/>
	
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">����</td>
			<td align="left"><input name="title" type="text" value="${ board.title }"/></td>
		</tr>
		<tr>	
			<td bgcolor="orange">�ۼ���</td>
			<td align="left">${ board.writer }</td> 
		</tr>
		<tr>
			<td bgcolor="orange">����</td>
			<td align="left"><textarea rows="10" cols="40" name="content">${ board.content }</textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange">�����</td>
			<td align="left">${ board.regDate }</td>
		</tr>
		<tr>
			<td bgcolor="orange">��ȸ��</td>
			<td align="left">${ board.cnt }
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="�� ����"/></td>
		</tr>
	</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard_proc.jsp?seq=${ board.seq }">�ۻ���</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.jsp">�۸��</a>
</center>
</body>
</html>