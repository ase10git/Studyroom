package com.study.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDAO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import service.SessionService;
import util.Common;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	final UserDAO user_dao;
	
    @Autowired
    private SessionService sessionService;
	
	// ����� ���� ȭ�� ����
	@RequestMapping("user_view")
	public String user_view(Model model) {	
		
        if (model != null) {
            UserDTO dto = sessionService.getUserFromSession();
            System.out.println("model is not null");
            if (dto != null) {
                model.addAttribute("dto", dto); // Add attribute with a name	
                System.out.println("dto is not null");
            } else {
            	System.out.println("dto NULL");
            }
        } else {
        	System.out.println("model NULL");
        }
        
		return Common.USER_PATH+"user_view.jsp";
	}
	
	// ����� ���� �����ϱ� �� ��й�ȣ Ȯ�� ������ �̵�
	@RequestMapping("user_pw_auth_form")
	public String user_pw_auth_form(Model model) {
		return Common.USER_PATH+"pw_auth_form.jsp";
	}
	
	// ����� ���� ���� ������ �̵�	// �̿ϼ�
	@RequestMapping("user_modify_form")
	public String user_modify_form(Model model) {
		return Common.USER_PATH+"user_modify_form.jsp";
	}

}
