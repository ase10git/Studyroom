<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 추가</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
    crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/main.css">
	
	<script type="text/javascript">
		function send() {
			// date : YYYY-MM-DD 형식으로 들어옴
			// mapper에서 To_DATE()로 형식변환

			f.submit();
	***REMOVED***
		
		function back() {
			location.href='course_list';
	***REMOVED***
	</script>
</head>
<body>
	<section class="sec">
		<div class="container">
		 <h1>test home</h1>
		  <div class="row gy-4">
			<div class="box col-12 col-md-6">
			  <div class="gt">
				<form action="course_insert" name="f" method="POST">
					<input type="hidden" name="page" value="${param.page***REMOVED***">
					<table>
						<caption>:::새 코스 추가:::</caption>
						<tr>
							<th>코스 이름</th>
							<td><input name="title"></td>
						</tr>
						<tr>
							<th>강사</th>
							<td><input name="instructor"></td>
						</tr>
						<tr>
							<th>코스 설명</th>
							<td><textarea name="summary" rows="5" cols="50" style="resize:none;"></textarea></td>
						</tr>
						<tr>
							<th>코스 시작일</th>
							<td><input name="start_date" type="date"></td>
						</tr>
						<tr>
							<th>코스 종료일</th>
							<td><input name="end_date" type="date"></td>
						</tr>
						<tr>
							<td>
								<input id="send_btn" type="button" value="코스 등록하기" onclick="send()"></input>
							</td>
							<td>
								<input id="back_btn" type="button" value="뒤로 돌아가기" onclick="back()"></input>
							</td>
						</tr>
					</table>
				</form>
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