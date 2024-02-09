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
		}
		
		function back() {
			location.href='course_list';
		}
	</script>
</head>
<body>
    <form action="course_insert" name="f" method="POST">
		<input type="hidden" name="page" value="${param.page}">
		<table border="1" align="center">
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
</body>
</html>