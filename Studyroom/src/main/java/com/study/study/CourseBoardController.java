package com.study.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	// 코스 화면 보기 - 리스트
	@RequestMapping("course_list")
	public String course_list(Model model) {
		
		
		return "course_list.jsp";
***REMOVED***
	
	// 코스 상세 보기
	@RequestMapping("course_view")
	public String course_view(Model model) {
		
		return "course_view.jsp";
***REMOVED***
	
	
	// 코스 글 삭제하기
	@RequestMapping("course_board_delete")
	public String course_board_delete(int idx); 
	
	
	// 코스 새 글 추가하기 페이지 이동
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form(); 
	
	
	// 코스 새 글 추가하기
	@RequestMapping("course_board_insert")
	public String course_board_insert(); 
			
	
	// 코스 글 수정 페이지 이동
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(); 
	
	
	// 코스 글 수정하기
	@RequestMapping("course_board_modify")
	public String course_board_modify(int idx);
	
	// 코스 댓글 추가
	@RequestMapping("course_board_reply_insert")
	public String course_board_reply_insert();
	
	// 첨부 파일 다운로드
	@RequestMapping("course_board_filedownload")
	public String course_board_filedownload();
	
	
	// 코스 추가 페이지로 이동
	@RequestMapping("course_insert_form")
	public String course_insert_form();
	
	
	// 코스 추가하기
	@RequestMapping("course_insert")
	public String course_insert();
	
	
	// 코스 수정 페이지로 이동
	@RequestMapping("course_modify_form")
	public String course_modify_form();
	
	
	// 코스 수정하기
	@RequestMapping("course_modify")
	public String course_modify();
	
	
	// 코스 삭제하기
	@RequestMapping("course_delete")
	public String course_delete();
***REMOVED***
