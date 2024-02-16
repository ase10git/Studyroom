package com.study.study;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDAO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	final UserDAO user_dao;
	
//    @Autowired
//    private SessionService sessionService;
	
	@Autowired
	HttpSession session;
	
	// ����� ���� ȭ�� ����
	@RequestMapping("user_view")
	public String user_view(Model model) {	
//		UserDTO dto = sessionService.getUserFromSession();
		UserDTO dto = (UserDTO)session.getAttribute("email");
		model.addAttribute("dto", dto);	
		return Common.USER_PATH+"user_view.jsp";
***REMOVED***
	
	// ����� ���� �����ϱ� �� ��й�ȣ Ȯ�� ������ �̵�
	@RequestMapping("user_pw_auth_form")
	public String user_pw_auth_form(Model model) {
		UserDTO dto = (UserDTO)session.getAttribute("email");
		model.addAttribute("dto", dto);	
		return Common.USER_PATH+"pw_auth_form.jsp";
***REMOVED***
	
	@RequestMapping("authenticate")
	public String authenticate() {
		return "";
***REMOVED***
	
	// ����� ���� ���� ������ �̵�	// �̿ϼ�
	@RequestMapping("user_modify_form")
	public String user_modify_form(Model model) {
		return Common.USER_PATH+"user_modify_form.jsp";
***REMOVED***

***REMOVED***
