package com.study.study;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CourseDAO;
import dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class CourseController {
	
	final CourseDAO course_dao;
	//final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;	
	
	// �ڽ� ȭ�� ���� - ����Ʈ
	@RequestMapping("course_list")
	public String course_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {

		// ����, ���� ������ ���
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// ������ ������ map�� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		// ������ ��ȣ�� ���� ��ü �ڽ� ��ȸ
		List<CourseDTO> list = course_dao.selectList(map);
		
		// ��ü �Խñ� �� ��ȸ
		int rowTotal = course_dao.getRowTotal();
		
		// ������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("course_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.COURSE_PATH + "course_list.jsp?page=" + page;
	}
	
	// �ڽ� �� ����
	@RequestMapping("course_view")
	public String course_view(Model model, int id, int page) {	
		
		// id�� �ڽ� ��ȸ�ϱ�
		CourseDTO dto = course_dao.selectOne(id);
		
		// �������� �ڽ� ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_view.jsp?page=" + page;
	}

	
	// �ڽ� �߰� �������� �̵�
	@RequestMapping("course_insert_form")
	public String course_insert_form() {
		// �α��� Ȯ�� �� ���� Ȯ�� �߰� ����
//		UserDTO user = user_dao.select(int id);
//		
//		if (user.role == "admin" || user.role == "mentor") {
//			return Common.COURSE_PATH + "course_insert_form.jsp";
//		}
		
		return Common.COURSE_PATH + "course_insert_form.jsp";
//		return Common.COURSE_PATH + "error_page.jsp";
	}
	
	
	// �ڽ� �߰��ϱ�
	@RequestMapping("course_insert")
	public String course_insert(CourseDTO dto) {
		
		// �ڽ� �߰�
		int res = course_dao.insert(dto);
	
		// �ڽ� �߰� �Ϸ� �� �ڽ� ���� ȭ������ 
		if (res > 0) {
			return "redirect:course_list";
		}
		
		return "";
	}
	
	
	// �ڽ� ���� �������� �̵�
	@RequestMapping("course_modify_form")
	public String course_modify_form(Model model, int id) {
		// �α��� Ȯ�� �� ���� Ȯ�� �߰� ����
//		UserDTO user = user_dao.select(int id);
//		
//		if (user.role == "admin" || user.role == "mentor") {
//			return Common.Board.VIEW_PATH + "course_modify_form.jsp";
//		}
		
		// ��û ���������� �ڽ��� id�� �޾� �ڽ� ��ȸ
		CourseDTO dto = course_dao.selectOne(id);
		
		// �ڽ� ��ü�� ���� �������� ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_modify_form.jsp";
//		return Common.COURSE_PATH + "error_page.jsp";
	}
	
	
	// �ڽ� �����ϱ�
	@RequestMapping("course_modify")
	public String course_modify(CourseDTO dto) {

		// �ڽ� ����
		int res = course_dao.modify(dto);

		// �ڽ� ���� �Ϸ� �� �ڽ� ���� ȭ������ ���ư���
		if (res > 0) {
			return "redirect:course_list";
		}
		
		return "";
	}
	
	// �ڽ� ������ ��ó�� �����ϱ�(���� ����)
	@RequestMapping("course_delete")
	public String course_delete(int id) {
		// ���� ���� ����
		
		int res = course_dao.delete_update(id);
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	// �ڽ� ������ ����
	@RequestMapping("course_delete_physical")
	public String course_delete_physical() {

		int res = course_dao.delete_physical();
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
}
