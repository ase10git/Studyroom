<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function send() {
			f.submit();
	***REMOVED***
		
		function back() {
			location.href='course_board_list';
	***REMOVED***
	</script>
</head>
<body>
    <form action="course_board_insert" name="f" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="page" value="${param.page***REMOVED***">
		<!-- courseID를 넘겨야 함. 글 수정 시 현재 오류 발생 -->
		<table border="1" align="center">
			<caption>:::새 글 쓰기:::</caption>
			<tr>
				<th>제목</th>
				<td><input name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="50" style="resize:none;"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input name="file" type="file"></td>
			</tr>
            <tr>
                <td>
                    <input id="send_btn" type="button" value="글 등록하기" onclick="send()"></input>
                </td>
                <td>
                    <input id="back_btn" type="button" value="뒤로 돌아가기" onclick="back()"></input>
                </td>
            </tr>
		</table>
	</form>
</body>
</html>