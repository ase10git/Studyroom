<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>공지사항</title>
   

    <!-- bootstrap css -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>

    <!-- flaticon -->
    <link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <link rel="stylesheet" href="resources/css/announcement_list.css?after" />
    <link rel="stylesheet" href="resources/css/main.css?after" />
    
    <script type="text/javascript">
    	function insert() {
    		location.href = "course_board_insert_form?course_id=0";
    ***REMOVED***
    </script>
  </head>
  
  <body>
    <%@ include file="../include/menu.jsp" %>

    <!-- carousel -->
    <div class="section sec infocarousel-box">
      <div id="infocarousel" class="carousel slide container" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="4000">
            <img src="resources/img/announcementsIMG1.jpg" class="d-block w-100 " alt="테스트 이미지1" />
          </div>
          <div class="carousel-item" data-bs-interval="4000">
            <img src="resources/img/announcementsIMG2.jpg" class="d-block w-100" alt="테스트 이미지2" />
          </div>
          <div class="carousel-item" data-bs-interval="4000">
            <img  src="resources/img/announcementsIMG4_1.png" class="d-block w-100" alt="테스트 이미지5" />
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#infocarousel" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">이전</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#infocarousel" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">다음</span>
        </button>
      </div>
     </div>

    <section class="sec info">
      <div class="container">
        <div class="title-wrap d-flex justify-content-between" id="titleBoxs">
          <h1 class="titles nanum-gothic-regular">스터디룸 공지사항</h1>
          <c:if test="${role eq 'admin'***REMOVED***">
            <input type="button" class="btn btn-primary insert-btn" value="공지 추가하기" onclick="insert()">
          </c:if>
        </div>
        <div class="row g-4 d-flex justify-content-center">
          <c:forEach var="dto" items="${list***REMOVED***">
            <div class="gt col-4">
              <div class="col box card">
                <a href="view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***">
                    <c:if test="${dto.file_name ne 'no_file'***REMOVED***">
                      <img class="card-img-top w-80 h-60" src="${pageContext.request.contextPath***REMOVED***/resources/upload/${dto.file_name***REMOVED***" alt="공지사항 이미지">
					          </c:if>
                    <span class="card-title">${dto.title***REMOVED***</span>
                    <span class="card-text">${fn:split(dto.register_date, " ")[0]***REMOVED***</span>
                </a>
              </div>
            </div>
          </c:forEach>
          ${pageMenu***REMOVED***
        </div>
      </div>
    </section>

    <%@ include file="../include/footer.jsp" %>

    <!-- bootstrap script -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"></script>

  </body>
</html>
