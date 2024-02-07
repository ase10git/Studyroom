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

// �׽�Ʈ�� ��Ʈ�ѷ�
// ������ �������� ���� �����ؼ� ������ּ���
@Controller
@RequiredArgsConstructor
public class TestController {
	
	final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	//ù ȭ��(�α���)
	@RequestMapping(value = {"/","login_form"})
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
			return "[{'param':'no_eamil'}]";
		}
		
		//�츮�� �Է¹��� pwd�� DB�� ����� ��й�ȣ�� ���ϱ�
		if(!pwd.equals(dto.getPwd())) {
			return "[{'param':'no_pwd'}]";
		}
		
		//���ǿ� ���ε�
		session.setAttribute("eamil", dto);
		
		//�α��ο� ������ ���
		return "[{'param':'clear'}]";
	}
	
	//ȸ������
	@RequestMapping("register") 
	public String register() {
		return Common.REGISTER_PATH+"register.jsp";
	}
	
	//�α׾ƿ�
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
