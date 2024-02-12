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
	
	/* 로고 */
	#logo { 
		float:left;   /* 왼쪽으로 플로팅 */ 
		width:250px;   /*  너비 */ 
		height:100px;   /* 높이 */
		line-height:100px;  /* 세로로 중간에 맞춤 - 줄간격을 높이 값과 같게 */
		padding-left:150px;  /* 왼쪽에 여백 */
	}
	
	#logo h1 {
		font-family:fantasy;
		font-weight:300;
		font-size:40px;   /* 글자 크기 */
		color:rgb(255,255,140);   /* 글자 색*/
	}
</style>
</head>
<body>
	<nav>
		<tr>
			<td id="logo">
				<h1><a href="/">Studyroom</a></h1>
			</td>
		</tr>
		<ul>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li><a href="#">메뉴1</a>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li><a href="#">메뉴2</a>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li><a href="#">메뉴3</a>
			<li>&nbsp;</li>
			<li>&nbsp;</li>
			<li><a href="#">메뉴4</a>
		</ul>
	</nav>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.title }</td>
				<td>관리자</td> <!-- 작성자는 관리자로 표시되게 -->
				<td>${dto.register_date }</td>
				<td>${dto.readhit }</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>