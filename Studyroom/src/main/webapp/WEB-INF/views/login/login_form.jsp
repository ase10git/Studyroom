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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
 	.menu ::before{ 
 	    font-family: 'Material Icons'; 
 	    font-size: 1.5em; 
 	    float: left; 
 	    clear: left; 
 ***REMOVED*** 
	
 	.menu label::before{ content: '\e5d2'; ***REMOVED*** 
 	.menu li:nth-child(1) a::before{ content: '\f02e'; ***REMOVED*** 
 	.menu li:nth-child(2) a::before{ content: '\e8d6'; ***REMOVED*** 
 	.menu li:nth-child(3) a::before{ content: '\e88a'; ***REMOVED*** 
 	.menu li:nth-child(4) a::before{ content: '\e8cc'; ***REMOVED*** 
 	.menu li:nth-child(5) a::before{ content: '\e87d'; ***REMOVED*** 
 	.menu li:nth-child(6) a::before{ content: '\e8b8'; ***REMOVED*** 
	
 	#expand-menu { /* 체크박스 폼 요소 감춤 */ 
     	display: none; 
 ***REMOVED*** 
	
 	#expand-menu:checked ~ ul { /* 체크박스 체크되었으면 메뉴 목록 표시 - 반응형 표시용 */ 
 	    display: block; 
 	    height: auto; 
 ***REMOVED*** 
	
 	.menu { 
 	    float:left;
 	    width: 300px; 
 	    height: 750px; 
 	    background-color: #000; 
 	    color: #fff; 
 	    border-radius: 20px; 
 	    padding: 10px; 
 	    box-sizing: border-box; 
 	    overflow: hidden; /* 반응형 애니메이션용 */ 
	    transition: all 0.5s ease; /* 반응형 애니메이션 */ 
 ***REMOVED*** 
	
 	.menu ul { 
 	    list-style: none; 
 	    margin: 0; 
 	    padding: 0; 
 ***REMOVED*** 
	
 	.menu a, .menu > label { 
 	    display: block; 
 	    height: 25px; 
 	    padding: 8px; 
 	    cursor: pointer; 
 	    color: #fff; 
 	    text-decoration: none; 
 ***REMOVED*** 
	
 	.menu a:hover { 
     color: #000; 
 ***REMOVED*** 
	
	.menu ul li:hover, .menu > label:hover { 
 	    background-color: #fff; 
 	    color: #000; 
 	    border-radius: 10px; 
 ***REMOVED*** 
	
 	.menu div { 
 	    line-height: 1.5; 
 	    font-size: 1em; 
 	    font-family: 'Noto Sans KR'; 
 	    padding: 0 0 0 50px; /* 아이콘과 텍스트 사이 여백 */ 
 ***REMOVED*** 
	
	body, html {	
		height:100%;
		margin: 0;
		display: flex;
 		justify-content: center; 
		align-items: center;	
***REMOVED***
	
	.login_tbl {
		width: 50%;
***REMOVED***

	

</style>
</head>
<body>
	<div class="menu">
		<label for="expand-menu"><div>Studyroom</div></label>
		<input type="checkbox" id="expand-menu" name="expand-menu"><br><br><br>
		<ul>
			<li><a href='/' class="item"><div>로그인</div></a><br>
			<li><a href='/' class="item"><div>메뉴1</div></a><br>
			<li><a href='/' class="item"><div>메뉴2</div></a><br>
			<li><a href='/' class="item"><div>메뉴3</div></a><br>
			<li><a href='/' class="item"><div>메뉴4</div></a>
		</ul>
	</div>

	<form action="">
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
</body>
</html>