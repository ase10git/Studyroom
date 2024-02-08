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
			location.href='course_board_list?page=${param.page***REMOVED***';
	***REMOVED***
		function del() {			
			if (!confirm("삭제하시겠습니까?")) {
				return;
		***REMOVED***
			
			let url = "course_board_delete";
			let param = "id=${dto.id***REMOVED***";
			
			sendRequest(url, param, resultFn, "POST");
			
			// 동작 테스트용
// 			let url = "ajax_test";
// 			let param = "id=1";
// 			sendRequest(url, param, resultFn, "POST");
	***REMOVED***
			
		function resultFn() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText;
				let json = (new Function('return' + data))();
				
				if(json[0].result == 'yes') {
					alert("성공적으로 삭제했습니다.");
					location.href = "course_board_list";
			***REMOVED*** else {
					alert("삭제를 실패했습니다.");
			***REMOVED***
		***REMOVED***
	***REMOVED***
	
		function modify() {
			location.href = "course_board_modify_form?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
	***REMOVED***
	</script>
</head>

<body>
    <table border="1" align="center">	
		<caption>::게시글 상세보기::</caption>
		<tr>
			<th>제목</th>
			<td>${dto.title***REMOVED***</td>
		</tr>
		<tr>
			<th>게시 날짜</th>
			<td>${dto.register_date***REMOVED***</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="500px" height="200px"><pre>${dto.content***REMOVED***</pre></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td>
                <a href="#">${dto.file_name***REMOVED***</a>
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