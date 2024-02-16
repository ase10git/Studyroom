<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style type="text/css">
	.menu ::before{
	    font-family: 'Material Icons';
	    font-size: 1.5em;
	    float: left;
	    clear: left;
***REMOVED***
	
	.menu label::before{ content: '\e5d2'; ***REMOVED***
	.menu li:nth-child(1) a::before{ content: '\f02e'; ***REMOVED***
	.menu li:nth-child(2) a::before{ content: '\e8d6'; ***REMOVED***
	.menu li:nth-child(3) a::before{ content: '\e88a'; ***REMOVED***
	.menu li:nth-child(4) a::before{ content: '\e8cc'; ***REMOVED***
	.menu li:nth-child(5) a::before{ content: '\e87d'; ***REMOVED***
	.menu li:nth-child(6) a::before{ content: '\e8b8'; ***REMOVED***
	
	#expand-menu { /* 체크박스 폼 요소 감춤 */
    	display: none;
***REMOVED***
	
	#expand-menu:checked ~ ul { /* 체크박스 체크되었으면 메뉴 목록 표시 - 반응형 표시용 */
	    display: block;
	    height: auto;
***REMOVED***
	
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
***REMOVED***
	
	.menu ul {
	    list-style: none;
	    margin: 0;
	    padding: 0;
***REMOVED***
	
	.menu a, .menu > label {
	    display: block;
	    height: 25px;
	    padding: 8px;
	    cursor: pointer;
	    color: #fff;
	    text-decoration: none;
***REMOVED***
	
	.menu a:hover {
    	color: #000;
***REMOVED***
	
	.menu ul li:hover, .menu > label:hover {
	    background-color: #fff;
	    color: #000;
	    border-radius: 10px;
***REMOVED***
	
	.menu div {
	    line-height: 1.5;
	    font-size: 1em;
	    font-family: 'Noto Sans KR';
	    padding: 0 0 0 50px; /* 아이콘과 텍스트 사이 여백 */
***REMOVED***
	
	@media screen and (max-width:1023px) {
    	.menu { /* 1단계 */
        	width: 60px;
    ***REMOVED***
***REMOVED***
	
	@media screen and (max-width:560px) {
	    .menu #expand-menu:not(:checked) ~ ul { /* 2단계 */
	        display: none;
	    ***REMOVED***
***REMOVED***
	
	.menu div {
	    position: absolute; /* 절대 위치로 텍스트 고정 */
	    left: 50px;
	    line-height: 1.5;
	    font-size: 1em;
	    font-family: 'Noto Sans KR';
	    padding: 0 0 0 20px; /* 패딩 20p로 축소 */
***REMOVED***
	
	.menu #expand-menu:not(:checked) ~ ul { /* 데스크탑 화면에서도 메뉴를 접었더 펼칠 수 있음 */
   		display: none;
***REMOVED***
</style>
</head>
<body>
	<div class="menu">
		<ul class="menu-bar">
			<li> <a href='/' class="item logo"><div>Logo</div></a>
			<li><a href='/' class="item course"><div>코스</div></a>
			<li><a href='/' class="item community"><div>커뮤니티</div></a>
			<li><a href='/' class="item calendar"><div>캘린더</div></a>
		</ul>
	</div>
</body>
</html>