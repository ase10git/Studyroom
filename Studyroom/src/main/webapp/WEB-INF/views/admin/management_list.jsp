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
  <link rel="stylesheet" href="resources/css/management_list.css">
  	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<%@ include file="../include/menu.jsp" %>
	
	<div class="sec admin">
		<div class="container">
			<h2 class="title text-center">전체 사용자 보기</h2>
			<div class="row col-12 justify-content-center">
				<div class="col-auto">
					<input type="button" class="btn btn-primary" value="이동" onclick="location.href='user_all_info_list'">
				</div>
			</div>
		</div>
	</div>
	
	<div class="sec admin">
		<div class="container">
			<h2 class="title text-center">삭제 요청 관리</h2>
			<div class="row col-12 justify-content-center">
				<div class="col-auto">
					<input type="button" class="btn btn-primary" value="이동" onclick="location.href='delete_management'">
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../include/footer.jsp" %>
  
	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>