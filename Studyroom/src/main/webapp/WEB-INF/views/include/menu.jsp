<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
	<link rel="stylesheet" href="resources/css/menu.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-straight/css/uicons-solid-straight.css'>
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.1.0/uicons-regular-rounded/css/uicons-regular-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
</head>

<body>
	<div class="menu">
		<ul class="menu-bar">
			<li><a href='announcement_list' class="item logo"><img class="logo" src="${pageContext.request.contextPath}/resources/img/logo_temp.png" alt="스터디룸 로고"></a></li>
			<li><a href='user_view' class="item user-info"><i class="fi fi-ss-user"></i><span>내 정보</span></a></li>
			<li><a href='course_list' class="item course"><i class="fi fi-ss-book"></i><span>코스</span></a></li>
			<li><a href='community_list' class="item community"><i class="fi fi-ss-users-alt"></i><span>커뮤니티</span></a></li>
			<li><a href='calendar_list' class="item calendar"><i class="fi fi-rr-calendar-lines-pen"></i><span>캘린더</span></a></li>
		</ul>
	</div>
</body>
</html>