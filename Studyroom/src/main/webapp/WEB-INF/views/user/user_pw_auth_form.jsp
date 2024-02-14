<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 입력 페이지</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>비밀번호</th>
			<td><input name="pwd" type="password"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="다음" onclick="send(this.form)">
				<input type="button" value="취소" onclick="location.href='user_view'">
			</td>
		</tr>
	</table>
</body>
</html>