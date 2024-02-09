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
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		return Common.COURSE_PATH +"course_board_list.jsp?page=" + page;
	}
	
	// �ڽ� ������ �󼼺���
	@RequestMapping("course_board_view")
	public String course_board_view(Model model, int id, int page) {
		
		// id�� ������ ��ȸ�ϱ�
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// �������� ��ȸ�� ������ ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_view.jsp?page=" + page;
	}
	
	// �ڽ� ������ �߰��ϱ� ������ �̵�
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form() {
		// �α��� Ȯ�� �� ���� Ȯ�� �߰� ����
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

		// ������ �߰�
		int res = course_board_dao.insert(dto);
	
		// �߰� �Ϸ� �� ������ ���� �������� ���ư���
		if (res > 0) {
			return "course_board_list";
		}
		
		return "";
	}
	
	// �ڽ� ������ ���� ������ �̵�
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(Model model, int id) {
		// �α��� Ȯ�� �� ���� Ȯ�� �߰� ����
//		MemberDTO show = (MemberDTO)session.getAttribute("id");
//		
//		if(show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//		}
		
		// ��û ���������� �������� id�� �޾� �������� ��ȸ
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// ������ ��ü�� ���� �������� ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_modify_form.jsp";
	}
	
	// �ڽ� ������ �����ϱ�
	@RequestMapping("course_board_modify")
	public String course_board_modify(CourseBoardDTO dto) {
		
		// ���� ���ε� ���� Ŭ������ �ν��Ͻ�
		UploadFile uploadFile = new UploadFile();
		
		// ���� ���ε带 �����ϰ� dto�� ���� �̸� ����
		uploadFile.fileUpload(dto, request);
		
		// ������ ����
		int res = course_board_dao.modify(dto);
		
		// ������ ���� �Ϸ� �� ������ ���� ȭ������ ���ư���
		if (res > 0) {
			return "redirect:course_board_list";
		}
		
		return "";
	}
	
	// �ڽ� ������ ������ ��ó�� �����ϱ�
	@RequestMapping("course_board_delete")
	public String course_board_delete(int id) {
		// ���� ���� ����
		
		// ������ ������ ��ó�� �����ϱ�(���� ����)
		int res = course_board_dao.delete_update(id);
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	// �ڽ� ������ ������ ����
	@RequestMapping("course_board_delete_physical")
	public String course_board_delete_physical() {
		// ���� ���� ����
		
		// ������ DB���� �����ϱ�(������ ����)
		int res = course_board_dao.delete_physical();
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	
	
	// ajax �׽�Ʈ�� �޼ҵ�
	// �ڽ� ������ �󼼺���
//	@RequestMapping("ajax_test")
//	@ResponseBody
//	public String ajax_test(Model model, int id) {
//
//		// id�� ������ ��ȸ�ϱ�
//		CourseBoardDTO DTO = course_board_dao.selectOne(id);
//		
//		// �������� ��ȸ�� ������ ������
//		model.addAttribute("DTO", DTO);
//		
//		System.out.println(DTO);
//		
//		if (DTO != null) {
//			return "[{'result':'yes'}]";
//		} else {
//			return "[{'result':'no'}]";
//		}
//		
//	}
	
	
}
