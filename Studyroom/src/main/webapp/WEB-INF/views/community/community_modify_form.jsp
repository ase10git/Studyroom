<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 글 수정</title>
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
	<script type="text/javascript">
		function send(f){
			f.submit();
		}
		
		function back() {
			location.href = "community_view?id=${dto.id}&page=${param.page}";
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec community">
		<div class="container">
		 <h1 class="title text-center">커뮤니티 글 수정하기</h1>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<form action="community_modify" method="post">
					<input type="hidden" name="id" value="${dto.id }">
						<table>
							<tr>
								<th>제목</th>
								<td><input type="text" name="title" class="form-control" value="${dto.title}"></td>
							</tr>	
							<tr>
								<th>작성자</th>
								<td><span>${dto.nickname}</span></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea name="content" class="form-control" rows="5" cols="50" style="resize:none;">${dto.content }</textarea></td>		
							</tr>
							<tr>
								<td colspan="2">
									<div class="d-flex justify-content-end">
										<input type="button" class="btn btn-primary" value="수정" onclick="send(this.form)">		
										<input type="button" class="btn btn-light" value="취소" onclick="back()">
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