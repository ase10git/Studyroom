<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		let email = f.email.value.trim();
		let pwd = f.pwd.value.trim();
		let username = f.username.value.trim();
		let tel = f.tel.value.trim();
		let role = f.role.value.trim();
		
		//유효성 검사
		if(email == ''){
			alert("이메일을 입력하세요.");
			return;
	***REMOVED***
		
		if(pwd == ''){
			alert("비밀번호를 입력하세요.");
			return;
	***REMOVED***
		
		if(username == ''){
			alert("이름을 입력하세요.");
			return;
	***REMOVED***
		
		if(tel == ''){
			alert("전화번호를 입력하세요.");
			return;
	***REMOVED***
		
// 		if(role == null){
// 			alert("유형을 선택해주세요.");
// 			return;
// 	***REMOVED*** 
	
		//이메일은 형식검사
		let regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3***REMOVED***$/i
	
		if(!regex.test(email)){
			alert('형식에 맞게 작성해주세요.');
			return;
	***REMOVED***
		
		f.submit();
***REMOVED***
</script>
</head>
<body>
	<form action="" method="post">
		<table border="1" >
			<caption>::: 회원가입 :::</caption>
			<tr>
				<th>이메일</th>
				<td>
		  			<input id="email" name="email" type="email" placeholder="example@abc.com" autofocus="autofocus" checked="checked" urequired>
		  			<input id="email_check" name="email_check" type="button" value="이메일 인증하기">
	  			</td>
  			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input id="pwd" name="pwd" type="password" placeholder="8~12자리 입력해 주세요.">
				</td>
			</tr>
			<tr>
				<th>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</th>
				<td>
					<input id="username" name="username" placeholder="이름을 입력해 주세요.">
				</td>
			</tr>	
			<tr>
				<th>전화번호</th>
				<td>
					<input id="tel" name="tel" placeholder="(ex:01012345678)">
				</td>
			</tr>
			<tr>
				<th>유&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형</th>
				<td style="font-family: Arial;font-size: 15px;color: #808080;">
					<input id="mentor" name="role" type="radio" value="멘토" checked="checked">멘토
					<input id="student" name="role" type="radio" value="학생">학생
				</td>
			</tr>	
			<tr>
				<td colspan="2">
					<input id="" name="" type="button" value="회원가입" onclick="send(this.form)">
					<input id="" name="" type="button" value="취소" onclick="location.href='login'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>