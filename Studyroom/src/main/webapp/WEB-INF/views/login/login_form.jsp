<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/HttpRequest.js"></script>
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
		
		//이메일은 형식검사
		let regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
			
		if(!regex.test(email)){
			alert("이메일 형식이 맞지 않습니다.");
			return;
		}
		
		var url = "login";
		var param = "email="+email+"&pwd="+encodeURIComponent(pwd);
		
		sendRequest(url,param,myCheck,"POST");
	}
	
	function myCheck() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			var json = (new Function('return' + data))();
			
			if(json[0].param == 'no_email') {
				alert("이메일이 존재하지 않습니다.");				
			} else if(json[0].param == 'no_pwd') {
				alert("비밀번호를 다시 입력해 주세요.")
			} else {
				alert("로그인 성공");
				location.href='announcement_list';
			}
		}
	}
</script>
</head>
<body>
	<form action="">
		<table border="1" align="center">
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