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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
	body, html {
		height: 100%;
		margin: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		font-family: Arial, sans-serif;
		background-color: #f0f0f0;
	}

	.container {
	    display: flex;
	}
	
	.logo {
	    width: 300px;
	    height: 100%;
	    background-color: #333;
	    color: #fff;
	    border-radius: 20px;
	    padding: 20px;
	    box-sizing: border-box;
	    overflow: hidden;
	    transition: all 0.5s ease;
	    position: relative;
	}

     .logo h1 {
         margin: 0;
         padding: 20px 0;
         text-align: center;
         font-size: 24px;
     }



     #expand-menu {
         display: none;
     }

     #expand-menu:checked ~ .menu {
         width: 0;
         padding: 0;
         overflow: hidden;
     }

     .login-form {
         padding: 20px;
         background-color: #fff;
         border-radius: 10px;
         box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
     }

     .login-form input[type="text"],
     .login-form input[type="password"] {
         width: 100%;
         padding: 10px;
         margin-bottom: 15px;
         border: 1px solid #ccc;
         border-radius: 5px;
     }

     .login-form input[type="button"] {
         width: 100%;
         padding: 10px;
         border: none;
         background-color: #333;
         color: #fff;
         border-radius: 5px;
         cursor: pointer;
     }

     .login-form input[type="button"]:hover {
         background-color: #555;
     }

	@media (max-width: 768px) {
		.container {
			flex-direction: column;
			align-items: stretch;
		}

		.logo {
			width: 100%;
			height: auto;
			border-radius: 0;
		}

		.logo h1 {
		    padding: 10px 0;
		    font-size: 20px;
		}

	    .login-form {
	        border-radius: 0;
	    }
    }
</style>
</head>
<body>
	<div class="container">
		<input type="checkbox" id="expand-menu" name="expand-menu">
		<div class="logo">
	        <h1>Studyroom</h1>
    	</div>

	<form class="login-form" action="">
		<table border="1" align="center" id="login_tbl" name="login_tbl">
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
	</div>
</body>
</html>