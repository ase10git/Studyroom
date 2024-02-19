<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/style_with_table.css">
	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.1.0/uicons-bold-rounded/css/uicons-bold-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
    
 	<script type="text/javascript">
 		function write_board() {
 			location.href = "community_insert_form?page=${param.page}";
 		}
 	</script>
</head>

<body>

	<%@ include file="../include/menu.jsp" %>

   <section class="sec community">
      <div class="container">
       <h1 class="title text-center">커뮤니티</h1>
        <div class="row gy-4">
			<div class="col box col-12 d-flex justify-content-center">
				<table class="board text-center">
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>조회수</th>
						<th>추천</th>
						<th>작성일</th>
					</tr>

					<c:forEach var="dto" items="${list}">
						<c:if test="${dto.depth eq 0 and dto.del_flag eq 0}">
							<tr>
								<td>${dto.id}</td>
								<c:choose>
									<c:when test="${dto.nickname ne null}">
										<td>${dto.nickname}</td>
									</c:when>
									<c:otherwise>
										<td>수강생</td>
									</c:otherwise>
								</c:choose>
								<td>
									<a href="community_view?id=${dto.id}&page=${param.page}">${dto.title}</a>
								</td>
								<td>${dto.readhit}</td>
								<td>${dto.likehit}</td>
								<td>${fn:split(dto.register_date,' ')[0]}</td>       
							</tr>   
						</c:if>
					</c:forEach>
				</table>
			</div>
        </div>
        <div class="row gy-4">
        	<div class="menu-tab">
        		${pageMenu}
        		<div class="d-flex justify-content-end">
					<input type="button" class="btn btn-primary" class="btn write-btn" value="글쓰기" onclick="write_board()">
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