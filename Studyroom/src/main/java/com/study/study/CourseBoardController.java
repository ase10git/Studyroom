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

import dao.CourseBoardDAO;
import dao.CourseDAO;
import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.Paging;
import util.UploadFile;

@Controller
@RequiredArgsConstructor
public class CourseBoardController {
	
	 final CourseDAO course_dao;
	 final CourseBoardDAO course_board_dao;
//	 final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
		
	// �ڽ� ������ ��ü�� ����������
	@RequestMapping("course_board_list")
	public String course_board_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		// ����, ���� ������ ���
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// ������ ������ map�� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
	
		// ������ ��ȣ�� ���� ��ü �Խñ� ��ȸ
		List<CourseBoardDTO> list = course_board_dao.selectList(map);
		
		// ��ü �Խñ� �� ��ȸ
		int rowTotal = course_board_dao.getRowTotal();
		
		// ������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("course_board_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		// �������� ������ ������
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.COURSE_PATH +"course_board_list.jsp?page="+page;
	}
	
	// �ڽ� ������ �󼼺���
	@RequestMapping("course_board_view")
	public String course_board_view(Model model, int idx, int page) {
		
		// id�� ������ ��ȸ�ϱ�
		CourseBoardDTO dto = course_board_dao.selectOne(idx);
		
		// �������� ��ȸ�� ������ ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_view.jsp?page="+page;
	}
	
	// �ڽ� ������ �߰��ϱ� ������ �̵�
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form() {
//		UserDTO show = (UserDTO)session.getAttribute("id");
//		
//		if (show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//		}
		
		return Common.COURSE_PATH + "course_board_insert_form.jsp";
	}
	
	
	// �ڽ� ������ �߰��ϱ�
	@RequestMapping("course_board_insert")
	public String course_board_insert(CourseBoardDTO dto) {

		// ���� ���ε� ���� Ŭ������ �ν��Ͻ�
		UploadFile uploadFile = new UploadFile();
		
		// ���� ���ε带 �����ϰ� dto�� ���� �̸� ����
		uploadFile.fileUpload(dto, request);
		
		int res = course_board_dao.insert(dto);
	
		if (res > 0) {
//			return "redirect:board_list?page="+page;
		}
		
		return "";
	}
	
	// �ڽ� ������ ���� ������ �̵�
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form() {
//		MemberDTO show = (MemberDTO)session.getAttribute("id");
//		
//		if(show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//		}
		
		return Common.COURSE_PATH + "course_board_modify_form.jsp";
	}
	
	// �ڽ� ������ �����ϱ�
	@RequestMapping("course_board_modify")
	public String course_board_modify(CourseBoardDTO dto) {
		
		int res = course_board_dao.modify(dto);
		
		if (res > 0) {
//			return "redirect:board_list?page="+page;
		}
		
		return "";
	}
	
	
	// �ڽ� ������ ������ ��ó�� �����ϱ�
	@RequestMapping("course_board_delete")
	public String course_board_delete(int id) {

		int res = course_board_dao.delete_update(id);
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	// �ڽ� �� ������ ����
	@RequestMapping("course_board_delete_physical")
	public String course_board_delete_physical(int id) {

		int res = course_board_dao.delete_physical(id);
	
		if (res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
}
