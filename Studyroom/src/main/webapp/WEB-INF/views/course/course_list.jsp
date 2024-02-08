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
		function write() {
			location.href='course_insert_form';
		}
	</script>
</head>
<body>
    <table>
        <tr>
            <th>번호</th>
            <th>코스 이름</th>
            <th>강사 이름</th>
        </tr>
        
        <c:forEach var="dto" items="${list}">
            <tr>
                <td>${dto.id}</td>
                <td><a href="course_view?id=${dto.id}&page=${param.page}">${dto.title}</a></td>
                <td>${dto.instructor}</td>
            </tr>  
        </c:forEach>
    
        <tr>
            <td>
                <input id="insert_btn" type="button" value="코스 추가하기" onclick="write()">
            </td>
        </tr>
    </table>
</body>
</html>