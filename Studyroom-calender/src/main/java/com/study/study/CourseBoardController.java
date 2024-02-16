package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseBoardController {
	
	// final CourseDAO course_dao;
	// final CourseBoardDAO course_dao;
	
//	@Autowired
//	HttpServletRequest request;
//	
//	@Autowired
//	HttpSession session;
	
	// �ڽ� ȭ�� ���� - ����Ʈ
	@RequestMapping("course_list")
	public String course_list(Model model) {
		
		
		return "course_list.jsp";
	}
	
	// �ڽ� �� ����
	@RequestMapping("course_view")
	public String course_view(Model model) {
		
		return "course_view.jsp";
	}
	
	
	// �ڽ� �� �����ϱ�
	@RequestMapping("course_board_delete")
	public String course_board_delete(int idx); 
	
	
	// �ڽ� �� �� �߰��ϱ� ������ �̵�
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form(); 
	
	
	// �ڽ� �� �� �߰��ϱ�
	@RequestMapping("course_board_insert")
	public String course_board_insert(); 
			
	
	// �ڽ� �� ���� ������ �̵�
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(); 
	
	
	// �ڽ� �� �����ϱ�
	@RequestMapping("course_board_modify")
	public String course_board_modify(int idx);
	
	// �ڽ� ��� �߰�
	@RequestMapping("course_board_reply_insert")
	public String course_board_reply_insert();
	
	// ÷�� ���� �ٿ�ε�
	@RequestMapping("course_board_filedownload")
	public String course_board_filedownload();
	
	
	// �ڽ� �߰� �������� �̵�
	@RequestMapping("course_insert_form")
	public String course_insert_form();
	
	
	// �ڽ� �߰��ϱ�
	@RequestMapping("course_insert")
	public String course_insert();
	
	
	// �ڽ� ���� �������� �̵�
	@RequestMapping("course_modify_form")
	public String course_modify_form();
	
	
	// �ڽ� �����ϱ�
	@RequestMapping("course_modify")
	public String course_modify();
	
	
	// �ڽ� �����ϱ�
	@RequestMapping("course_delete")
	public String course_delete();
}
