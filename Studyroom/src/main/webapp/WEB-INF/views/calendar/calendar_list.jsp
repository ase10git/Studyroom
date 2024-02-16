<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>캘린더</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/calendar_list.css">
    <script src="resources/js/HttpRequest.js"></script>
    <script>
    var events = []; //일정을 저장할 변수
    var year = new Date().getFullYear(); //현재연도
    var month = new Date().getMonth() + 1; //현재월
    var typeNames = { //일정타입 글에 대한 한글이름 지정
    	    'note': '노트',
    	    'personal_event': '개인 일정',
    ***REMOVED***;
	//달력을 그리는 함수
    function drawCalendar() {
		//문자열을 저장할 변수
        var html = '';
		//현재 달의 첫 날과 마지막 날을 구함
        var firstDate = new Date(year, month - 1, 1);
        var lastDate = new Date(year, month, 0);
		//6주를 표시하기위해 6번 반복
        for (var i = 0; i < 6; i++) {
            html += '<tr>';//한주의 시작
            for (var j = 0; j < 7; j++) { //한주에는 7일이 있응께 7번 반복
            	//현재 셀의 날짜르 계산함
                var date = i * 7 + j - firstDate.getDay() + 1;
                if (date > 0 && date <= lastDate.getDate()) { //날짜가 해당달에 속해잉ㅆ는겨웅
                    var dateEvents = events.filter(function(e) { //해당 날짜의 ㅣㄹ정을 가져옴
                        return e.datetime.getDate() == date &&
                               e.datetime.getMonth() == month - 1 &&
                               e.datetime.getFullYear() == year;
                    ***REMOVED***);
                	// 날짜와 그날의 일정을 셀에 추가
                    html += '<td onclick="showEvents(' + date + ')">' + date; // 클릭 이벤트 추가
                    dateEvents.forEach(function(e) {
                    	 html += '<p>' + typeNames[e.type] + '</p>';
                    ***REMOVED***);
                    html += '</td>';
                ***REMOVED*** else {
                	//날짜가 해당달에 속하지 않는다면 빈셀
                    html += '<td></td>';
                ***REMOVED***
            ***REMOVED***
            html += '</tr>'; //한즈의끝
        ***REMOVED***
		//생성한 HTML문자열로 달력그림
        document.getElementById('calendar-body').innerHTML = html;
		//현재 년도와 월표시
        document.getElementById('current-year-month').innerText = year + '년 ' + month + '월';
    ***REMOVED***
    
	//수정할 일정의 ID를 저장할 변수
    var editEventId;
    //특정 날짜의 일정을 보여주는 함수
    function showEvents(date) {
    	//해당날짜에 모든 일정을 가져옴.
        var dateEvents = events.filter(function(e) {
            return e.datetime.getDate() == date &&
                   e.datetime.getMonth() == month - 1 &&
                   e.datetime.getFullYear() == year;
        ***REMOVED***);
		
    	//타이틀에 날짜를 표시함
        document.getElementById('event-modal-title').innerText = year + "년 " + month + "월 " + date + "일";
		
    	//각 일정에 대한 정보를 HTML로 만듦 
        var html = '';
        dateEvents.forEach(function(e, i) {
            html += '<p>' + typeNames[e.type] + ': ' + e.comment;
            if (e.type != 'course_schedule') { // 강의 일정 이 아닌 경우에만 버튼 표시
                html += ' <button id="delete-button-' + i + '">삭제</button>';
                html += ' <button id="edit-button-' + i + '">수정</button></p>';  // '수정' 버튼 추가
            ***REMOVED***
        ***REMOVED***);
		//일정 정보를 모달에 표시
        document.getElementById('event-modal-body').innerHTML = html;
		
		//모달을 표시함
        var myModal = new bootstrap.Modal(document.getElementById('event-modal'));
        myModal.show();
		
        //삭제 버튼과 수정버튼에 이벤트 리스너를 추가함
        dateEvents.forEach(function(e, i) {
            if (e.type != 'course_schedule') { // 강의 일정 이 아닌 경우에만 버튼 이벤트 추가
                document.getElementById('delete-button-' + i).addEventListener('click', function() {
                    deleteEvent(e.id);
                    myModal.hide();
                ***REMOVED***);

                document.getElementById('edit-button-' + i).addEventListener('click', function() {
                    editEventId = e.id;  // 수정할 일정의 ID를 저장
                    showEditModal(e);  // 수정 모달 창을 표시
                ***REMOVED***);
            ***REMOVED***
        ***REMOVED***);
    ***REMOVED***
    
    //수정할 일정을 표시해주는 함수
    function showEditModal(event) {
    	//수정할 일정의 정보를 입력필드에 표시
        document.getElementById('edit-event-type').value = event.type;
        document.getElementById('edit-event-comment').value = event.comment;
		// 수정 모달을 표시
        var myModal = new bootstrap.Modal(document.getElementById('edit-event-modal'));
        myModal.show();
    ***REMOVED***
	// 일정을 수정하는 함수
    function editEvent() {
		//사용자가 입력한 새로운 일정 정보를 가져 
        var newType = document.getElementById('edit-event-type').value;
        var newComment = document.getElementById('edit-event-comment').value;
		// 내용이 비어있는경우 경고창 
        if (!newComment) {
            alert("내용을 입력해주세요.");
            return;
        ***REMOVED***
		//요청에 포함할 데이터 추가
        var data = 'id=' + editEventId + '&type=' + newType + '&comment=' + newComment;
		
		//수정요청
        sendRequest('editEvent', data, function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                getEventsByMonth();
            ***REMOVED***
        ***REMOVED***, 'POST');

        //수정 모달을 닫음
        var myModal = bootstrap.Modal.getInstance(document.getElementById('edit-event-modal'));
        myModal.hide();
    ***REMOVED***
    
	//새로운 일정을 추가하는 함수
    function addEvent() {
        var type = document.getElementById('event-type').value; //사용자가 입력한 일정들의 타입과 내용을 가져옴
        var comment = document.getElementById('event-comment').value;
        var selectedDate = document.getElementById('event-modal-title').innerText; //선택한 날짜를 가져옴
		//문자열로 분리하여 연,월,일 추출
        var dateParts = selectedDate.split(' ');
        var year = dateParts[0].slice(0, -1);
        var month = dateParts[1].slice(0, -1);
        var day = dateParts[2].slice(0, -1);
        var datetime = year + '-' + month.padStart(2, '0') + '-' + day.padStart(2, '0');// 추출한 연도, 월, 일을 조합하여 datetime 문자열을 만듦

        var data = 'type=' + type + '&comment=' + comment + '&datetime=' + datetime;// 요청에 포함할 데이터를 만들
        var myModal = new bootstrap.Modal(document.getElementById('add-event-modal'));
        myModal.hide();// 모달 창을 닫음
        sendRequest('addEvent', data, function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                getEventsByMonth();// 일정이 추가되면 달력을 다시 그람
            ***REMOVED***
        ***REMOVED***, 'POST');
    ***REMOVED***
    
    
	//이전달로 이동하는 함수
    function prevMonth() {
        if (--month < 1) {
            month = 12;
            year--;
        ***REMOVED***
        getEventsByMonth();
    ***REMOVED***
	//담달 이동
    function nextMonth() {
        if (++month > 12) {
            month = 1;
            year++;
        ***REMOVED***
        getEventsByMonth();
    ***REMOVED***
	//해당월의 일정을 가져옴
    function getEventsByMonth() {
        sendRequest('getEventsByMonth', 'year=' + year + '&month=' + month, function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                events = JSON.parse(xhr.responseText).map(function(e) {
                    var dateParts = e.datetime.split("-");
                    e.datetime = new Date(dateParts[0], dateParts[1] - 1, dateParts[2]);
                    return e;
                ***REMOVED***);
                drawCalendar();
            ***REMOVED***
        ***REMOVED***, 'POST');
    ***REMOVED***
	//페이지가 다 로드가되면 가져옴
    document.addEventListener('DOMContentLoaded', function() {
        getEventsByMonth();
    ***REMOVED***);
	
    
	//일정을 삭제하는 함수 id: 캘린더 번호
    function deleteEvent(id) {
		//확인 메세지보냄.
		
        var confirmDelete = confirm("정말 삭제하시겠습니까?");
		//예를 누르면 일로내려와 수행
        if (confirmDelete) {
            sendRequest('deleteEvent', 'id=' + id, function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    getEventsByMonth();
                ***REMOVED***
            ***REMOVED***, 'POST');
        ***REMOVED***
    ***REMOVED***
	</script>
</head>
<body>

	<%@ include file="../include/menu.jsp" %>
	
	  <section class="sec event">
	    <div class="container">
	     <h1>캘린더</h1>
	      <div class="row gy-4">
	        <div class="col box">
				<div id="calendar-header">
				    <button onclick="prevMonth()">Previous</button>
				    <span id="current-year-month"></span>
				    <button onclick="nextMonth()">Next</button>
				</div>
				   
				<table id="calendar" class="table table-bordered">
			        <thead>
			            <tr>
			                <th>Sun</th>
			                <th>Mon</th>
			                <th>Tue</th>
			                <th>Wed</th>
			                <th>Thu</th>
			                <th>Fri</th>
			                <th>Sat</th>
			            </tr>
			        </thead>
			        <tbody id="calendar-body">
			            <!-- 여기에 자바스크립트로 달력 나옴 -->
			        </tbody>
			    </table>
	        </div>
	      </div>
	    </div>
	  </section>


    <!-- 일정을 표시하는 모달창 -->
    <div class="modal" tabindex="-1" id="event-modal">
    	<div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="event-modal-title">일정</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>
	            <div class="modal-body" id="event-modal-body">
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#add-event-modal">추가</button>
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- 새로운 일정을 추가하는 모달창 -->
	<div class="modal" tabindex="-1" id="add-event-modal">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title">새 일정 추가</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>
	            <div class="modal-body">
	                <form id="event-form">
	                    <select id="event-type">
	                        <option value="personal_event">개인 일정</option>
	                        <option value="note">노트</option>
	                    </select>
	                    <textarea id="event-comment" rows="5" cols="20" placeholder="설명을 입력하세요."></textarea>
	                </form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" onclick="addEvent()" data-bs-dismiss="modal">저장</button>
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- 일정 수정 모달창 -->
	<div class="modal" tabindex="-1" id="edit-event-modal">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title">일정 수정</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>
	            <div class="modal-body">
	                <form id="edit-event-form">
	                    <select id="edit-event-type">
	                        <option value="personal_event">개인 일정</option>
	                        <option value="note">노트</option>
	                    </select>
	                    <textarea id="edit-event-comment" rows="5" cols="20" placeholder="설명을 입력하세요."></textarea>
	                </form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" onclick="editEvent()">저장</button>
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	            </div>
	        </div>
	    </div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
