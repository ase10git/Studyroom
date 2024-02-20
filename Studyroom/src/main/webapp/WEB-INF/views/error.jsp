<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error!</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
    <link rel="stylesheet" href="resources/css/main.css">
    <style>
    	html, body{
    		margin:0; padding:0;
    ***REMOVED***
    	.sec{ margin-top : 100px;***REMOVED***
    	
		.img_gif{
			display:inline-block;
			width:100%; height:100%;
			background:url("resources/img/dinosaur.gif")
			no-repeat center center #FFFDFF;
	***REMOVED***
    </style>
</head>
<body>

	<div class="img_gif">
	  <section class="sec error">
	    <div class="container">
	     <h1 class="title text-center">😥에러가 발생했습니다!</h1>
	      <div class="row gy-4 justify-content-center">
	        <div class="box col-12 col-md-6 text-center">
	        	<span class="text-danger fw-bold">요청과 권한을 다시 확인해주세요!</span>
	        </div>
	      </div>
	    </div>
	  </section> 
	</div>
	
	<!-- bootstrap script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	crossorigin="anonymous"></script>
</body>
</html>