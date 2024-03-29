<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
	  <link rel="stylesheet" href="resources/css/main.css">
	  <link rel="stylesheet" href="resources/css/register_form.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@400..900&family=DM+Serif+Display:ital@0;1&display=swap" rel="stylesheet">
    
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script src="resources/js/HttpRequest.js"></script>
	<script type="text/javascript">
		let u_emailCheck = false;
		
		// 정규 표현식
		const regex_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		const regex_password = /^(?=(.*[a-zA-Z].*){2,})(?=.*\d.*)(?=.*\W.*)[a-zA-Z0-9\S]{8,15}$/;
		
		window.onload = function() {
			let emailHelp = document.getElementById("emailHelp");
			let pwdHelp = document.getElementById("pwdHelp");
			let nameHelp = document.getElementById("nameHelp");
			let telHelp = document.getElementById("telHelp");
			let roleHelp = document.getElementById("roleHelp");
		}

		function check_email() {
			let email = document.getElementById("email").value;
			
			if(email == '') {
				emailHelp.innerHTML = "이메일을 입력해주세요.";
				return;
			}
			
			//이메일은 형식검사
			console.log(regex_email.test(email))
			if(!regex_email.test(email)){
				emailHelp.innerHTML = "이메일 형식이 맞지 않습니다.";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			//완전히 새로고침을 하면 텍스트필드에 적오놓은것이 날아가기 때문에
			//비동기 통신을 이용한다.
			let url = "check_email";
			let param = "email="+encodeURIComponent(email);
			
			sendRequest(url,param,resultFn,"POST");
		}
		
		function resultFn() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var data = xhr.responseText;
				var json = (new Function('return'+data))();
				
				if(json[0].res == 'yes') {
// 					alert("사용가능한 이메일 입니다.");
					emailHelp.innerHTML = "사용가능한 이메일 입니다.";
					u_emailCheck = true;
				} else {
// 					alert("이미 사용중인 이메일 입니다.");
					emailHelp.innerHTML = "이미 사용중인 이메일 입니다.";
					return;
				}
			}
		}
		
		function che() {
			u_emailCheck = false;
		}

		function send(f) {
			let email = f.email.value.trim();
			let pwd = f.pwd.value.trim();
			let username = f.username.value.trim();
			let tel = f.tel.value.trim();
			let role = f.role.value.trim();

			//유효성 검사
			if(email == ''){
				emailHelp.innerHTML = "이메일을 입력해주세요.";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			//이메일은 형식검사
			console.log(regex_email.test(email))
			if(!regex_email.test(email)){
				emailHelp.innerHTML = "이메일 형식이 맞지 않습니다.";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			if(pwd == ''){
				emailHelp.innerHTML = "";
				pwdHelp.innerHTML = "비밀번호를 입력해주세요.";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			if(!regex_password.test(pwd)){
				emailHelp.innerHTML = "";
				pwdHelp.innerHTML = "비밀번호는 영문자, 숫자, 특수문자 최소 1개 이상 포함해주세요";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			if(username == ''){
				emailHelp.innerHTML = "";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "이름을 입력해주세요.";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			if(tel == ''){
				emailHelp.innerHTML = "";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "전화번호를 입력해주세요.";
				return;
			}
			
			if(role == ''){
				emailHelp.innerHTML = "";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "유형을 선택해주세요.";
				return;
			} 
			
			if(!u_emailCheck){
				emailHelp.innerHTML = "중복된 이메일 입니다.";
				pwdHelp.innerHTML = "";
				nameHelp.innerHTML = "";
				telHelp.innerHTML = "";
				roleHelp.innerHTML = "";
				return;
			}
			
			f.submit();
		}
	</script>
</head>

<body>

   <section class="sec register">
      <div class="container">
        <div class="row gy-4 justify-content-center">
         <div class="col box col-6">
            <div class="title-box">
               <h1 class="title text-center">회원 가입</h1>
            </div>
            <!-- register_insert 전송 -->
            <form name="f" action="register_insert" method="post" class="login-form">
               <div class="mb-3">
                  <div class="d-flex justify-content-between">
                     <label for="email" class="form-label">이메일</label>
                     <input type="button" class="btn btn-primary btn-sm" value="이메일 중복체크" onclick="check_email()">
                  </div>
                  <input type="email" class="form-control" id="email" name="email" onchange="che()" placeholder="example@abc.com" aria-describedby="emailHelp">
                  <div id="emailHelp" class="form-text text-danger"></div>
               </div>
               <div class="mb-3">
                  <label for="pwd" class="form-label">비밀번호</label>
                  <input type="password" class="form-control" id="pwd" name="pwd" placeholder="4~12자리 입력해 주세요." aria-describedby="pwdHelp">
                  <div id="pwdHelp" class="form-text text-danger"></div>
               </div>
               <div class="mb-3">
                  <label for="name" class="form-label">이름</label>
                  <input type="text" class="form-control" id="username" name="username" placeholder="이름을 입력해 주세요." aria-describedby="nameHelp">
                  <div id="nameHelp" class="form-text text-danger"></div>
               </div>
               <div class="mb-3">
                  <label for="tel" class="form-label">전화번호</label>
                  <input type="tel" class="form-control" id="tel" name="tel" placeholder="(ex:01012345678)" aria-describedby="telHelp">
                  <div id="telHelp" class="form-text text-danger"></div>
               </div>
               <div class="btn-wrap">
                  <div class="form-check form-check-inline mb-3">
                     <input id="student" name="role" type="radio" class="form-check-input" value="student">
                     <label for="student" class="form-check-label">학생</label>
                  </div>
                  <div class="form-check form-check-inline mb-3">
                     <input id="mentor" name="role" type="radio" class="form-check-input" value="mentor">
                     <label for="mentor" class="form-check-label">멘토</label>
                  </div>
                  <div id="roleHelp" class="form-text text-danger"></div>
               </div>
               <div class="d-grid gap-2 btn-wrap">
                  <input type="button" class="btn btn-primary" value="회원가입" onclick="send(this.form)">
                  <input type="button" class="btn btn-outline-dark" value="취소" onclick="location.href='login_form'">
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