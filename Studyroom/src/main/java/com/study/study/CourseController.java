package com.study.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CourseBoardDAO;
import dao.CourseDAO;
import dto.CourseDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CourseController {
	
//	final CourseDAO course_dao;
//	final CourseBoardDAO course_board_dao;
//	//final UserDAO user_dao;
//	
//	@Autowired
//	HttpServletRequest request;
//	
//	@Autowired
//	HttpSession session;	
//	
//	// �ڽ� ȭ�� ���� - ����Ʈ
//	@RequestMapping("course_list")
//	public String course_list(Model model) {
//
//		// ������ ��ȣ�� ���� ��ü �Խñ� ��ȸ
//		List<CourseDTO> list = course_dao.selectList();
//		
//		model.addAttribute("list", list);
//		model.addAttribute("pageMenu", pageMenu);
//		
//		return "course_list.jsp";
//***REMOVED***
//	
//	// �ڽ� �� ����
//	@RequestMapping("course_view")
//	public String course_view(Model model, int idx) {	
//		
//		CourseDTO dto = course_dao.selectOne(idx);
//		
//		model.addAttribute("dto", dto);
//		return "course_view.jsp";
//***REMOVED***
//
//	
//	// �ڽ� �߰� �������� �̵�
//	@RequestMapping("course_insert_form")
//	public String course_insert_form() {
//		
////		UserDTO user = user_dao.select(int id);
////		
////		if (user.role == "admin" || user.role == "mentor") {
////			return Common.Board.VIEW_PATH + "course_insert_form.jsp";
////	***REMOVED***
//		
//		return "not allowed";
//***REMOVED***
//	
//	
//	// �ڽ� �߰��ϱ�
//	@RequestMapping("course_insert")
//	public String course_insert(CourseDTO dto) {
//		
//		int res = course_dao.insert(dto);
//	
//		if (res > 0) {
//			return "redirect:board_list";
//	***REMOVED***
//		
//		return ;
//***REMOVED***
//	
//	
//	// �ڽ� ���� �������� �̵�
//	@RequestMapping("course_modify_form")
//	public String course_modify_form() {
//		
////		UserDTO user = user_dao.select(int id);
////		
////		if (user.role == "admin" || user.role == "mentor") {
////			return Common.Board.VIEW_PATH + "course_modify_form.jsp";
////	***REMOVED***
//		
//		return "not allowed";
//***REMOVED***
//	
//	
//	// �ڽ� �����ϱ�
//	@RequestMapping("course_modify")
//	public String course_modify(CourseDTO dto) {
//		
//		int res = course_dao.modify(dto);
//
//		return;
//***REMOVED***
//	
//	// �ڽ� �����ϱ�
//	@RequestMapping("course_delete")
//	public String course_delete(int idx) {
//		CourseDTO ori_dto = course_dao.selectOne(idx);
//
//		ori_dto.setDel_flag(-1);
//		
//		int res = course_dao.delete_update(ori_dto);
//	
//		if (res == 1) {
//			return "[{'result':'yes'***REMOVED***]";
//	***REMOVED*** else {
//			return "[{'result':'no'***REMOVED***]";
//	***REMOVED***
//
//***REMOVED***
//	
//	// �ڽ� ������ ����
//	@RequestMapping("course_delete_physical")
//	public String course_delete_physical(int idx) {
//		CourseDTO ori_dto = course_dao.selectOne(idx);
//
//		ori_dto.setDel_flag(-1);
//		
//		int res = course_dao.delete_physical(ori_dto);
//	
//		if (res == 1) {
//			return "[{'result':'yes'***REMOVED***]";
//	***REMOVED*** else {
//			return "[{'result':'no'***REMOVED***]";
//	***REMOVED***
//
//***REMOVED***
***REMOVED***
