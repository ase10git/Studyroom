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
	
	/* 로고 */
	#logo { 
		float:left;   /* 왼쪽으로 플로팅 */ 
		width:250px;   /*  너비 */ 
		height:100px;   /* 높이 */
		line-height:100px;  /* 세로로 중간에 맞춤 - 줄간격을 높이 값과 같게 */
		padding-left:150px;  /* 왼쪽에 여백 */
***REMOVED***
	
	#logo h1 {
		font-family:fantasy;
		font-weight:300;
		font-size:40px;   /* 글자 크기 */
		color:rgb(255,255,140);   /* 글자 색*/
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
			<th>조회수</th>
		</tr>
		<c:forEach var="dto" items="${list ***REMOVED***">
			<tr>
				<td>${dto.id ***REMOVED***</td>
				<td>${dto.title ***REMOVED***</td>
				<td>관리자</td> <!-- 작성자는 관리자로 표시되게 -->
				<td>${dto.register_date ***REMOVED***</td>
				<td>${dto.readhit ***REMOVED***</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>