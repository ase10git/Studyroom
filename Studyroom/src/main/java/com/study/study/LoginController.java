package com.study.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import service.SessionService;
import util.Common;

@Controller
@RequiredArgsConstructor
public class LoginController {

	final UserDAO user_dao;
	
    @Autowired
    private SessionService sessionService;
	
	//첫 화면(로그인)
	@RequestMapping(value = {"/","/login_form"})
	public String login_form() {
		return Common.LOGIN_PATH+"login_form.jsp";
	}
	
	//로그인 매핑
	@RequestMapping("login") 
	@ResponseBody
	public String login(String email, String pwd) {
		//email에 해당하는 데이터 1건 조회
		UserDTO dto = user_dao.selectOne(email);
		
		//dto가 null일 경우 email이 DB에 존재하지 않음
		if(dto == null) {
			return "[{'param':'no_email'}]";
		}
		
		//우리가 입력받은 pwd와 DB에 저장된 비밀번호를 비교하기
		if(!pwd.equals(dto.getPwd())) {
			return "[{'param':'no_pwd'}]";
		}
		
		//세션에 바인딩
		sessionService.setUserInSession("email", dto);
		
		//************************** 편집자 - 테스트용 *****************************
//		session.setAttribute("userId", dto.getId());
//		System.out.println(dto.getId());
//		session.setAttribute("role", dto.getRole());
//		System.out.println(dto.getRole());
		//***********************************************************************
		
		//로그인에 성공한 경우
		return "[{'param':'clear'}]";
	}
	
	//로그아웃
	@RequestMapping("logout") 
	public String logout() {
		sessionService.removeAttribute("email");
		return "redirect:login_form";
	}
	
	//회원가입 페이지로 이동
	@RequestMapping("register") 
	public String register() {
		return Common.REGISTER_PATH+"register.jsp";
	}
	
	//이메일 체크
	@RequestMapping("check_email")
	@ResponseBody
	public String check_email(String email) {
		System.out.println(email);
		UserDTO dto = user_dao.selectOne(email);
		
		//null이면 중복되지 않으므로 가입 가능
		if(dto == null) {
			return "[{'res':'yes'}]";
		}
		
		return "[{'res':'no'}]";
	}
	
	//회원가입
	@RequestMapping("register_insert")
	public String register_insert(UserDTO dto) {
		int res = user_dao.insert(dto);
		
		if(res > 0) {
			return "redirect:login_form";
		}
		
		return null;
	}
	
}
