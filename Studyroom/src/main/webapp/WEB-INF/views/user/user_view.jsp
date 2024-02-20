<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 페이지</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/user_view.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
    <script>
	    if ("${updateSuccess}") {
	        alert('수정 완료');
	    }
    
	    function redirectToAuthForm(action) {
	        location.href = "user_pw_auth_form?id=${dto.id}&action="+action;
	    }
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

	<section class="sec user">
		<div class="container justify-content-center">
		 <h1 class="title text-center">사용자 정보</h1>
	  		<div class="row g-3 align-items-center justify-content-center">
			  <div class="col-auto">
			    <label for="email" class="col-form-label">이메일</label>
			    <input type="email" id="email" class="form-control" value="${dto.email}" disabled readonly>
			  </div>
			</div>
			<div class="row g-3 align-items-center justify-content-center">
			  <div class="col-auto">
			    <label for="pwd" class="col-form-label">비밀번호</label>
			    <input type="password" id="pwd" class="form-control" value="${dto.pwd}" disabled readonly>
			  </div>
			</div>
			<div class="row g-3 align-items-center justify-content-center">
			  <div class="col-auto">
			    <label for="name" class="col-form-label">이름</label>
			    <input type="text" id="name" class="form-control" value="${dto.username}" disabled readonly>
			  </div>
			</div>
			<div class="row g-3 align-items-center justify-content-center">
			  <div class="col-auto">
			    <label for="tel" class="col-form-label">전화번호</label>
			    <input type="tel" id="tel" class="form-control" value="${dto.tel}" disabled readonly>
			  </div>
			</div>
			<div class="row g-3 align-items-center justify-content-center">
			  <div class="col-auto">
			    <label for="role" class="col-form-label">역할</label>
			    <input type="text" id="role" class="form-control" value="${dto.role}" disabled readonly>
			  </div>
			</div>
			<div class="row g-3 align-items-center justify-content-end">
			  <div class="col-auto">
			    <input type="button" class="btn btn-primary" value="수정하기" onclick="redirectToAuthForm('update')">
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