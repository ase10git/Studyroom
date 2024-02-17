<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 공지글 추가하기</title>
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

	<script type="text/javascript">
		function send() {
			f.submit();
	***REMOVED***
		
		function back() {
			if ("${param.course_id***REMOVED***" == 0) {
				location.href = "announcement_list";
		***REMOVED*** else {
				location.href = "course_board_list?course_id=${param.course_id***REMOVED***";	
		***REMOVED***

	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec board-insert">
		<div class="container">
		<c:choose>
			<c:when test="${param.course_id eq 0***REMOVED***">
				<h1>전체 공지 추가하기</h1>
			</c:when>
			<c:otherwise>
				<h1>코스 공지글 추가하기</h1>
			</c:otherwise> 
		</c:choose>
		  <div class="row gy-4">
			<div class="box col col-12">
				<form action="course_board_insert" name="f" method="POST" enctype="multipart/form-data">
					<input name="course_id" type="hidden" value="${param.course_id***REMOVED***">
					<table class="insert-box">
						<tr>
							<th>제목</th>
							<td><input name="title"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" rows="10" cols="50" style="resize:none;"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td><input name="file" type="file"></td>
						</tr>
						<tr>
							<td>
								<input id="send_btn" type="button" value="글 등록하기" onclick="send()"></input>
							</td>
							<td>
								<input id="back_btn" type="button" value="뒤로 돌아가기" onclick="back()"></input>
							</td>
						</tr>
					</table>
				</form>
			</div>
		  </div>
		</div>
	  </section>

	<footer>
		<%@ include file="../include/footer.jsp" %>
	</footer>

	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>