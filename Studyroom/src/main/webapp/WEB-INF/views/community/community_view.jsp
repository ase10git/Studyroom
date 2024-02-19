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
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/style_with_table.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
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
			if(!confirm("답글을 작성하시겠습니까?")) { // 작성 취소
				return;
		***REMOVED***else{ // 전송
				f.submit();
		***REMOVED***
	***REMOVED***
		
		function modify(){
			// 세션에서 정보 가져와서 비교 필요
			location.href="community_modify_form?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
	***REMOVED***
		
		function like(){
			
			if("${user_like***REMOVED***"==1){
				alert('이미 추천했습니다.');
				return
		***REMOVED***
			
			location.href="community_like?id=${dto.id***REMOVED***&page=${param.page***REMOVED***";
			alert('추천되었습니다.');
			
	***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	<section class="sec community">
		<div class="container">
			<h2 class="title text-center">${dto.title ***REMOVED***</h2>
			<div class="row gy-4">
				<div class="col box col-12 d-flex justify-content-center">
					<table class="community-box">
						<tr>
							<th>작성자</th>
							<c:choose>
								<c:when test="${dto.nickname ne null***REMOVED***">
									<td>${dto.nickname***REMOVED***</td>
								</c:when>
								<c:otherwise>
									<td>수강생</td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${dto.register_date ***REMOVED***</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
								<p>${dto.content***REMOVED***</p>
								<c:if test="${dto.file_name ne 'no_file'***REMOVED***">
									<img src="${pageContext.request.contextPath***REMOVED***/resources/upload/${dto.file_name***REMOVED***" alt="이미지">
								</c:if>
							</td>
						</tr>
					</table>
				</div>	
			</div>
			<div class="row gy-4">
				<!-- 답글 작성 -->
					<div class="accordion col box" id="insert-reply">
					  <div class="accordion-item">
					    <h2 class="accordion-header">
					      <button class="accordion-button collapsed" type="button" class="btn btn-primary" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
					        답글 작성하기
					      </button>
					    </h2>
					    <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#insert-reply">
					      <div class="accordion-body">
					    	<form action="community_reply" name="f" method="post">
								<input type="hidden" name="id"	 value="${param.id ***REMOVED***">
								<input type="hidden" name="page" value="${param.page***REMOVED***">	
									<!-- 답변 -->
									<textarea name="content" class="input"  style="resize:none;"></textarea>	
									<c:if test="${dto.depth lt 1 ***REMOVED***">	
										<input type="button" class="btn btn-primary" value="답변 등록" onclick="reply()">
									</c:if>
							</form>
					      </div>
					    </div>
					  </div>
					</div>
			</div>
			<div class="row gy-4">
				<!-- 답글 보여주기 -->
				<div class="col box reply">
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
					
					<div class="d-flex justify-content-end">
						<c:if test="${userId == dto.user_id***REMOVED***">
							<!-- 수정 -->
							<input type="button" class="btn btn-primary" value="수정" onclick="modify()">
							<!-- 삭제 -->
							<input type="button" class="btn btn-dark" value="삭제" onclick="del()">
						</c:if>	
							<c:if test="${userId != dto.user_id***REMOVED***">
								<!-- 추천하기 -->
								<input type="button" class="btn btn-primary" value="추천하기" onclick="like()">
							</c:if>	
							<!-- 목록보기 -->
							<input type="button" class="btn btn-light" value="목록보기" onclick="location.href='community_list'">
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="../include/footer.jsp" %>

		<!-- bootstrap script -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
		crossorigin="anonymous"></script>

</body>
</html>

