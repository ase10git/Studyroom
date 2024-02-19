<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 요청 관리</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
    crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/style_with_table.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="resources/js/HttpRequest.js"></script>
	
	<script type="text/javascript">			
			function del() {
				if(!confirm("선택한 항목을 정말 삭제하시겠습니까?")) {
					return;
				}
			
				f.submit();
			}
		</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

    <section class="sec del-request">
    <form name="f" action="delete_physical" method="POST">
        <div class="container">
	        <h2 class="title text-center">수강생 삭제 요청</h2>
	          <div class="row gy-4 ">
	            <div class="col box col-12 d-flex justify-content-center">
	                <table>
	                    <tr>
	                        <th><input class="total_check" type="checkbox"></th>
	                        <th>번호</th>
	                        <th>이메일</th>
	                        <th>이름</th>
	                        <th>역할</th>
	                    </tr>
	                    <c:forEach var="user_dto" items="${user_list}">
		                    <tr>
	                            <td><input class="user-check" type="checkbox" name="userId" value="${user_dto.id}"></td>
	                            <td><span>${user_dto.id}</span></td>
	                            <td><span>${user_dto.email}</span></td>
	                            <td><span>${user_dto.username}</span></td>
	                            <td><span>${user_dto.role}</span></td>
		                    </tr>
	                    </c:forEach>
	                </table>
	            </div>
	          </div>
        </div>

       <div class="container">
	        <h2 class="title text-center">코스 삭제 요청</h2>
	          <div class="row gy-4">
	            <div class="col box col-12 d-flex justify-content-center">
	                <table>
	                    <tr>
	                        <th><input class="total_check" type="checkbox"></th>
	                        <th>번호</th>
	                        <th>코스 이름</th>
	                        <th>강사 이름</th>
	                        <th>기간</th>
	                    </tr>
	                	<c:forEach var="course_dto" items="${course_list}">
		                    <tr>
	                            <td><input class="course-check" type="checkbox" name="courseId" value="${course_dto.id}"></td>
	                            <td><span>${course_dto.id}</span></td>
	                            <td><span>${course_dto.title}</span></td>
	                            <td><span>${course_dto.instructor}</span></td>
	                            <td><span>${fn:split(course_dto.start_date, " ")[0]} ~ ${fn:split(course_dto.end_date, " ")[0]}</span></td>
		                    </tr>
	                    </c:forEach>
	                </table>
	            </div>
	          </div>
        </div>

        <div class="container">
	        <h2 class="title text-center">코스 공지글 삭제 요청</h2>
	          <div class="row gy-4">
	            <div class="col box col-12 d-flex justify-content-center">
	                <table>
	                    <tr>
	                        <th><input class="total_check" type="checkbox"></th>
	                        <th>번호</th>
	                        <th>코스 번호</th>
	                        <th>코스 이름</th>
	                        <th>등록 날짜</th>
	                    </tr>
	                	<c:forEach var="course_board_dto" items="${course_board_list}">
		                    <tr>
	                            <td><input class="courseboard-check" type="checkbox" name="courseboardId" value="${course_board_dto.id}"></td>
	                            <td><span>${course_board_dto.id}</span></td>
	                            <td><span>${course_board_dto.course_id}</span></td>
	                            <td><span>${course_board_dto.title}</span></td>
	                            <td><span>${fn:split(course_board_dto.register_date, " ")[0]}</span></td>
		                    </tr>
	                    </c:forEach>
	                </table>
	            </div>
	          </div>
        </div>

        <div class="container">
        	<h2 class="title text-center">커뮤니티 글 삭제 요청</h2>
	          <div class="row gy-4">
	            <div class="col box col-12 d-flex justify-content-center">
	                <table>
	                    <tr>
	                        <th><input class="total_check" type="checkbox"></th>
	                        <th>번호</th>
	                        <th>작성자id</th>
	                        <th>ip</th>
	                        <th>작성일</th>
	                    </tr>
	                    <c:forEach var="community_dto" items="${community_list}">
		                    <tr>
	                            <td><input class="community-check" type="checkbox" name="communityId" value="${community_dto.id}"></td>
	                            <td><span>${community_dto.id}</span></td>
	                            <td><span>${community_dto.user_id}</span></td>
	                            <td><span>${community_dto.ip_addr}</span>
	                            <td><span>${fn:split(community_dto.register_date, " ")[0]}</span></td>
		                    </tr>
	                    </c:forEach>
	                </table>
	            </div>
	          </div>
        </div>
        <div class="btn-wrap d-flex justify-content-end">
        	<input type="button" class="btn btn-danger del-btn" value="삭제하기" onclick="del()">
        </div>
        </form>
      </section>


    <%@ include file="../include/footer.jsp" %>

    <!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>

</body>
</html>