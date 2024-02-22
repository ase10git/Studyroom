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
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/login_form.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script src="resources/js/HttpRequest.js"></script>
	
	<script type="text/javascript">
		// 정규 표현식
		const regex_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3***REMOVED***$/;
		const regex_password = /^(?=(.*[a-zA-Z].*){2,***REMOVED***)(?=.*\d.*)(?=.*\W.*)[a-zA-Z0-9\S]{8,15***REMOVED***$/;
	
		window.onload = function() {
			let emailHelp = document.getElementById("emailHelp");
			let pwdHelp = document.getElementById("pwdHelp");
	***REMOVED***
		

		function send(f) {
			var email = f.email.value.trim();
			var pwd = f.pwd.value.trim();
			
			if(email == '') {
				emailHelp.innerHTML = "이메일을 입력해주세요.";
				pwdHelp.innerHTML = "";
				return;
		***REMOVED***
	
			if(!regex_email.test(email)){
				emailHelp.innerHTML = "이메일 형식이 맞지 않습니다.";
				pwdHelp.innerHTML = "";

				return;
		***REMOVED***
			
			if(pwd == '') {
				emailHelp.innerHTML = "";
				pwdHelp.innerHTML = "비밀번호를 입력해주세요.";
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
<<<<<<< Updated upstream
					alert("이메일이 존재하지 않습니다.");				
			***REMOVED*** else if(json[0].param == 'no_pwd') {
					alert("비밀번호를 다시 입력해 주세요.")
=======
					emailHelp.innerHTML = "이메일이 존재하지 않습니다.";
			***REMOVED*** else if(json[0].param == 'no_pwd') {
					pwdHelp.innerHTML = "비밀번호를 다시 입력해 주세요.";
>>>>>>> Stashed changes
			***REMOVED*** else {
					alert("로그인을 성공했습니다!");

					location.href='announcement_list';

			***REMOVED***
		***REMOVED***
	***REMOVED***
	</script>

</head>
<body>
	
	<section class="sec login">
		<div class="container">
		  <div class="row gy-4 justify-content-center">
			<div class="col box col-6">
				<div class="title-box">
					<h1 class="title text-center">Studyroom</h1>
				</div>

				<form class="login-form">
					<div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">이메일</label>
					    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
					    <div id="emailHelp" class="form-text text-danger"></div>
					</div>
					<div class="mb-3">
					    <label for="pwd" class="form-label">비밀번호</label>
					    <input type="password" class="form-control" id="pwd" name="pwd">
					    <div id="pwdHelp" class="form-text text-danger"></div>
					</div>
					<div class="d-grid gap-2">
						<input type="button" class="btn btn-primary" value="로그인" onclick="send(this.form)">
						<input type="button" class="btn btn-info" value="회원가입" onclick="location.href='register'">
					</div>
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