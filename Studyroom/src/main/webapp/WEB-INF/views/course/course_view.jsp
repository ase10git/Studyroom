<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코스 상세보기</title>
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
	<script type="text/javascript" src="resources/js/HttpRequest.js"></script>
	<script>
		function back() {
			let admin_id = ${sessionScope.dto.id};
			location.href = "course_list?id="+admin_id+"&page=${param.page}";
		}
	
		function del() {			
			if (!confirm("삭제하시겠습니까?")) {
				return;
			}
			
			let url = "course_delete";
			let param = "id=${dto.id}";
			
			sendRequest(url, param, resultFn, "POST");
			
		}
			
		function resultFn() {
			let admin_id = ${sessionScope.dto.id};
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText;
				let json = (new Function('return' + data))();
				
				if(json[0].result == 'yes') {
					alert("성공적으로 삭제했습니다.");
					location.href = "course_list?id="+admin_id;
				} else {
					alert("삭제를 실패했습니다.");
				}
			}
		}
	
		function modify() {
			location.href = "course_modify_form?id=${dto.id}&page=${param.page}";
		}
		
		function add_user() {
			// 전체 사용자 조회 페이지로 이동해서 동작
			location.href="#";
		}
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec course">
		<div class="container">
		 <h1 class="title text-center">코스 상세보기</h1>
		  <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<table>	
					<tr>
						<th>코스 이름</th>
						<td>${dto.title}</td>
					</tr>
					<tr>
						<th>강사</th>
						<td>${dto.instructor}</td>
					</tr>
					<tr>
						<th>코스 설명</th>
						<td>
							<p class="summary">${dto.summary}</p>
						</td>
					</tr>
					<tr>
						<th>기간</th>
						<td>${fn:split(dto.start_date, " ")[0]} ~ ${fn:split(dto.end_date, " ")[0]}</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="d-flex justify-content-center">
								<input id="modify_btn" type="button" class="btn btn-primary" value="코스 수정하기" onclick="modify()"></input>
								<input id="delete_btn" type="button" class="btn btn-danger" value="코스 삭제하기" onclick="del()"></input>
								<input id="back_btn" type="button" class="btn btn-dark" value="뒤로 돌아가기" onclick="back()"></input>
							</div>
						</td>
					</tr>
				</table>
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