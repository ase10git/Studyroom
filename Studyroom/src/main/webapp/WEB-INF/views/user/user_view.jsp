<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 페이지</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td>${dto.username}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${dto.email}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.tel}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정하기" onclick="location.href='user_pw_auth_form'">
			</td>
		</tr>
	</table>
</body>
</html>