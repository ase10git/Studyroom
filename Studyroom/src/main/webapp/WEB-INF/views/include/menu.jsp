<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
	
	.menu {
	    display: block;
	    width: 200px;
	    background-color: #000;
	    color: #fff;
	    border-radius: 20px;
	    padding: 10px;
	    box-sizing: border-box;
	    overflow: hidden; /* 반응형 애니메이션용 */
	    transition: all 0.5s ease; /* 반응형 애니메이션 */
	}
	
	.menu ul {
	    list-style: none;
	    margin: 0;
	    padding: 0;
	}
	
	.menu a, .menu > label {
	    display: block;
	    height: 25px;
	    padding: 8px;
	    cursor: pointer;
	    color: #fff;
	    text-decoration: none;
	}
	
	.menu a:hover {
    	color: #000;
	}
	
	.menu ul li:hover, .menu > label:hover {
	    background-color: #fff;
	    color: #000;
	    border-radius: 10px;
	}
	
	.menu div {
	    line-height: 1.5;
	    font-size: 1em;
	    font-family: 'Noto Sans KR';
	    padding: 0 0 0 50px; /* 아이콘과 텍스트 사이 여백 */
	}

	.menu div {
	    position: absolute; /* 절대 위치로 텍스트 고정 */
	    left: 50px;
	    line-height: 1.5;
	    font-size: 1em;
	    font-family: 'Noto Sans KR';
	    padding: 0 0 0 20px; /* 패딩 20p로 축소 */
	}
	
	.menu #expand-menu:not(:checked) ~ ul { /* 데스크탑 화면에서도 메뉴를 접었더 펼칠 수 있음 */
   		display: none;
	}
</style>
</head>
<body>
	<div class="menu">
		<ul class="menu-bar">
			<li> <a href='announcement_list' class="item logo"><img src="${pageContext.request.contextPath}/resources/img/logo_temp.png" alt="스터디룸 로고"></a></li>
			<li><a href='#' class="item user-info"><span>내 정보</span></a></li>
			<li><a href='course_list' class="item course"><span>코스</span></a></li>
			<li><a href='community_list' class="item community"><span>커뮤니티</span></a></li>
			<li><a href='calendar_list' class="item calendar"><span>캘린더</span></a></li>
		</ul>
	</div>
</body>
</html>