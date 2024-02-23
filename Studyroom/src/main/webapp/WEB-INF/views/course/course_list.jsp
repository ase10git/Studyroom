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
	<!-- AJAX -->
	<script src="resources/js/HttpRequest.js"></script>
	<script type="text/javascript">		
	    if ("${insertSuccess}" == 1) {
	        alert('코스 추가 완료');
	    }
	    if("${insertSuccess}" == 2){
	    	alert('실패했습니다')
	    }
		
		function move(id) {
			;
		}
		
		function management(id) {
			location.href = "course_view?id=" + id + "&page=${param.page}";	
		}
		
		function insert() {
			location.href = "course_insert_form";
		}
		
		function user_course_insert(id) {
			location.href = "user_course_insert_form?id="+id;
		}
		
		function del(user_id, course_id){
			if(!confirm("삭제하시겠습니까?")){
				return;
			}
			
			var url = "user_course_delete";
			var param = "user_id="+user_id+"&course_id="+course_id;
			
			sendRequest(url,param,delCheck,"post");
		}
		
		function delCheck(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = xhr.responseText;
				
				var json = (new Function('return' + data))();
				
				if(json[0].result == 'yes'){
					alert('삭제 성공')
					location.href='course_list?id='+${user_dto.id};
				} else {
					alert('삭제 실패')
				}
			}
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
    <section class="sec course">
        <div class="container">
	       <div class="titlediv text-center">
			    <h1 class="nanum-gothic-regular">코스 목록</h1>
   		        <c:if test="${sessionScope.dto.role eq 'admin'}">
              		<c:choose>
              		<c:when test="${role eq 'admin'}">
						<input id="insert_btn" type="button" class="btn btn-primary btn-sm" value="코스 만들기" onclick="insert()">
                    </c:when>
                    <c:otherwise>
                    	<input id="insert_btn" type="button" class="btn btn-primary btn-sm" value="코스 추가하기" onclick="user_course_insert('${user_dto.id}')">
                    </c:otherwise>
                    </c:choose>
            	</c:if>
			</div>
			
	        <div class="row gy-4 justify-content-center">
	        	<c:forEach var="dto" items="${list}">
	               <div class="col box col-4">
	               		<div class="gt item card d-flex">
	               			<span class="card-header fw-bold d-flex justify-content-between align-items-center">
		               			<a href="course_board_list?course_id=${dto.id}">${dto.title}</a>
		               			<!-- choose when 으로 이 밑에 조건을 감싸는 test=${sessionScope.dto.role eq 'admin'} 을 만들어서 버튼 바꾸기 -->
		               			<c:if test="${sessionScope.dto.role eq 'admin'}">
			               			<c:choose>
			               			<c:when test="${role eq 'admin'}">
										<input id="manage-btn" type="button" class="btn btn-primary float-end" value="코스 관리" onclick="management(${dto.id})">
				                    </c:when>
				                    <c:otherwise>
				                    	<input id="manage-btn" type="button" class="btn btn-primary float-end" value="코스 제거" onclick="del('${user_dto.id}' , '${dto.id}')">
				                    </c:otherwise>
				                    </c:choose>
				            	</c:if>
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