<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
<script type="text/javascript">
	function send(f){
		f.action = "community_modify";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec event">
		<div class="container">
		 <h1>test home</h1>
		  <div class="row gy-4">
			<div class="box col-12 col-md-6">
				<form>
					<input type="hidden" name="id" value="${dto.id }">
						<table border="1" align="center">
							<caption>:::게시글 수정:::</caption>
								<tr>
									<th>제목</th>
									<td><textarea rows="1" cols="50" name="title" style="resize:none;">${dto.title }</textarea></td>
								</tr>	
								<tr>
									<th>작성자</th>
									<td>${dto.nickname }</td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea rows="5" cols="50" name="content" style="resize:none;">${dto.content }</textarea></td>		
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="button" value="수정" onclick="send(this.form)">		
										<input type="button" value="취소" onclick="location.href='community_list'">
									</td>
								</tr>		
						</table>
					</form>
			</div>
		  </div>
		</div>
	  </section>


		<!-- bootstrap script -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
		crossorigin="anonymous"></script>
</body>
</html>