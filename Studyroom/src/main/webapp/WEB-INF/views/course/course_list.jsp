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
		function move(id) {
			location.href = "course_board_list?course_id=" + id;
	***REMOVED***
		
		function management(id) {
			location.href = "course_view?id=" + id + "&page=${param.page***REMOVED***";	
	***REMOVED***
		
		function write_course() {
			location.href = "course_insert_form";
	***REMOVED***
	</script>
</head>
<body>
    <table>
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
                <td>
                	<input id="course_view_btn" type="button" value="코스 관리" onclick="management(${dto.id***REMOVED***)">
                </td>
            </tr>  
        </c:forEach>
    
        <tr>
            <td>
                <input id="insert_btn" type="button" value="코스 추가하기" onclick="write_course()">
            </td>
        </tr>
    </table>
</body>
</html>