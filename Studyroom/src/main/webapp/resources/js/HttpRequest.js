var xhr = null;

function createRequest() {
	
	/*
	* XMLHTTPRequest : JavaScript를 이용하여 서버로 정보를 보내는 HTTP Request 만들기 위해
	* 해당 기능을 제공하는 객체
	*/
	
	if(xhr != null) {
		return;
	}
	
	// window.ActiveXObject
	// ActiveXObject 를 지원하는 브라우저면 객체를 리턴하고, 
	// 그렇지 않으면 null을 리턴
	if(window.ActiveXObject) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP"); // IE 환경
	} else { 
		xhr = new XMLHttpRequest(); // 나머지 브라우저에서 객체 생성
	}
}

// custom 가능
// url : 목적지
// param : 파라미터
// callback : 처리 후 돌아올 위치
// method : 전송방식(GET, POST)
function sendRequest(url, param, callback, method) {
	// 객체 생성
	createRequest();
	
	// 전송 타입 구분
	var httpMethod = (method != 'POST' && method != 'post') ? 'GET' : 'POST';
	
	// 파라미터 구분
	var httpParam = (param == null || param == '') ? null : param;
	
	// 접근 url
	var httpURL = url;
	
	// 요청 방식이 GET이고, 전달할 파라미터가 있다면
	// url 경로 새로 제작
	if(httpMethod == 'GET' && httpParam != null) {
		httpURL = httpURL+'?'+httpParam;
	}
	
	// xhr.open(요청방식, 목적지, 비동기여부);
	xhr.open(httpMethod, httpURL, true);
	
	// 만약 "POST" type을 보내려 한다면
	// request에 MIME type을 설정해야 함
	// ex) 후술할 xhr.send() 메소드 호출 전에 아래 형태로 send()로 보낼 query를 이용
	// application/x-www-form-urlencoded는 html의 form 기본 Context-Type
	// key=value&key=value 형태로 전달됨
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	// 작업이 완료된 후 호출될 callback 메소드 지정
	xhr.onreadystatechange=callback;
	
	// send(): 데이터 교환을 요청하는 함수
	// GET이면 주소창에 queryString을 따라가므로 파라미터를 같이 보낼 필요가 없음
	xhr.send(httpMethod == 'POST' ? httpParam : null);
	
}
