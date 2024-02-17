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
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script>
		function send() {
			f.submit();
		}
		
		function back() {
			location.href="course_view?id=${dto.id}&page=${param.page}";
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

	<section class="sec">
		<div class="container">
		 <h1>코스 수정하기</h1>
		  <div class="row gy-4">
			<div class="box col-12 col-md-6">
				<form action="course_modify?id=${dto.id}" name="f" method="POST">
					<input type="hidden" name="page" value="${param.page}">
					<table>
<!-- 						<caption>:::코스 수정하기:::</caption> -->
						<tr>
							<th>코스 이름</th>
							<td><input name="title" value="${dto.title}"></td>
						</tr>
						<tr>
							<th>강사</th>
							<td><input name="instructor" value="${dto.instructor}"></td>
						</tr>
						<tr>
							<th>코스 설명</th>
							<td><textarea name="summary" rows="5" cols="50" style="resize:none;">${dto.summary}</textarea></td>
						</tr>
						<tr>
							<th>코스 시작일</th>
							<td><input name="start_date" type="date" value="${fn:split(dto.start_date, ' ')[0]}"></td>
						</tr>
						<tr>
							<th>코스 종료일</th>
							<td><input name="end_date" type="date" value="${fn:split(dto.end_date, ' ')[0]}"></td>
						</tr>
						<tr>
							<td>
								<input id="send_btn" type="button" class="btn btn-primary" value="코스 수정하기" onclick="send()"></input>
							</td>
							<td>
								<input id="back_btn" type="button" class="btn btn-light" value="뒤로 돌아가기" onclick="back()"></input>
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