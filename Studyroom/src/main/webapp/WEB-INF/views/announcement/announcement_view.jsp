<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
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
	
	<script type="text/javascript" src="resources/js/HttpRequest.js"></script>
	<script type="text/javascript">
		function back() {
			location.href = "announcement_list";
	***REMOVED***
		
		function del() {			
			if (!confirm("삭제하시겠습니까?")) {
				return;
		***REMOVED***
			
			let url = "course_board_delete";
			let param = "id=${dto.id***REMOVED***";
			
			sendRequest(url, param, resultFn, "POST");
	***REMOVED***
			
		function resultFn() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText;
				let json = (new Function('return' + data))();
				
				if(json[0].result == 'yes') {
					alert("성공적으로 삭제했습니다.");
					location.href = "announcement_list";
			***REMOVED*** else {
					alert("삭제를 실패했습니다.");
					return;
			***REMOVED***
		***REMOVED***
	***REMOVED***
		
		function modify() {
			location.href = "course_board_modify_form?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
	***REMOVED***
	</script>
</head>

<body>

	<%@ include file="../include/menu.jsp" %>
	
  <section class="sec info">
    <div class="container">
     <h1 class="title">공지사항 상세보기</h1>
      <div class="row gy-4">
        <div class="box col-12">
			<table class="info-box">
				<tr>
					<th>제목</th>
					<td>${dto.title***REMOVED***</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>관리자</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${dto.register_date***REMOVED***</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<p>${dto.content***REMOVED***<p>
						<c:if test="${dto.file_name ne 'no_file'***REMOVED***">
							<img src="${pageContext.request.contextPath***REMOVED***/resources/upload/${dto.file_name***REMOVED***" alt="">
						</c:if>
					</td>
				</tr>
				<tr>
					<th>첨부 파일</th>
					<td>
						<c:choose>
							<c:when test="${dto.file_name ne 'no_file'***REMOVED***">
								<a href="course_board_filedownload?id=${dto.id***REMOVED***">${dto.file_name***REMOVED***</a>
							</c:when>
							<c:otherwise>
								<span>첨부 파일 없음</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" class="btn btn-light" value="뒤로가기" onclick="back()">
						<c:if test="${role eq 'admin'***REMOVED***">
							<input id="modify_btn" type="button" class="btn btn-primary" value="글 수정하기" onclick="modify()"></input>
							<input id="delete_btn" type="button" class="btn btn-primary" value="글 삭제하기" onclick="del()"></input>	
						</c:if>
					</td>
				</tr>
			</table>
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