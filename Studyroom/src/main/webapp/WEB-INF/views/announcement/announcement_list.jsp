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
    <!--swiper-->
    <link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>      
    <!-- flaticon -->
    <link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <link rel="stylesheet" href="resources/css/announcement_list.css" />
    <link rel="stylesheet" href="resources/css/main.css" />
    
    <script type="text/javascript">
    	function insert() {
    		location.href = "course_board_insert_form?course_id=0";
    ***REMOVED***
    </script>
  </head>
  
  <body>
    <%@ include file="../include/menu.jsp" %>

    <!-- swiper -->
    <section class="sec visual">
      <div class="swiper container">
        <div class="swiper-wrapper wrap">
          <div class="swiper-slide">
            <img src="resources/img/visual_pubg.jpg" alt="테스트 이미지1" />
          </div>
          <div class="swiper-slide">
            <img
              src="resources/img/visual_baldursgate3.jpg"
              alt="테스트 이미지2"
            />
          </div>
          <div class="swiper-slide">
            <img
              src="resources/img/visual_hollowknight.jpg"
              alt="테스트 이미지3"
            />
          </div>
          <div class="swiper-slide">
            <img src="resources/img/visual_lostark.jpg" alt="테스트 이미지4" />
          </div>
          <div class="swiper-slide">
            <img
              src="resources/img/visual_minecraft.jpg"
              alt="테스트 이미지5"
            />
          </div>
          <div class="swiper-slide">
            <img src="resources/img/visual_valorant.jpg" alt="테스트 이미지6" />
          </div>
        </div>
        <div class="swiper-pagination"></div>
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
      </div>
    </section>

    <section class="sec info">
      <div class="container">
        <h1>스터디룸 공지사항</h1>
        <c:if test="${role eq 'admin'***REMOVED***">
        	<input type="button" class="btn insert-btn" value="공지 추가하기" onclick="insert()">
        </c:if>
        <div class="row gy-4">
          <c:forEach var="dto" items="${list***REMOVED***">
            <div class="col box col-6">
              <div class="gt">
                <a href="view?id=${dto.id***REMOVED***&page=${param.page***REMOVED***">
                    <c:if test="${dto.file_name ne 'no_file'***REMOVED***">
                      <img src="${pageContext.request.contextPath***REMOVED***/resources/upload/${dto.file_name***REMOVED***" alt="공지사항 이미지">
					</c:if>
                    <span class="title">${dto.title ***REMOVED***</span>
                    <span class="register_date">${fn:split(dto.register_date, " ")[0]***REMOVED***</span>
                </a>
              </div>
            </div>
          </c:forEach>
          <div class="pageMenu">${pageMenu***REMOVED***</div>
        </div>
      </div>
    </section>
	
    <%@ include file="../include/footer.jsp" %>

    <!-- bootstrap script -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"></script>
    <!--swiper-->
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <!--script-->
    <script src="resources/js/swiper.js" type="module"></script>

  </body>
</html>
