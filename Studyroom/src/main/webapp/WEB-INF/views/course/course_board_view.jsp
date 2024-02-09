<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="resources/js/HttpRequest.js"></script>
	<script>
		function back() {
			location.href='course_board_list?page=${param.page}';
		}
		function del() {			
			if (!confirm("삭제하시겠습니까?")) {
				return;
			}
			
			let url = "course_board_delete";
			let param = "id=${dto.id}";
			
			sendRequest(url, param, resultFn, "POST");
			
			// 동작 테스트용
// 			let url = "ajax_test";
// 			let param = "id=1";
// 			sendRequest(url, param, resultFn, "POST");
		}
			
		function resultFn() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText;
				let json = (new Function('return' + data))();
				
				if(json[0].result == 'yes') {
					alert("성공적으로 삭제했습니다.");
					location.href = "course_board_list";
				} else {
					alert("삭제를 실패했습니다.");
				}
			}
		}
	
		function modify() {
			location.href = "course_board_modify_form?id=${dto.id}&page=${param.page}";
		}
	</script>
</head>

<body>
    <table border="1" align="center">	
		<caption>::게시글 상세보기::</caption>
		<tr>
			<th>제목</th>
			<td>${dto.title}</td>
		</tr>
		<tr>
			<th>게시 날짜</th>
			<td>${dto.register_date}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="500px" height="200px"><pre>${dto.content}</pre></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td>
                <a href="#">${dto.file_name}</a>
            </td>
		</tr>
		<tr>
			<td colspan="2">
                <input id="back_btn" type="button" value="뒤로 돌아가기" onclick="back()"></input>
				<input id="delete_btn" type="button" value="글 삭제하기" onclick="del()"></input>
				<input id="modify_btn" type="button" value="글 수정하기" onclick="modify()"></input>
			</td>
		</tr>
	</table>
	
	
</body>
</html>