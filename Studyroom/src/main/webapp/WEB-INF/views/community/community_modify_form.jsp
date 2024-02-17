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
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function send(f){
			f.submit();
	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec community">
		<div class="container">
		 <h1>커뮤니티 글 수정하기</h1>
		  <div class="row gy-4">
			<div class="col box col-12">
				<form action="community_modify" method="post">
					<input type="hidden" name="id" value="${dto.id ***REMOVED***">
						<table border="1" align="center">
							<tr>
								<th>제목</th>
								<td><textarea rows="1" cols="50" name="title" style="resize:none;">${dto.title ***REMOVED***</textarea></td>
							</tr>	
							<tr>
								<th>작성자</th>
								<td>${dto.nickname ***REMOVED***</td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea rows="5" cols="50" name="content" style="resize:none;">${dto.content ***REMOVED***</textarea></td>		
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="button" class="btn btn-primary" value="수정" onclick="send(this.form)">		
									<input type="button" class="btn btn-light" value="취소" onclick="location.href='community_list'">
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