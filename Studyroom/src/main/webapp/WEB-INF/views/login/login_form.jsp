<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
    crossorigin="anonymous"/>

	<link rel="stylesheet" href="resources/css/login_form.css">
	<link rel="stylesheet" href="resources/css/main.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script src="resources/js/HttpRequest.js"></script>

	<script type="text/javascript">
		function send(f) {
			var email = f.email.value.trim();
			var pwd = f.pwd.value.trim();
			
			if(email == '') {
				alert("이메일을 입력해주세요.");
				return;
		***REMOVED***
			
			if(pwd == '') {
				alert("비밀번호를 입력해주세요.");
				return;
		***REMOVED***
			
			//이메일은 형식검사
			let regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3***REMOVED***$/i
				
			if(!regex.test(email)){
				alert("이메일 형식이 맞지 않습니다.");
				return;
		***REMOVED***
			
			var url = "login";
			var param = "email="+email+"&pwd="+encodeURIComponent(pwd);
			
			sendRequest(url,param,myCheck,"POST");
	***REMOVED***
		
		function myCheck() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = xhr.responseText;
				var json = (new Function('return' + data))();
				
				if(json[0].param == 'no_email') {
					alert("이메일이 존재하지 않습니다.");				
			***REMOVED*** else if(json[0].param == 'no_pwd') {
					alert("비밀번호를 다시 입력해 주세요.")
			***REMOVED*** else {
					alert("로그인 성공");

					location.href='announcement_list';

			***REMOVED***
		***REMOVED***
	***REMOVED***
	</script>

</head>
<body>
	
	<section class="sec login">
		<div class="container">
		  <div class="row gy-4">

			<div class="col">
				<div class="title-box"><h1 class="title">Studyroom</h1></div>

				<form class="login-form">
					<table id="login_tbl" name="login_tbl">
						<tr>
							<th>이메일</th>
							<td><input id="email" name="email" placeholder="이메일을 입력해주세요." autofocus="autofocus">
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input id="pwd" name="pwd" type="password" placeholder="비밀번호를 입력해주세요.">
						</tr>
						<tr>
							<td colspan="2">
								<input class="login-btn" type="button" value="로그인" onclick="send(this.form)">
								<input class="register-btn" type="button" value="회원가입" onclick="location.href='register'">
							</td>
						</tr>
					</table>
				</form>
			</div>

		  </div>
		</div>
	  </section>
	
	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>