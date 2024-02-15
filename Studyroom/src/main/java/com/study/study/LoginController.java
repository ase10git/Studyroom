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
	
	//ù ȭ��(�α���)
	@RequestMapping(value = {"/","/login_form"})
	public String login_form() {
		return Common.LOGIN_PATH+"login_form.jsp";
	}
	
	//�α��� ����
	@RequestMapping("login") 
	@ResponseBody
	public String login(String email, String pwd) {
		//email�� �ش��ϴ� ������ 1�� ��ȸ
		UserDTO dto = user_dao.selectOne(email);
		
		//dto�� null�� ��� email�� DB�� �������� ����
		if(dto == null) {
			return "[{'param':'no_email'}]";
		}
		
		//�츮�� �Է¹��� pwd�� DB�� ����� ��й�ȣ�� ���ϱ�
		if(!pwd.equals(dto.getPwd())) {
			return "[{'param':'no_pwd'}]";
		}
		
		//���ǿ� ���ε�
		sessionService.setUserInSession("email", dto);
		
		//************************** ������ - �׽�Ʈ�� *****************************
//		session.setAttribute("userId", dto.getId());
//		System.out.println(dto.getId());
//		session.setAttribute("role", dto.getRole());
//		System.out.println(dto.getRole());
		//***********************************************************************
		
		//�α��ο� ������ ���
		return "[{'param':'clear'}]";
	}
	
	//�α׾ƿ�
	@RequestMapping("logout") 
	public String logout() {
		sessionService.removeAttribute("email");
		return "redirect:login_form";
	}
	
	//ȸ������ �������� �̵�
	@RequestMapping("register") 
	public String register() {
		return Common.REGISTER_PATH+"register.jsp";
	}
	
	//�̸��� üũ
	@RequestMapping("check_email")
	@ResponseBody
	public String check_email(String email) {
		System.out.println(email);
		UserDTO dto = user_dao.selectOne(email);
		
		//null�̸� �ߺ����� �����Ƿ� ���� ����
		if(dto == null) {
			return "[{'res':'yes'}]";
		}
		
		return "[{'res':'no'}]";
	}
	
	//ȸ������
	@RequestMapping("register_insert")
	public String register_insert(UserDTO dto) {
		int res = user_dao.insert(dto);
		
		if(res > 0) {
			return "redirect:login_form";
		}
		
		return null;
	}
	
}
