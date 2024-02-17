<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/community_view.css">
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
		
		
		if(confirm("답글을 작성하시겠습니까?")){    //확인 하고 난 후
			f.submit();
			//location.href='community_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***';
		 ***REMOVED***else{   //취소
		     return;
		 ***REMOVED***
	
		//location.href='reply_form?id=${dto.id***REMOVED***&page=${param.page***REMOVED***';
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
	function like(){
		alert('추천되었습니다.');
***REMOVED***
</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec event">
		<div class="container">
			<h1>커뮤니티 글 상세보기</h1>
			<div class="row gy-4">

				<div class="col box">
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
					</table>
				</div>	

				<!-- 답글 보여주기 -->
				<div class="col box">
					<c:forEach var="dto" items="${reply_list***REMOVED***">
						<div class="reply_box">
							<c:choose>
								<c:when test="${dto.del_flag eq -1 ***REMOVED***">
									<div class="info">
										<span class="nickname">삭제됨</span>
										<span class="register_date">삭제됨</span>
									</div>
								</c:when>
								<c:when test="${dto.del_flag eq 0 ***REMOVED***">
									<div class="info">
										<span class="nickname">${dto.nickname***REMOVED***</span>
										<span class="register_date">${fn:split(dto.register_date,' ')[0]***REMOVED***</span>
									</div>
									<p class="reply_content">${dto.content***REMOVED***</p>
								</c:when>
							</c:choose>
						</div>
					</c:forEach>
				</div>		

				<div class="col box">
					<form action="community_reply" name="f" method="post">
						<input type="hidden" name="id"	 value="${param.id ***REMOVED***">
						<input type="hidden" name="page" value="${param.page***REMOVED***">	
							<!-- 답변 -->
							<textarea name="content" class="input"  style="resize:none;"></textarea>	
							<c:if test="${dto.depth lt 1 ***REMOVED***">	
								<input type="button" value="답변 등록" onclick="reply()">
							</c:if>
					</form>
				</div>

				<div class="col box">
					<div class="btn-wrap">
						<!-- 추천하기 -->
						<input type="button" value="추천하기" onclick="like()">
						
						<!-- 목록보기 -->
						<input type="button" value="목록보기" onclick="location.href='community_list'">
						
						<!-- 삭제 -->
						<input type="button" value="삭제" onclick="del()">
						<!-- 수정 -->
						<input type="button" value="수정" onclick="modify()">	
					</div>
				</div>

			</div>
		</div>
	</section>


		<!-- bootstrap script -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
		crossorigin="anonymous"></script>

</body>
</html>

