<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f){
		f.action = "community_modify";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>
	<form>
	<input type="hidden" name="id" value="${dto.id }">
		<table border="1" align="center">
			<caption>:::게시글 수정:::</caption>
				<tr>
					<th>제목</th>
					<td><textarea rows="1" cols="50" name="title" style="resize:none;">${dto.title }</textarea></td>
				</tr>	
				<tr>
					<th>작성자</th>
					<td>${dto.nickname }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="50" name="content" style="resize:none;">${dto.content }</textarea></td>		
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="수정" onclick="send(this.form)">		
						<input type="button" value="취소" onclick="location.href='community_list'">
					</td>
				</tr>		
		</table>
	</form>
</body>
</html>