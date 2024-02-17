<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/announcement_list.css">

</head>
<body>

	<%@ include file="../include/menu.jsp" %>

	<section class="sec event">
		<div class="container">
		 <h1>스터디룸 공지사항</h1>
		  <div class="row gy-4">
			<div class="box col-12 col-md-6">
			  <div class="gt">
				<table border="1">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
					<c:forEach var="dto" items="${list }">
						<tr>
							<td>${dto.id }</td>
							<td><a href="view?id=${dto.id}&page=${param.page }">${dto.title }</a></td>
							<td>관리자</td> <!-- 작성자는 관리자로 표시되게 -->
							<td>${dto.register_date }</td>
						</tr>
					</c:forEach>		
				</table>
			  </div>
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