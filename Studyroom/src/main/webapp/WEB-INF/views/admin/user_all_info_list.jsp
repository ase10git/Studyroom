<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
  <link rel="stylesheet" href="resources/css/main.css">
  <link rel="stylesheet" href="resources/css/user_list.css">
  	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<%@ include file="../include/menu.jsp" %>
	
  <section class="sec event">
    <div class="container">
     <h1 class="title text-center">전체 사용자</h1>
      <div class="row gy-4">
        <div class="col box col-12 d-flex justify-content-center">
          <table class="board text-center">
          	<tr>
				<th>사용자 이름</th>
				<th>로그인 이메일</th>
				<th>삭제요청 여부</th>
				<th>수강중인 코스</th>
			</tr>
          	<c:forEach var="dto" items="${list}">
          	<tr>
          		<td><button type="button" class="btn btn-link" onclick="location.href='user_view?id=${dto.id}'">${dto.username}</button></td>
          		<td>${dto.email}</td>
          		<c:choose>
          			<c:when test="${dto.del_flag eq -1}">
          				<td style="color:red;">삭제요청</td>
          			</c:when>
          			<c:otherwise>
						<td></td>          			
          			</c:otherwise>
          		</c:choose>
          		<td><button type="button" class="btn btn-info" onclick="location.href='course_list?id=${dto.id}'">보기</button></td>
          	</tr>
          	</c:forEach>
          </table>
        </div>
      </div>
      <div class="row gy-4">
        	<div class="menu-tab">
        		${pageMenu}
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