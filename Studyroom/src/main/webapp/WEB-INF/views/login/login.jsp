<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		var email = f.email.value.trim();
		var pwd = f.pwd.value.trim();
		
		if(email == '') {
			alert("이메일을 입력해주세요.");
			return;
		}
		
		if(pwd == '') {
			alert("비밀번호를 입력해주세요.");
			return;
		}
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table border="1">
			<caption>::: 로그인 :::</caption>
			<tr>
				<th>이메일</th>
				<td><input id="email" name="email" placeholder="이메일을 입력해주세요." autofocus="autofocus">
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input id="pwd" name="pwd" type="password" placeholder="비밀번호를 입력해주세요.">
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input id="" name="" type="button" value="로그인" onclick="send(this.form)">
					<input id="" name="" type="button" value="회원가입" onclick="location.href='register'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>