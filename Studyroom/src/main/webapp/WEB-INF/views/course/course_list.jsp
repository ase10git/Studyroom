<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 목록</title>
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
		function move(id) {
			location.href = "course_board_list?course_id=" + id;
	***REMOVED***
		
		function management(id) {
			location.href = "course_view?id=" + id + "&page=${param.page***REMOVED***";	
	***REMOVED***
		
		function insert() {
			location.href = "course_insert_form";
	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
    <section class="sec course">
        <div class="container">
         <h1>코스 목록</h1>
          <div class="row gy-4">
            <div class="col box col-12 col-md-6">
                <table class="course-box">
                    <tr>
                        <th>번호</th>
                        <th>코스 이름</th>
                        <th>강사 이름</th>
                        <th>기간<th>
                    </tr>
                    
                    <c:forEach var="dto" items="${list***REMOVED***">
                        <tr>
                            <td>${dto.id***REMOVED***</td>
                            <td>${dto.title***REMOVED***</td>
                            <td>${dto.instructor***REMOVED***</td>
                            <td>${fn:split(dto.start_date, " ")[0]***REMOVED*** ~ ${fn:split(dto.end_date, " ")[0]***REMOVED***</td>
                            <td>
                                <input id="course_board_btn" type="button" value="코스로 이동" onclick="move(${dto.id***REMOVED***)">
                            </td>
                            <c:if test="${role eq 'admin'***REMOVED***">
	                            <td>
	                                <input id="course_view_btn" type="button" value="코스 관리" onclick="management(${dto.id***REMOVED***)">
	                            </td>
                            </c:if>
                        </tr>  
                    </c:forEach>
                </table>
            </div>
            <c:if test="${role eq 'admin'***REMOVED***">
	  			<div class="col box col-6">
		        	<input id="insert_btn" type="button" value="코스 추가하기" onclick="insert()">    
				</div>
			</c:if>
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