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
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script>
		// 첨부 파일 제거 요청 여부
		// 0 = false
		// 1 = true
		let file_delete_request = 0;
	
		// 페이지가 로드되면 첨부 파일 제거 요청 여부를 false로 설정
		window.onload = function () {
			file_delete_request = 0;
		} 
		
		// 수정한 내용을 course_board_modify Mapping으로 전송
		function send() {
			f.action = "course_board_modify?id=${dto.id}&page=${param.page}&delete_flag="+file_delete_request;
			f.submit();
		}
		
		// 수정을 취소하고 공지글 상세보기 페이지로 이동
		function back() {
			if(isCourse == 0) { 
				location.href = "view?id=${dto.id}&page=${param.page}";
			} else {
				location.href = "course_board_view?id=${dto.id}&page=${param.page}";
			}
		}
		
		// 첨부파일 제거 요청 처리
		function delete_file() {
			let file_name = document.querySelector("#file_name");
			let name_value = file_name.innerHTML.trim();
			let file_delete_btn = document.querySelector("#file_delete_btn");
			
			// 첨부파일 제거를 요청할 때
			if (name_value == "${dto.file_name}") { 
				file_delete_request = 1; // 첨부파일 제거 요청 true
				file_name.innerHTML = ""; // 기존 첨부파일 이름 표시를 제거
				file_delete_btn.value = "첨부파일 제거 취소"; // 버튼 value 변경
				console.log(file_delete_request);
			// 첨부파일 제거 요청을 취소할 때
			} else if (name_value == "") { 
				file_delete_request = 0; // 첨부파일 제거 요청 false
				file_name.innerHTML = "${dto.file_name}"; // 기존 첨부파일 이름 표시
				file_delete_btn.value = "첨부파일 제거"; // 버튼 value 변경
				console.log(file_delete_request);
			}
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec board">
		<div class="container">
		 <h1>코스 공지글 수정하기</h1>
		  <div class="row gy-4">
			<div class="box col-12 col-md-6">
				<form name="f" method="POST" enctype="multipart/form-data">
					<table>
						<tr>
							<th>제목</th>
							<td><input name="title" value="${dto.title}"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" rows="10" cols="50" style="resize:none;">${dto.content}</textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="2">
								<span id="file_name">${dto.file_name}</span>
								<input id="file_delete_btn" type="button" value="첨부파일 제거" onclick="delete_file()">
								<input name="file" type="file">
							</td>
						</tr>
						<tr>
							<td>
								<input id="send_btn" type="button" value="글 수정하기" onclick="send()"></input>
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

	<%@ include file="../include/footer.jsp" %>

	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>