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

@Controller
@RequiredArgsConstructor
public class UserController {
	
	final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	// ����� ���� ȭ�� ����
	@RequestMapping("user_view")
	public String user_view(Model model) {
		return Common.USER_PATH+"user_view.jsp";
***REMOVED***
	
	// ����� ���� �����ϱ� �� ��й�ȣ Ȯ�� ������ �̵�
	@RequestMapping("user_pw_auth_form")
	public String user_pw_auth_form(Model model) {
		return Common.USER_PATH+"pw_auth_form.jsp";
***REMOVED***
	
	// ����� ���� ���� ������ �̵�	// �̿ϼ�
	@RequestMapping("user_modify_form")
	public String user_modify_form(Model model) {
		return Common.USER_PATH+"user_modify_form.jsp";
***REMOVED***

***REMOVED***
