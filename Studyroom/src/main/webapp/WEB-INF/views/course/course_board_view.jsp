<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 공지글 상세보기</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/style_with_table.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>

	<script type="text/javascript" src="resources/js/HttpRequest.js"></script>
	<script>
		function back() {
			location.href = "course_board_list?course_id=${dto.course_id}&page=${param.page}";
		}
		
		function del() {			
			if (!confirm("삭제하시겠습니까?")) {
				return;
			}
			
			let url = "course_board_delete";
			let param = "id=${dto.id}";
			
			sendRequest(url, param, resultFn, "POST");

		}
			
		function resultFn() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText;
				let json = (new Function('return' + data))();
				
				if(json[0].result == 'yes') {
					alert("성공적으로 삭제했습니다.");
					location.href = "course_board_list?course_id=${dto.course_id}";
				} else {
					alert("삭제를 실패했습니다.");
					return;
				}
			}
		}
	
		function modify() {
			location.href = "course_board_modify_form?id=${dto.id}&page=${param.page}";
		}
		
	</script>
</head>

<body>

	<%@ include file="../include/menu.jsp" %>

	<section class="sec course-board">
		<div class="container">
		 <h1 class="title">코스 공지글 상세보기</h1>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<table class="board-box">	
					<tr>
						<th>제목</th>
						<td>${dto.title}</td>
					</tr>
					<tr>
						<th>게시 날짜</th>
						<td>${fn:split(dto.register_date, " ")[0]}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<p>${dto.content}<p>
							<c:if test="${dto.file_name ne 'no_file'}">
								<img src="${pageContext.request.contextPath}/resources/upload/${dto.file_name}" alt="">
							</c:if>
						</td>
					</tr>
					<tr>
						<th>첨부 파일</th>
						<td>
							<c:choose>
								<c:when test="${dto.file_name ne 'no_file'}">
									<a href="course_board_filedownload?id=${dto.id}">${dto.file_name}</a>
								</c:when>
								<c:otherwise>
									<span>첨부 파일 없음</span>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>

			</div>
		  </div>
		  <div class="btn-wrap d-flex justify-content-end">
				<c:if test="${role eq 'admin'}">
					<input id="modify_btn" type="button" class="btn btn-primary" value="글 수정하기" onclick="modify()"></input>
					<input id="delete_btn" type="button" class="btn btn-dark" value="글 삭제하기" onclick="del()"></input>
				</c:if>
				<input id="back_btn" type="button" class="btn btn-light" value="뒤로 돌아가기" onclick="back()"></input>
		  </div>
		</div>
	  </section>

	<%@ include file="../include/footer.jsp" %>

	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
	<!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
</body>
</html>