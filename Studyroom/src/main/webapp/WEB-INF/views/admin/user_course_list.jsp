<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
			;
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
	        <div class="title-wrap d-flex justify-content-between">
	         <h1 class="title text-center">코스 목록</h1>
	         	<c:if test="${role eq 'admin'***REMOVED***">
			    	<input id="insert_btn" type="button" class="btn btn-primary btn-sm" value="코스 추가하기" onclick="insert()">    
				</c:if>
			</div>
			
	        <div class="row gy-4 justify-content-center">
	        	<c:forEach var="dto" items="${list***REMOVED***">
	               <div class="col box col-4">
	               		<div class="gt item card d-flex">
	               			<span class="card-header fw-bold d-flex justify-content-between align-items-center">
		               			<a href="course_board_list?course_id=${dto.id***REMOVED***">${dto.title***REMOVED***</a>
		               			<c:if test="${role eq 'admin'***REMOVED***">
									<input id="manage-btn" type="button" class="btn btn-primary float-end" value="코스 관리" onclick="management(${dto.id***REMOVED***)">
			                    </c:if>
		               		</span>
		               		<div class="card-body">
			               		<p class="instructor card-text">
			               			<span class="d-block">${dto.instructor***REMOVED***</span>
			               			<span class="d-block">${fn:split(dto.start_date, " ")[0]***REMOVED*** ~ ${fn:split(dto.end_date, " ")[0]***REMOVED***</span>
			               		</p>
		               		</div>
	               		</div>
	               </div>
	            </c:forEach>
	            <div class="col box col-12">${pageMenu***REMOVED***</div>
	    	</div>
        </div>
    </section>

    <%@ include file="../include/footer.jsp" %>

	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html> --%>









<%-- ui 는 사용자 코스 목록 jsp 그대로 하고 따로 추가 버튼만 만들기 --%>