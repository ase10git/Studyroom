package com.study.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String user_view(Model model, int id) {
//		UserDTO current_session = (UserDTO)session.getAttribute("email");
//		
//		if(current_session == null) {
//			return Common.LOGIN_PATH + "login_form.jsp";
//	***REMOVED***
		
		UserDTO dto = user_dao.selectOne(id);
		model.addAttribute("dto", dto);
		return Common.USER_PATH+"user_view.jsp";
***REMOVED***
	
	// 사용자 정보 수정하기 전 비밀번호 확인 페이지 이동
	@RequestMapping("user_modify_password_check_form")
	public String user_modify_password_check_form() {
		return Common.USER_PATH+"user_modify_password_check_form.jsp";
***REMOVED***
	
	// 사용자 정보 수정 페이지 이동
	@RequestMapping("user_modify_form")
	public String user_modify_form() {
		return "";
***REMOVED***
	
	
	/*
	@RequestMapping("/")
	public String board_list(Model model) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_list_user() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_view(Model model) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_view_delete(int idx) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_insert_form() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_insert() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_reply_insert(int idx) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_modify_form() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_modify(int idx) {
		
***REMOVED***
	*/
***REMOVED***
