<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 수정</title>
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
		function send() {
			const regex_title = /^[\w\s]{1,50***REMOVED***$|^[\p{ㄱ-힣***REMOVED***\s]{1,25***REMOVED***$/;
			
			let title = document.getElementById("title").value;
			let instructor = document.getElementById("instructor").value;
			let summary = document.getElementById("summary").value;
			let start_date = document.getElementById("start_date").value;
			let end_date = document.getElementById("end_date").value;

			if (!title) {
				alert("코스 이름을 입력해주세요!");
				return;
		***REMOVED***
			
			if(!regex_title.test(title)) {
				alert("코스 이름은 영문자 50자 또는 한글 최대 25자까지만 입력 가능합니다!");
				return;
		***REMOVED***
			
			if (!instructor) {
				alert("강사 이름을 입력해주세요!");
				return;
		***REMOVED***	
			
			if (!summary) {
				alert("코스 설명을 입력해주세요!");
				return;
		***REMOVED***
			
			if (!start_date) {
				alert("코스 시작일을 입력해주세요!");
				return;
		***REMOVED***
			
			if (!end_date) {
				alert("코스 종료일을 입력해주세요!");
				return;
		***REMOVED***
			
			if (start_date > end_date) {
				alert("코스 기간이 잘못 설정되었습니다!");
				return;
		***REMOVED***
			
			f.submit();
	***REMOVED***
		
		function back() {
			location.href="course_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

	<section class="sec">
		<div class="container">
		 <h1 class="title text-center">코스 수정하기</h1>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<form action="course_modify?id=${dto.id***REMOVED***" name="f" method="POST">
					<input type="hidden" name="page" value="${param.page***REMOVED***">
					<table>
						<tr>
							<th>코스 이름</th>
							<td><input name="title" id="title" class="form-control" value="${dto.title***REMOVED***"></td>
						</tr>
						<tr>
							<th>강사</th>
							<td><input name="instructor" id="instructor" class="form-control" value="${dto.instructor***REMOVED***"></td>
						</tr>
						<tr>
							<th>코스 설명</th>
							<td><textarea name="summary" id="summary" class="form-control" rows="5" cols="50" style="resize:none;">${dto.summary***REMOVED***</textarea></td>
						</tr>
						<tr>
							<th>코스 기간</th>
							<td class="d-flex justify-content-center">
								<div class="col-8 d-flex">
									<input name="start_date" id="start_date" class="form-control" type="date" value="${fn:split(dto.start_date, ' ')[0]***REMOVED***">
									<input name="end_date" id="end_date" class="form-control" type="date" value="${fn:split(dto.end_date, ' ')[0]***REMOVED***">
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="d-flex justify-content-end">
									<input id="send_btn" type="button" class="btn btn-primary" value="코스 수정하기" onclick="send()"></input>
									<input id="back_btn" type="button" class="btn btn-light" value="뒤로 돌아가기" onclick="back()"></input>
								</div>
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