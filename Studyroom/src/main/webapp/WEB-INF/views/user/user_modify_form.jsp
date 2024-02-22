<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사용자 정보 수정 페이지</title>
		<!-- bootstrap css -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
		crossorigin="anonymous"/>
		<link rel="stylesheet" href="resources/css/main.css">
		<link rel="stylesheet" href="resources/css/style_with_table.css">
		
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script>
	    if ("${authFail***REMOVED***") {
	        alert('비밀번호가 틀렸습니다.');
	    ***REMOVED***
	
		function send(f){
			if(!confirm("수정하시겠습니까?")){
				return;
		***REMOVED***
			
			let username = f.username.value.trim();
			let email = f.email.value.trim();
			let tel = f.tel.value.trim();
			let pwd = f.pwd.value.trim();
			let pwd_check = f.pwd_check.value.trim();
						
			if(username == ''){
				alert('이름을 입력해주세요')
				return;
		***REMOVED***
			
			if(email == ''){
				alert('이메일을 입력해주세요')
				return;
		***REMOVED***
			
			if(tel == ''){
				alert('전화번호를 입력해주세요')
				return;
		***REMOVED***
			
			if(pwd === ''){
				alert('비밀번호를 입력해주세요')
				return;
		***REMOVED***
			
			if(pwd_check === '' || pwd !== pwd_check) {
				alert('비밀번호가 일치하지 않습니다')
				return;
		***REMOVED***
			
			//이메일은 형식검사
			let regex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3***REMOVED***$/i
			if(!regex.test(email)){
				alert('형식에 맞게 작성해주세요')
				return;
		***REMOVED***

			f.submit();
	***REMOVED***
	</script>
</head>
<body>
	
	<%@ include file="../include/menu.jsp" %>

	<section class="sec user-modify">
		<div class="container">
		 <h1 class="title text-center">사용자 정보 수정</h1>
		  <div class="row gy-4">
			<div class="box col-12">
				<form action="user_modify" name="f" method="post">
					<input type="hidden" name="id" value="${dto.id***REMOVED***">
					<table>
						<tr>
							<th>이름</th>
							<td><input name="username" class="form-control" value="${dto.username***REMOVED***" placeholder="이름 입력"></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input name="email" class="form-control" value="${dto.email***REMOVED***" readonly></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input name="tel" class="form-control" value="${dto.tel***REMOVED***" placeholder="전화번호 입력"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input name="pwd" class="form-control" type="password" placeholder="비밀번호 입력"></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input name="pwd_check" class="form-control" type="password" placeholder="한번 더 입력"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" class="btn btn-primary" value="수정" onclick="send(this.form);">
								<input type="button" class="btn btn-dark" value="취소" onclick="location.href='user_view?id=${dto.id***REMOVED***'">
							</td>
						</tr>
					</table>
				</form>
			</div>
		  </div>
		</div>
	  </section>

	<%@ include file="../include/footer.jsp" %>

		<!-- bootstrap script -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
		crossorigin="anonymous"></script>
</body>
</html>