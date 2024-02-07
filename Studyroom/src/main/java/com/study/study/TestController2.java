package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Common;

// 테스트용 컨트롤러
// 파일을 변경하지 말고 복사해서 사용해주세요
@Controller
public class TestController2 {

	@RequestMapping(value = {"/","login"}) //로그인
	public String login() {
		return Common.LOGIN_PATH+"login.jsp";
	}
	
//	@RequestMapping("login") //로그인
//	public String login() {
//		return Common.REGISTER_PATH+"login.jsp";
//	}
	
	@RequestMapping("register") //회원가입
	public String register() {
		return Common.REGISTER_PATH+"register.jsp";
	}
}
