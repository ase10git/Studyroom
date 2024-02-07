package com.study.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

// 테스트용 컨트롤러
// 파일을 변경하지 말고 복사해서 사용해주세요
@Controller
@RequiredArgsConstructor
public class TestController {
	
	final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	//첫 화면(로그인)
	@RequestMapping(value = {"/","login_form"})
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
			return "[{'param':'no_eamil'}]";
		}
		
		//우리가 입력받은 pwd와 DB에 저장된 비밀번호를 비교하기
		if(!pwd.equals(dto.getPwd())) {
			return "[{'param':'no_pwd'}]";
		}
		
		//세션에 바인딩
		session.setAttribute("eamil", dto);
		
		//로그인에 성공한 경우
		return "[{'param':'clear'}]";
	}
	
	//회원가입
	@RequestMapping("register") 
	public String register() {
		return Common.REGISTER_PATH+"register.jsp";
	}
	
	//로그아웃
	@RequestMapping("logout") 
	public String logout() {
		session.removeAttribute("email");
		return "redirect:login_form";
	}
	

//	@RequestMapping("/")
//	public String test() {
//		return Common.VIEW_PATH + "home.jsp";
//	}
	
	/*
	@RequestMapping("/")
	public String board_list(Model model) {
		
	}
	
	@RequestMapping("/")
	public String board_list_user() {
		
	}
	
	@RequestMapping("/")
	public String board_view(Model model) {
		
	}
	
	@RequestMapping("/")
	public String board_view_delete(int idx) {
		
	}
	
	@RequestMapping("/")
	public String board_insert_form() {
		
	}
	
	@RequestMapping("/")
	public String board_insert() {
		
	}
	
	@RequestMapping("/")
	public String board_reply_insert(int idx) {
		
	}
	
	@RequestMapping("/")
	public String board_modify_form() {
		
	}
	
	@RequestMapping("/")
	public String board_modify(int idx) {
		
	}
	*/
}
