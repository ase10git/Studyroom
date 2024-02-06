<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
      
    <style type="text/css">
    	.container{
    		margin: 20px;
    		background-color : #eee;
    ***REMOVED***
    	.container .row{border: 2px solid red;***REMOVED***
    	.container .box{background-color : pink;***REMOVED***
    	.container .box .gt{border: 2px solid black;***REMOVED***
    </style>
</head>
<body>
	
	<!-- Bootstrap 구조 샘플 
		샘플을 보고 원하는 구조를 선택해서 사용해주세요
		창 사이즈를 변경하면 컴포넌트 크기도 자동으로 바뀝니다
	-->
	<!-- 기본 구조(gt 박스 없어도 됨) -->
  <section class="sec event">
    <div class="container">
     <h1>test home</h1>
      <div class="row gy-4">
        <div class="box col-12 col-md-6">
          <div class="gt">
				<p>gutter box</p>
          </div>
        </div>
        <div class="box col-12 col-md-6">
          <div class="gt">
          		<p>gutter box</p>
          </div>
        </div>
        <div class="box col-12">
          <div class="gt">
				<p>gutter box</p>
          </div>
        </div>
      </div>
    </div>
  </section>

	<!-- 2번 -->
  <section class="sec best-item">
    <div class="container">
      <h2 class="title">거터 있음 0 - box에 테두리 하면? x </h2>
      <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
        <div class="box col">
          <div class="pic"><img src="" alt=""></div>
          <div class="info">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
          </div>
        </div>
        <div class="box col">
          <div class="pic"><img src="" alt=""></div>
          <div class="info">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
          </div>
        </div>
        <div class="box col">
          <div class="pic"><img src="" alt=""></div>
          <div class="info">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
          </div>
        </div>    
        <div class="box col">
          <div class="pic"><img src="" alt=""></div>
          <div class="info">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
          </div>
        </div>    
      </div>
    </div>
  </section>
  
  <!-- 3번 -->
  <section class="sec new-item">
    <div class="container">
      <h2 class="title">거터 있음 0 - box에 테두리 적용하려면? div(gt)구조 하나 더 넣기</h2>
      <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4">
        <div class="box col">
          <div class="gt">
            <div class="pic"><img src="" alt=""></div>
            <div class="info">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
            </div>
          </div>
        </div>
        <div class="box col">
          <div class="gt">
            <div class="pic"><img src="" alt=""></div>
            <div class="info">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
            </div>
          </div>
        </div>
        <div class="box col">
          <div class="gt">
            <div class="pic"><img src="" alt=""></div>
            <div class="info">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
            </div>
          </div>
        </div>
        <div class="box col">
          <div class="gt">
            <div class="pic"><img src="" alt=""></div>
            <div class="info">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, eum inventore ab non tenetur omnis velit dolor minus! Blanditiis voluptate culpa obcaecati itaque porro, accusantium qui? Ducimus quisquam voluptatem explicabo?
            </div>
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