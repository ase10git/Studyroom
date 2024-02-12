package com.study.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CourseBoardDAO;
import dao.CourseDAO;
import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

// 관리자만 수행할 수 있는 동작을 저장한 클래스

@Controller
@RequiredArgsConstructor
public class AdminController {
	 
	final CourseDAO course_dao;
	final CourseBoardDAO course_board_dao;
	//final UserDAO user_dao;
	//final CustomerServiceDAO cs_dao;
	//final CommunityDAO community_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
		
	@RequestMapping("delete_management")
	public String delete_management(Model model) {
		
		// del_flag = -1인 코스 조회
		// 현재 DB에 course는 DEL_FLAG 컬럼이 없어서 일반 조회로 대체함
//		List<CourseDTO> course_list = course_dao.deleteList();
		
		// del_flag = -1인 코스 공지글 조회
		List<CourseBoardDTO> course_board_list = course_board_dao.deleteList();
		
		// 데이터를 삭제 관리 페이지에 포워딩
//		model.addAttribute("course_list", course_list);
		model.addAttribute("course_board_list", course_board_list);
	
		return  Common.ADMIN_PATH + "delete_management.jsp";
		
***REMOVED***
	 
***REMOVED***
