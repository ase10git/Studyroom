<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		margin:0;   /* 마진 리셋 */
		padding:0;   /* 패딩 리셋 */
***REMOVED***
	
	a {
		text-decoration:none;  /* 텍스트 링크 밑줄 없애기 */ 
		color: inherit;
***REMOVED***
	
	a:link {
		text-decoration: none;
		color: inherit; 
***REMOVED***
	
	a:hover {
		text-decoration: underline;
		background-color: gray;
***REMOVED***
	
	ul {
  		list-style: none;
  		padding-bottom: 200px;
***REMOVED***
	

</style>
</head>
<body>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="dto" items="${list ***REMOVED***">
		
			<tr>
		
				<td>${dto.id ***REMOVED***</td>
				<td><a href="view?id=${dto.id***REMOVED***&page=${param.page ***REMOVED***">${dto.title ***REMOVED***</a></td>
				<td>관리자</td> <!-- 작성자는 관리자로 표시되게 -->
				<td>${dto.register_date ***REMOVED***</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>