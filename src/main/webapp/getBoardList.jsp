<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "com.spring.sample.board.impl.BoardDAO" %>
<%@ page import = "com.spring.sample.board.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<%
    	BoardVO vo = new BoardVO();
       	BoardDAO boardDAO = new BoardDAO();
       	List<BoardVO> boardList = boardDAO.getBoardList(vo);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>

<body>
<center>
	<h1>�۸��</h1>
	<h3>�׽�Ʈ�� ȯ���մϴ�...<a href="logout_proc.jsp">Log-out</a></h3>
	
		<!-- �˻����� -->
	
	<form action="getBoardList.jsp" method="post">	
		<table border="1" cellpadding="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">����
						<option value="CONTENT">����
					</select>
					<input name="searchKeyword" type="text"/>
					<input type="submit" value="�˻�"/>
				</td>
			</tr>
		</table>
	</form>
	<!-- �˻����� -->
	
	

	<table border="1" cellpading="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">��ȣ</th>
			<th bgcolor="orange" width="200">����</th>
			<th bgcolor="orange" width="150">�ۼ���</th>
			<th bgcolor="orange" width="150">�����</th>
			<th bgcolor="orange" width="100">��ȸ��</th>
		</tr>
		
		<c:foreach items="${boardList}" var="board">
			<tr>
				<td align="left"><a href="getBoard.jsp?seq=${ board.seq }">${ board.title }</a></td>
				<td>${ board.writer }
				<td>${ board.regDate }
				<td>${ board.cnt }
			</tr>
		</c:foreach>>
			
		
	</table>
	<br>
	<a href="insertBoard.jsp">���� ���</a>
</center>
</body>
</html>