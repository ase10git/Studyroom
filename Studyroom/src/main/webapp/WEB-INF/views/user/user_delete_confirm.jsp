<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 확인 페이지</title>
	<!-- bootstrap css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"/>
  <link rel="stylesheet" href="resources/css/main.css">
  	<!-- flaticon -->
	<link rel='stylesheet' 
    href='https://cdn-uicons.flaticon.com/2.1.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
    <!-- fontawesome -->
    <script src="https://kit.fontawesome.com/75c3a9ae5d.js" crossorigin="anonymous"></script>
	<script>
	  if (${authFail}) {
	      alert('비밀번호가 틀렸습니다.');
	  }
	
	  function confirmDelete() {
	  	if (!confirm("회원 탈퇴 시 모든 데이터가 영구 삭제됩니다. 진행하시겠습니까?")) {
	      return;
	    }
	  	var url = "user_delete";
	  	var param = "id=${id}"
	  	sendRequest(url,param,delCheck,"post");
	  }
	  
	  function delCheck(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var data = xhr.responseText;
				
				var json = (new Function('return' + data))();
				
				if(json[0].result == 'yes'){
					alert('회원 탈퇴가 완료되었습니다.')
					location.href='logout';
				} else {
					alert('삭제 실패')
					location.href='user_view';
				}
			}
		}
	</script>
</head>
<body>
	
	<%@ include file="../include/menu.jsp" %>
	
  <section class="sec event">
    <div class="container">
      <div class="row gy-4">
        <div class="box col-12 col-md-6">
          <div class="gt">
			<h2>정말 삭제하시겠습니까?</h2>
            <button class="btn btn-danger" onclick="confirmDelete(${id})">예</button>
            <button class="btn btn-primary" onclick="location.href='user_view'">아니오</button>
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