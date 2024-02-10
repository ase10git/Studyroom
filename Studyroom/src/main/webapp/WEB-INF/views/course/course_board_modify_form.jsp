<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		// 첨부 파일 제거 요청 여부
		// 0 = false
		// 1 = true
		let file_delete_request = 0;
	
		// 페이지가 로드되면 첨부 파일 제거 요청 여부를 false로 설정
		window.onload = function () {
			file_delete_request = 0;
	***REMOVED*** 
		
		// 수정한 내용을 course_board_modify Mapping으로 전송
		function send() {
			f.action = "course_board_modify?id=${dto.id***REMOVED***&page=${param.page***REMOVED***&delete_flag="+file_delete_request;
			f.submit();
	***REMOVED***
		
		// 수정을 취소하고 공지글 상세보기 페이지로 이동
		function back() {
			location.href = "course_board_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
	***REMOVED***
		
		// 첨부파일 제거 요청 처리
		function delete_file() {
			let file_name = document.querySelector("#file_name");
			let name_value = file_name.innerHTML.trim();
			let file_delete_btn = document.querySelector("#file_delete_btn");
			
			// 첨부파일 제거를 요청할 때
			if (name_value == "${dto.file_name***REMOVED***") { 
				file_delete_request = 1; // 첨부파일 제거 요청 true
				file_name.innerHTML = ""; // 기존 첨부파일 이름 표시를 제거
				file_delete_btn.value = "첨부파일 제거 취소"; // 버튼 value 변경
				console.log(file_delete_request);
			// 첨부파일 제거 요청을 취소할 때
		***REMOVED*** else if (name_value == "") { 
				file_delete_request = 0; // 첨부파일 제거 요청 false
				file_name.innerHTML = "${dto.file_name***REMOVED***"; // 기존 첨부파일 이름 표시
				file_delete_btn.value = "첨부파일 제거"; // 버튼 value 변경
				console.log(file_delete_request);
		***REMOVED***
	***REMOVED***
	</script>
</head>
<body>
    <form name="f" method="POST" enctype="multipart/form-data">
		<table border="1" align="center">
			<caption>:::글 수정하기:::</caption>
			<tr>
				<th>제목</th>
				<td><input name="title" value="${dto.title***REMOVED***"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="50" style="resize:none;">${dto.content***REMOVED***</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="2">
					<span id="file_name">${dto.file_name***REMOVED***</span>
					<input id="file_delete_btn" type="button" value="첨부파일 제거" onclick="delete_file()">
					<input name="file" type="file">
				</td>
			</tr>
            <tr>
                <td>
                    <input id="send_btn" type="button" value="글 수정하기" onclick="send()"></input>
                </td>
                <td>
                    <input id="back_btn" type="button" value="뒤로 돌아가기" onclick="back()"></input>
                </td>
            </tr>
		</table>
	</form>
</body>
</html>