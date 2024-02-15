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
	}
	
	a {
		text-decoration:none;  /* 텍스트 링크 밑줄 없애기 */ 
		color: inherit;
	}
	
	a:link {
		text-decoration: none;
		color: inherit; 
	}
	
	a:hover {
		text-decoration: underline;
		background-color: gray;
	}
	
	ul {
  		list-style: none;
  		padding-bottom: 200px;
	}
	

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
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.title }</td>
				<td>관리자</td> <!-- 작성자는 관리자로 표시되게 -->
				<td>${dto.register_date }</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>