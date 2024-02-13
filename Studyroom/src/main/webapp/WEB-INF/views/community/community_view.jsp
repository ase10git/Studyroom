<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/HttpRequest.js"></script>
<script type="text/javascript">
	function del(){
		if(!confirm("삭제하시겠습니까?")){
			return;
	***REMOVED***

		var url = "community_delete";
		var param = "id=${dto.id***REMOVED***"
		
		sendRequest(url,param,delCheck,"post");
***REMOVED***
	
	function delCheck(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = xhr.responseText;
			
			var json = (new Function('return' + data))();
			
			if(json[0].result == 'yes'){
				alert('삭제 성공')
				location.href='community_list?page=${param.page***REMOVED***';
		***REMOVED*** else {
				alert('삭제 실패')
		***REMOVED***
	***REMOVED***
***REMOVED***
	
	function reply(){
		location.href='reply_form?id=${dto.id***REMOVED***&page=${param.page***REMOVED***';
***REMOVED***
	function modify(){
		//원본 비밀번호와 내가 작성한 비밀번호가 일치할때만 수정이 가능하도록 
		/* let ori_pwd = f.ori_pwd.value;
		let pwd = f.pwd.value;
		
		if(pwd==''){
			alert("비밀번호를 입력하세요")
			return;
	***REMOVED***
		
		if(ori_pwd != pwd){
			alert('비밀번호 불일치');
			return;
	***REMOVED*** */
		location.href="community_modify_form?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
***REMOVED***
	
</script>
</head>
<body>
	<table border="1">
		<caption>:::게시글 상세보기:::</caption>
		<tr>
			<th>제목</th>
			<td>${dto.title ***REMOVED***</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.nickname ***REMOVED***</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.register_date ***REMOVED***</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><img src="${pageContext.request.contextPath***REMOVED***/resources/upload/${dto.file_name***REMOVED***" alt="이미지"></td>
		<tr>
			<th>내용</th>
			<td width="500px" height="200px"><pre>${dto.content***REMOVED***</pre></td>
		</tr>
		<tr>
			<td colspan="2">
			<!-- ************** 편집자 - css를 위한 이미지 제거 ***************** -->
				<!-- 목록보기 -->
				<input type="button" value="목록보기" onclick="location.href='community_list'">
				<!-- 답변 -->
				<c:if test="${dto.depth lt 1 ***REMOVED***">
					<input type="button" value="답변" onclick="reply()">
				</c:if>
				<!-- 삭제 -->
				<input type="button" value="삭제" onclick="del()">
				<!-- 수정 -->
				<input type="button" value="수정" onclick="modify()">
			</td>
		</tr>
	</table>
</body>
</html>

