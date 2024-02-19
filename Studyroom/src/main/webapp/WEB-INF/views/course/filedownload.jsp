<%@page import="dto.CourseBoardDTO"%>
<%@page import="util.FileManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파일 다운로드 전용 페이지
	
	// response.getOutputStream()의 중복 호출 문제 해결을 위한 처리
	out.clear(); // OutputStream을 사용하기 전에 한 번 비워줌
	out=pageContext.pushBody(); // 호출 시 JSP 페이지에 대한 정보를 저장
								// https://zincod.tistory.com/102 참고
	
	// 포워딩한 fileManager와 dto를 가져옴
	FileManager fileManager = (FileManager)request.getAttribute("fileManager");
	CourseBoardDTO dto = (CourseBoardDTO)request.getAttribute("dto");

	// 파일 다운로드 실행
	fileManager.fileDownload(dto, request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>