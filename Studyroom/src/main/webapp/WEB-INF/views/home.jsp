<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
</head>
<body>
	
	<!-- Bootstrap 구조 샘플 
		샘플을 보고 원하는 구조를 선택해서 사용해주세요
		창 사이즈를 변경하면 컴포넌트 크기도 자동으로 바뀝니다
	-->
	<!-- 기본 구조(gt 박스 없어도 됨) -->
  <section class="sec event">
    <div class="container">
     <h1>test home</h1>
      <div class="row gy-4">
        <div class="box col-12 col-md-6">
          <div class="gt">
          
			<!-- 각 카테고리별 테스트용 이동 버튼 -->
			<div class="test-btn">
				<input type="button" value="회원정보" onclick="location.href='user_view';">
			    <input type="button" value="삭제관리" onclick="location.href='delete_management';">
			    <input type="button" value="코스" onclick="location.href='course_list';">
			    <input type="button" value="커뮤니티" onclick="location.href='community_list';">
			    <input type="button" value="캘린더" onclick="location.href='calendar_list';">
			</div>
			
          </div>
        </div>
      </div>
    </div>
  </section>

	
	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>