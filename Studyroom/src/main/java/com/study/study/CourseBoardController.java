package com.study.study;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.FileManager;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class CourseBoardController {
	
	 final CourseDAO course_dao;
	 final CourseBoardDAO course_board_dao;
//	 final UserDAO user_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	// FileManager Ŭ���� �ν��Ͻ� ����
	FileManager fileManager = new FileManager();
		
	String webPath = "/resources/upload/"; // ������Ʈ�� ���
	
	// �ڽ� ������ ��ü�� ����������
	@RequestMapping("course_board_list")
	public String course_board_list(Model model, Integer course_id, @RequestParam(required=false, defaultValue="1") int page) {
		
		// FileManager�� ���� ���� ��θ� request�κ��� �޾ƿ� �����ϱ�
		if (fileManager.getSavePath() == null) {

			String realPath = request.getServletContext().getRealPath(webPath);
			fileManager.setSavePath(realPath);
	***REMOVED***
		
		// ����, ���� ������ ���
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// ������ ������ map�� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
	
		// ������ ��ȣ�� ���� ��ü �Խñ� ��ȸ
		List<CourseBoardDTO> list = course_board_dao.selectList(map, course_id); // test�� course_id = 1
		
		// ��ü �Խñ� �� ��ȸ
		int rowTotal = course_board_dao.getRowTotal(course_id);
		
		// course�� ���� ��������
		CourseDTO course_dto = course_dao.selectOne(course_id);
		
		// ������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("course_board_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		// �������� ������ ������
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		model.addAttribute("course_id", course_id);
		model.addAttribute("course_dto", course_dto);
		
		return Common.COURSE_PATH +"course_board_list.jsp?page=" + page;
***REMOVED***
	
	// �ڽ� ������ �󼼺���
	@RequestMapping("course_board_view")
	public String course_board_view(Model model, int id, int page) {
		
		// id�� ������ ��ȸ�ϱ�
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// �������� ��ȸ�� ������ ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_view.jsp?page=" + page;
***REMOVED***
	
	// �ڽ� ������ �߰��ϱ� ������ �̵�
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form() {
		// �α��� Ȯ�� �� ���� Ȯ�� �߰� ����
//		UserDTO show = (UserDTO)session.getAttribute("id");
//		
//		if (show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//	***REMOVED***
		
		return Common.ADMIN_PATH + "course_board_insert_form.jsp";
***REMOVED***
	
	
	// �ڽ� ������ �߰��ϱ�
	@RequestMapping("course_board_insert")
	public String course_board_insert(CourseBoardDTO dto) {
		
		// ���� ���ε带 �����ϰ� dto�� ���� �̸� ����
		fileManager.fileUpload(dto);
		
		// ������ �߰�
		int res = course_board_dao.insert(dto);
	
		// �߰� �Ϸ� �� ������ ���� �������� ���ư���
		if (res > 0) {
			return "course_board_list";
	***REMOVED***
		
		return "";
***REMOVED***
	
	// �ڽ� ������ ���� ������ �̵�
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(Model model, int id) {
		// �α��� Ȯ�� �� ���� Ȯ�� �߰� ����
//		MemberDTO show = (MemberDTO)session.getAttribute("id");
//		
//		if(show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//	***REMOVED***
		
		// ��û ���������� �������� id�� �޾� �������� ��ȸ
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// ������ ��ü�� ���� �������� ������
		model.addAttribute("dto", dto);
		
		return Common.ADMIN_PATH + "course_board_modify_form.jsp";
***REMOVED***
	
	// �ڽ� ������ �����ϱ�
	@RequestMapping("course_board_modify")
	public String course_board_modify(CourseBoardDTO dto, int id, int page, int delete_flag) {

		// ���� origin_dto�� id�� ��ȸ
		CourseBoardDTO origin_dto = course_board_dao.selectOne(id);
		
		// ���� ���ε带 �����ϰ� dto�� ���� �̸� ����
		// ���� ÷�� ���� ���� ��û�� ������ ������ ����
		fileManager.fileUpload(dto, origin_dto, delete_flag);
		
		// ������ ������ origin_dto�� ����
		origin_dto.setTitle(dto.getTitle());
		origin_dto.setContent(dto.getContent());
		
		// ������ ����
		int res = course_board_dao.modify(origin_dto);
		
		// ������ ���� �Ϸ� �� ajax�� ���� �޽��� ����
		if (res > 0) {
			return "redirect:course_board_view?id="+dto.getId()+"&page="+page;
	***REMOVED***
		
		return "/";
***REMOVED***
	
	// �ڽ� ������ ������ ��ó�� �����ϱ�
	@RequestMapping("course_board_delete")
	@ResponseBody
	public String course_board_delete(int id) {
		// ���� ���� ����
		
		// ������ ������ ��ó�� �����ϱ�(���� ����)
		int res = course_board_dao.delete_update(id);
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***
	
	// �ڽ� ������ ������ ����
	@RequestMapping("course_board_delete_physical")
	@ResponseBody
	public String course_board_delete_physical() {
		// ���� ���� ����
		
		// ������ DB���� �����ϱ�(������ ����)
		int res = course_board_dao.delete_physical();
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***

	// ÷�� ���� �ٿ�ε�
	@RequestMapping("course_board_filedownload")
	public String course_board_filedownload(Model model, int id) {
		
		// id�� CourseBoardDTO ��ȸ
		CourseBoardDTO dto = course_board_dao.selectOne(id);

		// ���� �ٿ�ε带 ó���� �������� dto�� fileManager�� ������
		model.addAttribute("dto", dto);
		model.addAttribute("fileManager", fileManager);
		
		return Common.COURSE_PATH + "filedownload.jsp";
***REMOVED***
		
	
***REMOVED***
