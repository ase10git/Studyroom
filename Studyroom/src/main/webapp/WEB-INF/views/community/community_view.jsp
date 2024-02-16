<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.input-box {
    margin-top: 5px;
    padding : 7px 15px;
    width : 100%;
    background-color: white;
    border: 1px solid #e3e2e2;
    border-radius: 3px;
***REMOVED***
.input{
    margin: 0;
    padding: 5px;
    width: 100%;
    border: none;
    outline: none;
***REMOVED***
</style>

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
		
		
		<!-- 답글 관련 -->
		
		<form action="community_reply" name="f" method="post">
		<input type="hidden" name="id"	 value="${param.id ***REMOVED***">
		<input type="hidden" name="page" value="${param.page***REMOVED***">	
		
		<!-- 답글 보여주기 -->
		<c:forEach var="dto" items="${reply_list***REMOVED***">
      	<tr>
         <td align="center">${dto.id***REMOVED***</td>
         
         <!-- 댓글일 경우 들여쓰기 -->
         <td><c:forEach begin="1" end="${dto.depth***REMOVED***">&nbsp;</c:forEach>
         <!-- 댓글기호 -->
       <!-- <c:if test="${ dto.depth ne 0 ***REMOVED***">ㄴ</c:if> -->
            
         <!-- 삭제되지 않은 글이라면 출력가능 -->
         <c:if test="${dto.del_flag ne -1***REMOVED***">
		 <font color="black">${dto.content***REMOVED***</font>
         </c:if>
            
         <!-- 삭제된 게시물은 클릭할 수 없도록 처리 -->
         <c:if test="${dto.del_flag eq -1 ***REMOVED***">
         <font color="gray">${dto.content ***REMOVED***</font>
         </c:if>
         </td>
         <td>${dto.nickname ***REMOVED***</td>
         
         <c:if test="${dto.del_flag ne -1 ***REMOVED***">
            <td>${fn:split(dto.register_date,' ')[0]***REMOVED***</td>
         </c:if>
         
         <!-- 삭제된 게시물은 unKnown으로 표시 -->
         <c:if test="${dto.del_flag eq -1 ***REMOVED***">
            <td>unknown</td>
         </c:if>
      </tr>   
      
      
      </c:forEach>
		<tr>
			<td colspan="4" rows="30">
			<!-- 답변 -->
				<div class="input-box">
				<textarea name="content" class="input"  style="resize:none;"></textarea>
				</div>		
				<c:if test="${dto.depth lt 1 ***REMOVED***">	
				<input type="button" value="답변 등록" onclick="reply()">
				</c:if>
			</td>
		</tr>	
		<tr>
			<td colspan="2">
			<!-- ************** 편집자 - css를 위한 이미지 제거 ***************** -->
			
				<!-- 추천하기 -->
				<input type="button" value="추천하기" onclick="like()">
				
				<!-- 목록보기 -->
				<input type="button" value="목록보기" onclick="location.href='community_list'">
				
				<!-- 삭제 -->
				<input type="button" value="삭제" onclick="del()">
				<!-- 수정 -->
				<input type="button" value="수정" onclick="modify()">	
			</td>
		</tr>	
	</table>
</body>
</html>

