<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 공지글 목록</title>
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
		function back() {
			location.href = "course_list";
		}
		
		function insert() {
			location.href="course_board_insert_form?course_id=${course_dto.id}";
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

    <section class="sec course-info">
        <div class="container">
         <h1 class="title">코스</h1>
          <div class="row gy-4">
            <div class="col box col-12">
                <table class="info-box">
                    <tr>
                        <th>코스 이름</th>
                        <th>강사 이름</th>
                        <th>기간</th>
                    </tr>
                    <tr>
                        <td>${course_dto.title}</td>
                        <td>${course_dto.instructor}</td>
                        <td>${fn:split(course_dto.start_date, " ")[0]} ~ ${fn:split(course_dto.end_date, " ")[0]}</td>
                    </tr>
                    <tr>
                        <td colspan="3"><p class="summary">${course_dto.summary}</p></td>
                    </tr>
                </table>
            </div>
            
            <div class="col box col-12">
                <table class="board-box">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>게시 날짜</th>
                    </tr>
                    
                    <c:forEach var="dto" items="${list}">
                        <tr>
                            <td>${dto.id}</td>
                            <td><a href="course_board_view?id=${dto.id}&page=${param.page}">${dto.title}</a></td>
                            <td>${fn:split(dto.register_date, " ")[0]}</td>
                        </tr>  
                    </c:forEach>

                    <tr>
                        <td colspan="3">
                            <c:if test="${role eq 'admin' || role eq 'mentor'}">
                            	<input id="insert_btn" type="button" class="btn btn-primary" value="글 작성하기" onclick="insert()">
                        	</c:if>
                            <input id="back_btn" type="button" class="btn btn-light" value="뒤로 가기" onclick="back()">
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