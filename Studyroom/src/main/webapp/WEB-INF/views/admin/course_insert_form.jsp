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
	<link rel="stylesheet" href="resources/css/style_with_table.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function send() {
			// date : YYYY-MM-DD 형식으로 들어옴
			// mapper에서 To_DATE()로 형식변환

			f.submit();
		}
		
		function back() {
			location.href='course_list';
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec course-insert">
		<div class="container">
		 <h1 class="title text-center">새 코스 추가</h1>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<form action="course_insert" name="f" method="POST">
					<input type="hidden" name="page" value="${param.page}">
					<table>
						<tr>
							<th>코스 이름</th>
							<td><input name="title" class="form-control"></td>
						</tr>
						<tr>
							<th>강사</th>
							<td><input name="instructor" class="form-control"></td>
						</tr>
						<tr>
							<th>코스 설명</th>
							<td><textarea name="summary" class="form-control" rows="5" cols="50" style="resize:none;"></textarea></td>
						</tr>
						<tr>
							<th>코스 기간</th>
							<td class="d-flex justify-content-center">
								<div class="col-8 d-flex">
									<input name="start_date" type="date" class="form-control">
									<input name="end_date" type="date" class="form-control">
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="d-flex justify-content-end">
									<input id="send_btn" type="button" class="btn btn-primary" value="코스 등록하기" onclick="send()"></input>
									<input id="back_btn" type="button" class="btn btn-light" value="뒤로 돌아가기" onclick="back()"></input>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		  </div>
		</div>
	  </section>

	<%@ include file="../include/footer.jsp" %>

	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>