<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CSS못하겠어요 살려주세요.</title>
    <style>
        table{
        	border: 1px solid #AFEEEE;
        	border-radius: 20px;
   			border-collapse: separate;
   	 		border-spacing: 0;
        ***REMOVED***
        
        th{
        	width: 150px;
        	height: 100px;
        	border-radius: 10px;
        ***REMOVED***
        
        td{
        	width:150px;
        	height:100px;
        	border-radius: 10px;
        ***REMOVED***
        
        .dayBtn{
        	width: 150px;
        	height: 100px;
        	border: none;
        	background: transparent;
        	display: flex; 
   			align-items: flex-start;
    		justify-content: flex-start;
    		border-radius: 10px;
        ***REMOVED***
        
        .dayBtn:hover {
			background-color: #d1e3f7;
	***REMOVED***
		
		.calBtn{
			text-align: center;
	***REMOVED***
		
		
		
		
        
        
    </style>
    <script src="resources/js/HttpRequest.js"></script>
    <script type="text/javascript">
    	var currentYear = ${currentYear***REMOVED***;
    	var currentMonth = ${currentMonth***REMOVED***;
    	
    	//웹 페이지가 처음 로드 될때 실행 하는 동작 정의하깅 ><
    	window.onload = function() {
    	    //현재 년도와 월을 표시하깅 ~
    	    document.getElementById('calendarTitle').textContent = currentYear + '년 ' + currentMonth + '월';
    	    
    	    // 데이터 요청하깅 ~
    	    var url = "calendar_data";
    	    var param = "year=" + currentYear + "&month=" + currentMonth;
    	    sendRequest(url, param, calData, "get");
    ***REMOVED***;
    	
    	 
        function calPrev(){
        	//현재 월에서 1빼깅 ~ 이전달 표시할려면 !
        	 currentMonth = currentMonth - 1;
        	
        	//만약에 월이 1보다 작아지면 ? 아잉 ><
        	 if(currentMonth < 1){
        	        currentMonth = 12; //월을 12월로 만들구 
        	        currentYear = currentYear - 1; //연도 -1 을하여 저번년도를 출력하게 하깅 ~
        	 ***REMOVED***
        	    var url = "calendar_data";
        	    var param = "year="+currentYear+"&month="+currentMonth;
        	    sendRequest(url, param, calData, "get");
        ***REMOVED***
        
        //달력 데이터 처리
        function calData() {
            if(xhr.readyState == 4 && xhr.status == 200){
                var data = xhr.responseText; //서버로 부터 받은 응답 테스트 변수에 담기 ><
                var json = JSON.parse(data); //응답 텍스트를 존슨으로 받깅 ><
                var prevMonthLastDay = json.prevMonthLastDay;
                
                var daysInMonth = json.daysInMonth; //존슨 객체로부터 해당 달의 날짜 정보를 가져와 변수에 저장하깅 ><
                currentYear = json.year; //존슨 객체에서 년도 정보를 가져와 변수에 저장하깅><
                currentMonth = json.month; //존슨 객체에서 월 정보를 가져와 변수에 저장하기 헤헿 ><
             	// 1일의 요일을 구합니다. (0:일요일, 1:월요일, ..., 6:토요일)
                var firstDayOfWeek = new Date(currentYear, currentMonth-1, 1).getDay();
                // 이전 달의 마지막 주 일요일의 날짜를 구합니다.
                var lastSunday = prevMonthLastDay - firstDayOfWeek;
                
                //달력의 제목을 업데이트 하깅 ~~
                document.getElementById('calendarTitle').textContent = currentYear + '년 ' + currentMonth + '월';

                //테이블 본문 가져오깅 >< 그리구 calendarBody라는 id를 가진 요소를 찾아 변수에 저장하깅 ~
                var tableBody = document.getElementById('calendarBody');
                // 테이블 본문 지우깅 ~ 테이블 본문의 모든 자식 요소를 지우깅 ~
                while (tableBody.firstChild) {
                    tableBody.removeChild(tableBody.firstChild);
                ***REMOVED***
                
                //행과 셀을 동적으로 생성하깅 ~ 
                var row = null; //현재 행을 저장할 변수 선언하깅 ~ 
                for (var i = 0; i < 42; i++) { //달의 모든 날짜에 대해 반복하깅 ~
					//주의 시작에서 새로운 행을 생성하깅 ~  i가 7의 배수일때마다 새로운 행 생성하기 ~ 그리고 본문에 추가하
                    if (i % 7 == 0) {
                        row = document.createElement('tr');
                        tableBody.appendChild(row);
                    ***REMOVED***
                    
                    var cell = document.createElement('td'); //새로운 셀 생성하깅 ~
                    var day = (i < daysInMonth.length) ? daysInMonth[i] : null; //해당 날짜 가져오깅 ~
                    if (day != null) {
                    	//셀의 내용을 설정하깅 ~ 
                        cell.innerHTML = '<button class="dayBtn" onclick="clickDate()">' +'<span style="font-size : 16px;">'+day+'</span>' + '</button>';
                    ***REMOVED*** else { 
                    	if(i < 7){
                    		var prevMonthDate = lastSunday + i+1;
                    		cell.innerHTML = '<button class="dayBtn" style="background-color : gray;" onclick="clickDate()">' +'<span style="font-size : 16px; color: white;">'+ prevMonthDate +'</span>' + '</button>';
                        ***REMOVED***else{
                        	var nextMonthFirstDate = i - daysInMonth.length + 1;
                        	cell.innerHTML = '<button class="dayBtn" style="background-color : gray;" onclick="clickDate()">' +'<span style="font-size : 16px; color: white;">'+ nextMonthFirstDate +'</span>' + '</button>';
                        ***REMOVED***
                    ***REMOVED***
                    row.appendChild(cell); //생성한 셀을 현재 행에 추가하깅 ~
                ***REMOVED***
                
                // 마지막 주를 완성하기 위해 달의 끝에 추가 셀을 추가하깅 ~
                // 현재 행의 셀 개수가 7개 미만이라믄 ? 새로운 셀을 생성하고 공백으로 설정한후 현재 행에 추가하깅 ~
                while (row && row.cells.length < 7) {
                    var cell = document.createElement('td');
                    cell.innerHTML = '&nbsp;';
                    row.appendChild(cell);
                ***REMOVED***
            ***REMOVED***
        ***REMOVED***
        
        function calNext(){
        	//현재 월에서 1더하기 다음달 표시할려면~ 아잉 >< 
       	 	currentMonth = currentMonth + 1;
       	
       		//만약에 월이 12보다 커지면..?
       	 	if(currentMonth > 12){
       	        currentMonth = 1; //월을 1월로 만들구 
       	        currentYear = currentYear + 1; //연도 +1 을하여 다음년도를 출력하게 하깅 ~
       	 ***REMOVED***
       	    var url = "calendar_data";
       	    var param = "year="+currentYear+"&month="+currentMonth;
       	    sendRequest(url, param, calData, "get");
       ***REMOVED***
        
        
        
        
     </script>
</head>
<body>
    <h1 align="center">StudyRoom</h1>
    <h1 align="center" id="calendarTitle">${currentYear***REMOVED***년 ${currentMonth***REMOVED***월</h1>
    <div class="calBtn">
    <button name="calPrev" onclick="calPrev(${currentYear***REMOVED***, ${currentMonth***REMOVED***)">&lt</button>
    <button name="calNext" onclick="calNext(${currentYear***REMOVED***, ${currentMonth***REMOVED***)">&gt</button>
    
    </div>
    <table border="1" align="center">
    	<tr>
        	<th>일</th>
        	<th>월</th>
        	<th>화</th>
        	<th>수</th>
        	<th>목</th>
        	<th>금</th>
        	<th>토</th>
    	</tr>
   		 <tbody id="calendarBody">
    	</tbody>
	</table>
</body>
</html>
