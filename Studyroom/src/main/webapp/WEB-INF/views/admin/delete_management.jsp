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

	<script type="text/javascript" src="resources/js/HttpRequest.js"></script>

</head>
<body>
    <section class="sec user">
        <div class="container">
        <h2>수강생 삭제 요청</h2>
          <div class="row gy-4">
            <div class="box col-12">
                <table>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>번호</th>
                        <th>수강생 이름</th>
                    </tr>
                </table>
            </div>
          </div>
        </div>
      </section>

      <!-- <section class="sec course">
        <div class="container">
        <h2>코스 삭제 요청</h2>
          <div class="row gy-4">
            <div class="box col-12">
                <table>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>번호</th>
                        <th>코스 이름</th>
                        <th>강사 이름</th>
                        <th>기간</th>
                    </tr>
                	<c:forEach var="course_dto" items="${course_list***REMOVED***">
	                    <tr>
                            <td><input type="checkbox"></td>
                            <td><span>${course_dto.id***REMOVED***</span></td>
                            <td><span>${course_dto.title***REMOVED***</span></td>
                            <td><span>${course_dto.instructor***REMOVED***</span></td>
                            <td><span>${fn:split(course_dto.start_date, " ")[0]***REMOVED*** ~ ${fn:split(course_dto.end_date, " ")[0]***REMOVED***</span></td>
	                    </tr>
                    </c:forEach>
                </table>
            </div>
          </div>
        </div>
      </section> -->

      <section class="sec course_board">
        <div class="container">
        <h2>코스 공지글 삭제 요청</h2>
          <div class="row gy-4">
            <div class="box col-12">
                <table>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>번호</th>
                        <th>코스 번호</th>
                        <th>등록 날짜</th>
                    </tr>
                	<c:forEach var="course_board_dto" items="${course_board_list***REMOVED***">
	                    <tr>
                            <td><input type="checkbox"></td>
                            <td><span>${course_board_dto.id***REMOVED***</span></td>
                            <td><span>${course_board_dto.course_id***REMOVED***</span></td>
                            <td><span>${course_board_dto.title***REMOVED***</span></td>
                            <td><span>${fn:split(course_board_dto.register_date, " ")[0]***REMOVED***</span></td>
	                    </tr>
                    </c:forEach>
                </table>
            </div>
          </div>
        </div>
      </section>

      <section class="sec community">
        <div class="container">
        <h2>커뮤니티 글 삭제 요청</h2>
          <div class="row gy-4">
            <div class="box col-12">
                <table>
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>번호</th>
                        <th>커뮤니티 번호</th>
                        <th>제목</th>
                    </tr>
                </table>
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