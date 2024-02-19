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
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<%@ include file="../include/menu.jsp" %>

	<section class="sec user-modify">
		<div class="container">
		 <h1>사용자 정보 수정</h1>
		  <div class="row gy-4">
			<div class="box col-12">
				<!-- 슈발 user 테이블에 이름 항목부터 넣자 -->
				<%-- 	<form action="insert" name="f" method="post">
					<input type="hidden" name="id" value="${param.page***REMOVED***">
					<table>
						<caption>정보 수정</caption>
						<tr>
							<th>제목</th>
							<td><input name="subject"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input name="name"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" rows="10" cols="50" style="resize:none;"></textarea></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input name="pwd" type="password"></td>
						</tr>
						<tr>
							<td colspan="2">
								<img src="resources/img/btn_reg.gif" onclick="send_check();">
								<img src="resources/img/btn_back.gif" onclick="location.href='board_list'">
							</td>
						</tr>
					</table>
				</form> --%>
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