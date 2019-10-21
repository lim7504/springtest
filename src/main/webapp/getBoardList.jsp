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
<title>글 목록</title>
</head>

<body>
<center>
	<h1>글목록</h1>
	<h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3>
	
		<!-- 검색시작 -->
	
	<form action="getBoardList.jsp" method="post">	
		<table border="1" cellpadding="0" width="700">
			<tr>
				<td align="right">
					<select name="searchCondition">
						<option value="TITLE">제목
						<option value="CONTENT">내용
					</select>
					<input name="searchKeyword" type="text"/>
					<input type="submit" value="검색"/>
				</td>
			</tr>
		</table>
	</form>
	<!-- 검색종료 -->
	
	

	<table border="1" cellpading="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">작성자</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
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
	<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>