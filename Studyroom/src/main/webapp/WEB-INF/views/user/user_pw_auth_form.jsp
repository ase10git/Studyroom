<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 입력 페이지</title>
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
    <script src="resources/js/HttpRequest.js"></script>
	<script>
		function pwCheck1(){
		let c_pwd = document.getElementById("c_pwd").value;
		
		if(c_pwd==''){
			alert('비밀번호를 입력하세요')
			return;
		}
		
		var action = "${action}";
		var url = "authenticate";
		var param = "id=${dto.id}&pwd="+encodeURIComponent(c_pwd)+"&action="+encodeURIComponent(action);
		
		sendRequest(url,param,pwCheck2,"post");
	}
	
	function pwCheck2(response){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			var json = (new Function('return' + data))();
			
			if(json[0].param == 'no_pwd'){
				alert('비밀번호가 틀립니다.');
			} else {
				 var action = json[0].action;
	            if (action === 'update') {
	                location.href = 'user_modify_form?id=${dto.id}';
	            } else if (action === 'delete') {
	                location.href = 'user_delete_confirm?id=${dto.id}';
	            } else {
	                alert('Invalid action');
	            }
			}
		}
	}
	</script>
</head>

<body>

	<%@ include file="../include/menu.jsp" %>

	<div class="sec auth">
		<div class="container">
			<h2 class="title text-center">사용자 인증</h2>
			<div class="row">
				<div class="col box col-12 d-flex justify-content-center align-items-center">
					<table>
						<tr>
							<th>비밀번호</th>
							<td><input id="c_pwd" class="form-control" type="password"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" class="btn btn-primary" value="다음" onclick="pwCheck1()">
								<input type="button" class="btn btn-dark" value="취소" onclick="location.href='user_view'">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>  

	<%@ include file="../include/footer.jsp" %>

	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>