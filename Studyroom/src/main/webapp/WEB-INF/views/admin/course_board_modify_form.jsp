<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 공지글 수정</title>
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
		const regex_title = /^[\w\s]{1,50***REMOVED***$|^[\p{ㄱ-힣***REMOVED***\s]{1,25***REMOVED***$/;
		
		// 첨부 파일 제거 요청 여부
		// 0 = false
		// 1 = true
		let file_delete_request = 0;
	
		// 페이지가 로드되면 첨부 파일 제거 요청 여부를 false로 설정
		window.onload = function () {
			file_delete_request = 0;
	***REMOVED*** 
		
		// 수정한 내용을 course_board_modify Mapping으로 전송
		function send() {
			let title = document.getElementById("title").value;
			let content = document.getElementById("content").value;

			if (!title) {
				alert("공지글 제목을 입력해주세요!");
				return;
		***REMOVED***
			
			if (!content) {
				alert("내용을 1글자 이상 입력해주세요!");
				return;
		***REMOVED***
			
			if(!regex_title.test(title)) {
				alert("제목은 영문자 50자 또는 한글 최대 25자까지만 입력 가능합니다!");
				return;
		***REMOVED***
			
			f.action = "course_board_modify?id=${dto.id***REMOVED***&page=${param.page***REMOVED***&delete_flag="+file_delete_request;
// 			f.submit();
	***REMOVED***
		
		// 수정을 취소하고 공지글 상세보기 페이지로 이동
		function back() {
			if("${dto.course_id***REMOVED***" == 0) { 
				location.href = "view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
		***REMOVED*** else {
				location.href = "course_board_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
		***REMOVED***
	***REMOVED***
		
		// 첨부파일 제거 요청 처리
		function delete_file() {
			let file_name = document.querySelector("#file_name");
			let name_value = file_name.innerHTML.trim();
			let file_delete_btn = document.querySelector("#file_delete_btn");
			
			// 첨부파일 제거를 요청할 때
			if (name_value == "${dto.file_name***REMOVED***") { 
				file_delete_request = 1; // 첨부파일 제거 요청 true
				file_name.innerHTML = ""; // 기존 첨부파일 이름 표시를 제거
				file_delete_btn.value = "첨부파일 제거 취소"; // 버튼 value 변경
			// 첨부파일 제거 요청을 취소할 때
		***REMOVED*** else if (name_value == "") { 
				file_delete_request = 0; // 첨부파일 제거 요청 false
				file_name.innerHTML = "${dto.file_name***REMOVED***"; // 기존 첨부파일 이름 표시
				file_delete_btn.value = "첨부파일 제거"; // 버튼 value 변경
		***REMOVED***
	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec board">
		<div class="container">
			<c:choose>
				<c:when test="${dto.course_id eq 0***REMOVED***">
					<h1 class="title text-center">공지사항 수정하기</h1>
				</c:when>
				<c:otherwise>
					<h1 class="title text-center">코스 공지글 수정하기</h1>
				</c:otherwise> 
			</c:choose>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<form name="f" method="POST" enctype="multipart/form-data">
					<table>
						<tr>
							<th>제목</th>
							<td><input name="title" id="title" class="form-control" value="${dto.title***REMOVED***"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" id="content" class="form-control" rows="10" cols="50" style="resize:none;">${dto.content***REMOVED***</textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="2">
								<span id="file_name">${dto.file_name***REMOVED***</span>
								<input id="file_delete_btn" type="button" class="btn btn-primary" value="첨부파일 제거" onclick="delete_file()">
								<input name="file" type="file" class="form-control">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="d-flex justify-content-end">
									<input id="send_btn" type="button" class="btn btn-primary" value="글 수정하기" onclick="send()"></input>
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