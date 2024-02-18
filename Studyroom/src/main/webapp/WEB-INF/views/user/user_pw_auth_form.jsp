<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 입력 페이지</title>
	<script>
		function pwCheck(){
		let pwd = ${dto.pwd}; //원본비밀번호
		let c_pwd = document.getElementById("c_pwd").value;
		
		if(pwd != c_pwd){
			alert("비밀번호 불일치");
			return;
		}
		
		var url = "authenticate";
		var param = "id=${dto.id}&pwd="+encodeURIComponent(pwd)
		
		sendRequest(url,param,pwCheck2,"post");
	}
	
	function pwCheck2(response){
		if(xhr.readyState == 4 && xhr.status == 200){
		    if (response === "success") {
		        window.location.href = "user_modify_form";
		    } else {
		        alert("비밀번호가 틀렸습니다.");
		    }
			
		}
	}
	</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>비밀번호</th>
			<td><input id="c_pwd" type="password"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="다음" onclick="pwCheck1()">
				<input type="button" value="취소" onclick="location.href='user_view'">
			</td>
		</tr>
	</table>
</body>
</html>