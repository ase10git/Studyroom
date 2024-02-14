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

import dao.CourseDAO;
import dto.CourseDTO;
import dto.UserCourseDTO;
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
	// admin�� ��� ����
	@RequestMapping("course_list")
	public String course_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {

		// ****************** ������ - �׽�Ʈ�� user_id **********************
		int user_id = 5;
		String role = "mentor";
		// ***************************************************************
		
		// ����, ���� ������ ���
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// ������ ������ map�� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		// ��ü �Խñ� �� ��ȸ
		int rowTotal = 0;
		
		// ��ü �ڽ� list
		List<CourseDTO> list = null; // ������
		List<UserCourseDTO> list_user = null; // �л��� ����
		
		if (role.equals("admin")) { // �������� ���
			// ������ ��ȣ�� ���� ��ü �ڽ� ��ȸ
			list = course_dao.selectList(map);

			rowTotal = course_dao.getRowTotal(); // ��ü �ڽ� ����
		
	***REMOVED*** else { // �л��̳� ������ ���
			map.put("user_id", user_id); // map�� ����� ���� ����

			// ������ ��ȣ�� ���� Ư�� ������� �ڽ� ��ü ��ȸ
			list_user = course_dao.selectList_user(map);
			
			// Ư�� ����ڰ� ���� �ڽ��� ��ü �Խñ� ��
			rowTotal = course_dao.getRowTotal_user(user_id);
	***REMOVED***
		
		// ������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("course_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		// �����ڶ�� ��ü �ڽ� ��ȸ ������ ������
		if (role.equals("admin")) {
			model.addAttribute("list", list);
	***REMOVED*** else { // �л��� ������ ������ �ڽ��� ��ȸ ������ ������
			model.addAttribute("list", list_user);
	***REMOVED***
		// ������ �޴��� ������
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.COURSE_PATH + "course_list.jsp?page=" + page;
***REMOVED***
		
	// �ڽ� �� ����
	@RequestMapping("course_view")
	public String course_view(Model model, int id, int page) {	
		
		// id�� �ڽ� ��ȸ�ϱ�
		CourseDTO dto = course_dao.selectOne(id);
		
		// �������� �ڽ� ������
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_view.jsp?page=" + page;
***REMOVED***

	
	// �ڽ� �߰� �������� �̵�
	// admin�� ����
	@RequestMapping("course_insert_form")
	public String course_insert_form() {

		return Common.ADMIN_PATH + "course_insert_form.jsp";

		//return Common.COURSE_PATH + "error_page.jsp";
***REMOVED***
	
	
	// �ڽ� �߰��ϱ�
	// admin�� ����
	@RequestMapping("course_insert")
	public String course_insert(CourseDTO dto) {

		// �ڽ� �߰�
		int res = course_dao.insert(dto);
	
		// �ڽ� �߰� �Ϸ� �� �ڽ� ���� ȭ������ 
		if (res > 0) {
			return "redirect:course_list";
	***REMOVED***
		
		return "";
***REMOVED***
	
	
	// �ڽ� ���� �������� �̵�
	// admin�� ����
	@RequestMapping("course_modify_form")
	public String course_modify_form(Model model, int id) {
		
		// ��û ���������� �ڽ��� id�� �޾� �ڽ� ��ȸ
		CourseDTO dto = course_dao.selectOne(id);
		
		// �ڽ� ��ü�� ���� �������� ������
		model.addAttribute("dto", dto);
		
		return Common.ADMIN_PATH + "course_modify_form.jsp";
//		return Common.COURSE_PATH + "error_page.jsp";
***REMOVED***
	
	
	// �ڽ� �����ϱ�
	// admin�� ����
	@RequestMapping("course_modify")
	public String course_modify(CourseDTO dto, int id) {

		// ���� ������ dto�� id�� ����
		dto.setId(id);
		
		// �ڽ� ����
		int res = course_dao.modify(dto);

		// �ڽ� ���� �Ϸ� �� �ڽ� ���� ȭ������ ���ư���
		if (res > 0) {
			return "redirect:course_list";
	***REMOVED***
		
		return "";
***REMOVED***
	
	// �ڽ� ������ ��ó�� �����ϱ�(���� ����)
	// admin�� ����
	@RequestMapping("course_delete")
	@ResponseBody
	public String course_delete(int id) {
		
		int res = course_dao.delete_update(id);
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***
	
	// �ڽ� ������ ����
	// admin�� ����
	@RequestMapping("course_delete_physical")
	@ResponseBody
	public String course_delete_physical() {

		int res = course_dao.delete_physical();
	
		if (res == 1) { // ajax �ݹ� �޼ҵ忡 ������ ����
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***
***REMOVED***
