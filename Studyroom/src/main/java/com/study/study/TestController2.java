package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Common;

// �׽�Ʈ�� ��Ʈ�ѷ�
// ������ �������� ���� �����ؼ� ������ּ���
@Controller
public class TestController2 {

	@RequestMapping(value = {"/","login"***REMOVED***) //�α���
	public String login() {
		return Common.LOGIN_PATH+"login.jsp";
***REMOVED***
	
//	@RequestMapping("login") //�α���
//	public String login() {
//		return Common.REGISTER_PATH+"login.jsp";
//***REMOVED***
	
	@RequestMapping("register") //ȸ������
	public String register() {
		return Common.REGISTER_PATH+"register.jsp";
***REMOVED***
***REMOVED***
