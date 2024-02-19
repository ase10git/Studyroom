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
    <link rel="stylesheet" href="resources/css/announcement_list.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    
    <script type="text/javascript">
    	function insert() {
    		location.href = "course_board_insert_form?course_id=0";
    	}
    </script>
  </head>
  
  <body>
    <%@ include file="../include/menu.jsp" %>

    <!-- carousel -->
      <div id="infocarousel" class="carousel slide container" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="3" aria-label="Slide 4"></button>
          <button type="button" data-bs-target="#infocarousel" data-bs-slide-to="4" aria-label="Slide 5"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="4000">
            <img src="resources/img/visual_pubg.jpg" class="d-block w-100 h-auto" alt="테스트 이미지1" />
          </div>
          <div class="carousel-item" data-bs-interval="4000">
            <img src="resources/img/visual_baldursgate3.jpg" class="d-block w-100" alt="테스트 이미지2" />
          </div>
          <div class="carousel-item" data-bs-interval="4000">
            <img src="resources/img/visual_lostark.jpg" class="d-block w-100" alt="테스트 이미지4" />
          </div>
          <div class="carousel-item" data-bs-interval="4000">
            <img  src="resources/img/visual_minecraft.jpg" class="d-block w-100" alt="테스트 이미지5" />
          </div>
          <div class="carousel-item" data-bs-interval="4000">
            <img src="resources/img/visual_valorant.jpg" class="d-block w-100" alt="테스트 이미지6" />
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

    <section class="sec info">
      <div class="container">
        <div class="title-wrap d-flex justify-content-between">
          <h1 class="title">스터디룸 공지사항</h1>
          <c:if test="${role eq 'admin'}">
            <input type="button" class="btn btn-primary insert-btn" value="공지 추가하기" onclick="insert()">
          </c:if>
        </div>
        <div class="row g-4 d-flex justify-content-center">
          <c:forEach var="dto" items="${list}">
            <div class="gt col-4">
              <div class="col box card">
                <a href="view?id=${dto.id}&page=${param.page}">
                    <c:if test="${dto.file_name ne 'no_file'}">
                      <img class="card-img-top w-80 h-60" src="${pageContext.request.contextPath}/resources/upload/${dto.file_name}" alt="공지사항 이미지">
					          </c:if>
                    <span class="card-title">${dto.title}</span>
                    <span class="card-text">${fn:split(dto.register_date, " ")[0]}</span>
                </a>
              </div>
            </div>
          </c:forEach>
          ${pageMenu}
        </div>
      </div>
    </section>

    <%@ include file="../include/footer.jsp" %>

    <!-- bootstrap script -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"></script>
    <!--script-->
    <script src="resources/js/swiper.js" type="module"></script>

  </body>
</html>
