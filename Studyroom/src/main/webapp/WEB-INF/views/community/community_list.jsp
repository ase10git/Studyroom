<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
<style>
   a{text-decoration: none;***REMOVED***
   table{border-collapse: collapse; width: 700px;***REMOVED***
</style>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>

   <section class="sec event">
      <div class="container">
       <h1>test home</h1>
        <div class="row gy-4">
          <div class="box col-12 col-md-6">
            <table border="1">
               <tr>
                  <!-- 세션에 값이 있으면 로그아웃 버튼이, 세션이 없으면 로그인, 회원가입 버튼이 보이게 하자 -->
                  <td colspan="5" align="right">
                  <c:choose>
                     <c:when test="${empty id ***REMOVED***">
                        <input id="" name="" type="button" value="로그인" onclick="location.href='login'">
                        <input id="" name="" type="button" value="회원가입" onclick="location.href='register'">
                     </c:when>
                     <c:otherwise>
                        <input id="" name="" type="button" value="로그아웃" onclick="location.href='logout'">
                     </c:otherwise>
                  </c:choose>
                  
                  
                  
               </tr>
               <tr>
                  <td colspan="5"><img src="resources/img/title_04.gif"></td>
               </tr>
               <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>조회수</th>
               </tr>
               <c:forEach var="dto" items="${list***REMOVED***">
               <tr>
                  <td align="center">${dto.id***REMOVED***</td>
                  <!-- 댓글일 경우 들여쓰기 -->
                  <td>
                     <c:forEach begin="1" end="${dto.depth***REMOVED***">
                        &nbsp;
                     </c:forEach>
                     <!-- 댓글기호 -->
                     <c:if test="${ dto.depth ne 0 ***REMOVED***">ㄴ</c:if>
                     
                     <!-- 삭제되지 않은 글이라면 출력가능 -->
                     <c:if test="${dto.del_flag ne -1***REMOVED***">
                        <a href="community_view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***">
                           <font color="black">${dto.title***REMOVED***</font>
                        </a>
                     </c:if>
                     
                     
                     <!-- 삭제된 게시물은 클릭할 수 없도록 처리 -->
                     <c:if test="${dto.del_flag eq -1 ***REMOVED***">
                        <font color="gray">${dto.title ***REMOVED***</font>
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
                  <td>${dto.readhit ***REMOVED***</td>
               </tr>   
               </c:forEach>
               <tr>
                  <td colspan="5" align="center">
                     ${pageMenu ***REMOVED***
                  </td>
               </tr>
               <tr>
                  <td colspan="5" align="right">
                     <img src="resources/img/btn_reg.gif" 
                        onclick="location.href='community_insert_form?page=${param.page***REMOVED***'" 
                        style="cursor:pointer;">
                  </td>
               </tr>
            </table>
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