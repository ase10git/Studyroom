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
    <link rel="stylesheet" href="resources/css/course_list.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script type="text/javascript">		
		function insert() {
			location.href = "course_insert_form";
		}
		
		function add_course(user_id, user_name, course_id, course_name) {
		    var confirmMessage = "정말 "+user_name+" 님의 계정에 "+course_name+" 코스를 등록하시겠습니까?";
		    if (!confirm(confirmMessage)) {
		        return;
		    }
		    
		    location.href = "user_course_insert?user_id=" + user_id + "&course_id=" + course_id;
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
    <section class="sec course">
        <div class="container">
	       <div class="titlediv text-center">
			    <h1 class="nanum-gothic-regular">코스 목록</h1>
			</div>
			
	        <div class="row gy-4 justify-content-center">
	        	<c:forEach var="dto" items="${list}">
	               <div class="col box col-4">
	               		<div class="gt item card d-flex">
	               			<span class="card-header fw-bold d-flex justify-content-between align-items-center">
		               			<a href="course_board_list?course_id=${dto.id}">${dto.title}</a>
		               			<input id="insert_btn" 
		               				   type="button" 
		               				   class="btn btn-primary btn-sm" 
		               				   value="코스 추가하기" 
		               				   onclick="add_course('${user_dto.id}', '${user_dto.username}', '${dto.id}', '${dto.title}')">
		               		</span>
		               		<div class="card-body">
			               		<p class="instructor card-text">
			               			<span class="d-block">${dto.instructor}</span>
			               			<span class="d-block">${fn:split(dto.start_date, " ")[0]} ~ ${fn:split(dto.end_date, " ")[0]}</span>
			               		</p>
		               		</div>
	               		</div>
	               </div>
	            </c:forEach>
	            <div class="col box col-12">${pageMenu}</div>
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
