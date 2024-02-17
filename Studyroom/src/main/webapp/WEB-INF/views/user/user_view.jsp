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
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

	<section class="sec user">
		<div class="container">
		 <h1 class="title">사용자 정보</h1>
		  <div class="row gy-4">
			<div class="box col-12">
				<table class="user-info">
					<tr>
						<th>아이디</th>
						<td>${dto.username}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${dto.email}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${dto.tel}</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="수정하기" onclick="location.href='user_pw_auth_form'">
						</td>
					</tr>
				</table>
			</div>
		  </div>
		</div>
	  </section>

	<c:if test="${role eq 'admin'}">
		<div class="sec admin">
			<div class="container">
				<h2 class="title">삭제 요청 관리</h2>
				<div class="row">
					<div class="col">
						<input type="button" class="btn del-request-btn" value="삭제요청" onclick="location.href='delete_management'">
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<%@ include file="../include/footer.jsp" %>

		<!-- bootstrap script -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
		crossorigin="anonymous"></script>
</body>
</html>