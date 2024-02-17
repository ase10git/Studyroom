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
<script>
	function send_check(){
		let f = document.f;
		
		f.submit();
	}
</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec community">
		<div class="container">
		 <h1>커뮤니티 글 작성하기</h1>
		  <div class="row gy-4">
			<div class="col box col-12">
				<form action="community_insert" name="f" method="post" enctype="multipart/form-data">
					<input type="hidden" name="page" value="${param.page}">
					<table border="1">
						<tr>
							<th>제목</th>
							<td><input name="title"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input name="nickname"></td>
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
							<td colspan="2">
								<img src="resources/img/btn_reg.gif" onclick="send_check();">
								<img src="resources/img/btn_back.gif" onclick="location.href='community_list'">
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




