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
	
	// 코스 화면 보기 - 리스트
	@RequestMapping("course_list")
	public String course_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {

		// 시작, 종료 페이지 계산
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// 페이지 정보를 map에 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		// 페이지 번호에 따른 전체 코스 조회
		List<CourseDTO> list = course_dao.selectList(map);
		
		// 전체 게시글 수 조회
		int rowTotal = course_dao.getRowTotal();
		
		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("course_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.COURSE_PATH + "course_list.jsp?page=" + page;
	}
	
	// 코스 상세 보기
	@RequestMapping("course_view")
	public String course_view(Model model, int id, int page) {	
		
		// id로 코스 조회하기
		CourseDTO dto = course_dao.selectOne(id);
		
		// 페이지에 코스 포워딩
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_view.jsp?page=" + page;
	}

	
	// 코스 추가 페이지로 이동
	@RequestMapping("course_insert_form")
	public String course_insert_form() {
		// 로그인 확인 및 권한 확인 추가 예정
//		UserDTO user = user_dao.select(int id);
//		
//		if (user.role == "admin" || user.role == "mentor") {
//			return Common.COURSE_PATH + "course_insert_form.jsp";
//		}
		
		return Common.COURSE_PATH + "course_insert_form.jsp";
//		return Common.COURSE_PATH + "error_page.jsp";
	}
	
	
	// 코스 추가하기
	@RequestMapping("course_insert")
	public String course_insert(CourseDTO dto) {
		
		// 코스 추가
		int res = course_dao.insert(dto);
	
		// 코스 추가 완료 시 코스 보기 화면으로 
		if (res > 0) {
			return "redirect:course_list";
		}
		
		return "";
	}
	
	
	// 코스 수정 페이지로 이동
	@RequestMapping("course_modify_form")
	public String course_modify_form(Model model, int id) {
		// 로그인 확인 및 권한 확인 추가 예정
//		UserDTO user = user_dao.select(int id);
//		
//		if (user.role == "admin" || user.role == "mentor") {
//			return Common.Board.VIEW_PATH + "course_modify_form.jsp";
//		}
		
		// 요청 페이지에서 코스의 id를 받아 코스 조회
		CourseDTO dto = course_dao.selectOne(id);
		
		// 코스 객체를 수정 페이지로 포워딩
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_modify_form.jsp";
//		return Common.COURSE_PATH + "error_page.jsp";
	}
	
	
	// 코스 수정하기
	@RequestMapping("course_modify")
	public String course_modify(CourseDTO dto) {

		// 코스 수정
		int res = course_dao.modify(dto);

		// 코스 수정 완료 시 코스 보는 화면으로 돌아가기
		if (res > 0) {
			return "redirect:course_list";
		}
		
		return "";
	}
	
	// 코스 삭제된 것처럼 수정하기(논리적 삭제)
	@RequestMapping("course_delete")
	public String course_delete(int id) {
		// 권한 설정 예정
		
		int res = course_dao.delete_update(id);
	
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	// 코스 물리적 삭제
	@RequestMapping("course_delete_physical")
	public String course_delete_physical() {

		int res = course_dao.delete_physical();
	
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
}
