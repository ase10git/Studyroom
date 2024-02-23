<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
			<li><a href='announcement_list' class="item logo"><img class="logo" src="${pageContext.request.contextPath***REMOVED***/resources/img/logo_temp.png" alt="스터디룸 로고"></a></li>
			<li class="user-info"><a href='user_view?id=${sessionScope.dto.id***REMOVED***' class="btn btn-primary"><span class="nanum-gothic-regular">${sessionScope.dto.username***REMOVED***</span></a></li>
			<li class="course"><a href='course_list?id=${sessionScope.dto.id***REMOVED***' class="btn btn-primary"><span class="nanum-gothic-regular">코스</span></a></li>
			<li class="community"><a href='community_list' class="btn btn-primary"><span class="nanum-gothic-regular">커뮤니티</span></a></li>
			<li class="calendar"><a href='calendar_list' class="btn btn-primary"><span class="nanum-gothic-regular">캘린더</span></a></li>
			
			<c:if test="${sessionScope.dto.role eq 'admin'***REMOVED***">
			<li class="user-info"><a href='management_list' class="btn btn-primary"><span class="nanum-gothic-regular">사용자 관리</span></a></li>
			</c:if>
			<li class="user-info"><input type="button" class="btn btn-primary" id="logout" value="로그아웃" onclick="location.href='logout'"></li>
		</ul>
	</div>
</body>
</html>