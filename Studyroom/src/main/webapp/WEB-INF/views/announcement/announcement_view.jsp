<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>스터디룸 공지사항 상세보기</caption>
		<tr>
			<th>제목</th>
			<td>${dto.title ***REMOVED***</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>관리자</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${dto.register_date ***REMOVED***</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content ***REMOVED***</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="뒤로가기" onclick="location.href='announcement_list'">
			</td>
		</tr>
	</table>
</body>
</html>