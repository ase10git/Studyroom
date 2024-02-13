package com.study.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDAO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	// 사용자 정보 화면 보기
	@RequestMapping("user_view")
	public String user_view(Model model) {
		return Common.USER_PATH+"user_view.jsp";
	}
	
	// 사용자 정보 수정하기 전 비밀번호 확인 페이지 이동
	@RequestMapping("user_pw_auth_form")
	public String user_pw_auth_form(Model model) {
		return Common.USER_PATH+"pw_auth_form.jsp";
	}
	
	// 사용자 정보 수정 페이지 이동	// 미완성
	@RequestMapping("user_modify_form")
	public String user_modify_form(Model model) {
		return Common.USER_PATH+"user_modify_form.jsp";
	}
	
	
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
