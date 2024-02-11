<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">		
		function back() {
			location.href = "course_list";
	***REMOVED***
		
		function write_board() {
			location.href="course_board_insert_form?course_id=${course_id***REMOVED***";
	***REMOVED***
	</script>
</head>
<body>
	<table>
        <tr>
            <th>코스 이름</th>
            <th>강사 이름</th>
            <th>기간<th>
        </tr>
        <tr>
            <td>${course_dto.title***REMOVED***</td>
            <td>${course_dto.instructor***REMOVED***</td>
            <td>${fn:split(course_dto.start_date, " ")[0]***REMOVED*** ~ ${fn:split(dto.end_date, " ")[0]***REMOVED***</td>
        </tr>
        <tr>
        	<td colspan="3"><pre>${course_dto.summary***REMOVED***</pre></td>
        </tr>
    </table>
	
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>게시 날짜</th>
        </tr>
        
        <c:forEach var="dto" items="${list***REMOVED***">
            <tr>
                <td>${dto.id***REMOVED***</td>
                <td><a href="course_board_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***">${dto.title***REMOVED***</a></td>
                <td>${dto.register_date***REMOVED***</td>
            </tr>  
        </c:forEach>
    
        <tr>
            <td>
                <input id="insert_btn" type="button" value="글 작성하기" onclick="write_board()">
            </td>
            <td>
                <input id="back_btn" type="button" value="뒤로 가기" onclick="back()">
            </td>
        </tr>
    </table>

</body>
</html>