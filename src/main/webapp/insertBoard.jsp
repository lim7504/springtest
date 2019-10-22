<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>새글 등록</title>
</head>
<body>
<center>
	<h1>글 등록</h1>
	<a href="logout.do">Log-out</a>
	<hr>
	<form action="insertBoard.do" method="post">
		<tr>
			<td bgcolor="orange" width="70">제목</td><td align="left"><input type="text" name="title"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">작성자</td><td align="left"><input type="text" name="writer" size="10"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">내용</td><td align="left"><textarea name="content" rows="10" cols="40"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="새글 등록"/></td>
		</tr>
	</form>
<hr>
<a href="getBoardList.jsp">글 목록 가기</a>
</center>
</body>
</html>