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
    <!-- <link rel="stylesheet" href="resources/css/style_with_table.css"> -->
    <link rel="stylesheet" href="resources/css/course_board_list.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script type="text/javascript">		
		function back() {
			location.href = "course_list";
	***REMOVED***
		
		function insert() {
			location.href="course_board_insert_form?course_id=${course_dto.id***REMOVED***";
	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

    <section class="sec course-info">
        <div class="container">
         <h2 class="title text-center">${course_dto.title***REMOVED***</h2>
          <div class="row gy-4">
            <div class="col box col-12 d-flex justify-content-center">
                <table class="course-box text-center">
                    <tr>
                        <th>강사 이름</th>
                        <th>기간</th>
                    </tr>
                    <tr>
                        <td>${course_dto.instructor***REMOVED***</td>
                        <td>${fn:split(course_dto.start_date, " ")[0]***REMOVED*** ~ ${fn:split(course_dto.end_date, " ")[0]***REMOVED***</td>
                    </tr>
                    <tr>
                        <td colspan="3"><p class="summary">${course_dto.summary***REMOVED***</p></td>
                    </tr>
                </table>
            </div>
            
            <div class="test col box col-12 d-flex justify-content-center">
                <table class="board-box text-center">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>게시 날짜</th>
                    </tr>
                    
                    <c:forEach var="dto" items="${list***REMOVED***">
                        <tr>
                            <td>${dto.id***REMOVED***</td>
                            <td><a href="course_board_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***">${dto.title***REMOVED***</a></td>
                            <td>${fn:split(dto.register_date, " ")[0]***REMOVED***</td>
                        </tr>  
                    </c:forEach>

                    <tr>
                        <td colspan="3">
                        	<div class="d-flex justify-content-end">
                            <c:if test="${role eq 'admin' || role eq 'mentor'***REMOVED***">
                            	<input id="insert_btn" type="button" class="btn btn-primary" value="글 작성하기" onclick="insert()">
                        	</c:if>
                            <input id="back_btn" type="button" class="btn btn-light" value="뒤로 가기" onclick="back()">
                        	</div>
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