<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 글 작성</title>
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
		const regex_title = /^[\w\s]{1,50}$|^[\p{ㄱ-힣}\s]{1,25}$/;	
		const regex_file = /([^\s]+(?=\.(jpg|gif|png|PNG|GIF|JPG))\.\2)/;
		//출처: https://gocoding.tistory.com/93 [Developer Factory:티스토리]
			
		function send_check(){
			let f = document.f;
			let title = document.getElementById("title").value;
			let content = document.getElementById("content").value;
			let file = document.getElementById("file").value;
			
			if (!title) {
				alert("제목을 1글자 이상 입력해주세요");
				return;
			}
			
			if(!regex_title.test(title)) {
				alert("제목은 영문자 50자 또는 한글 최대 25자까지만 입력 가능합니다!");
				return;
			}
			
			if (!content) {
				alert("내용을 1글자 이상 입력해주세요");
				return;
			}
			
			if(file && !regex_file.test(file)) {
				alert("jpg, gif, png 형식 파일만 가능합니다!");
				return;
			}
			
			f.submit();
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec community">
		<div class="container">
		 <h1 class="title text-center">커뮤니티 글 작성하기</h1>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<form action="community_insert" name="f" method="post" enctype="multipart/form-data">
					<input type="hidden" name="page" value="${param.page}">
					<table>
						<tr>
							<th>제목</th>
							<td><input name="title" id="title" class="form-control"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input name="nickname" class="form-control"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" id="content" class="form-control" rows="10" cols="50" style="resize:none;"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td><input name="file" id="file" type="file" class="form-control"></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="d-flex justify-content-end">
									<input type="button" class="btn btn-primary" value="추가" onclick="send_check();">		
									<input type="button" class="btn btn-light" value="취소" onclick="location.href='community_list'">
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




