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
import dao.UserCourseViewDAO;
import dao.UserDAO;
import dto.CourseDTO;
import dto.UserCourseViewDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class CourseController {
	
	final UserDAO user_dao;
	final CourseDAO course_dao;
	final CourseBoardDAO course_board_dao;
	final UserCourseViewDAO uc_view_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;	

	// 코스 화면 보기 - 리스트
	@RequestMapping("course_list")
	public String course_list(Model model, int id, @RequestParam(required=false, defaultValue="1") int page) {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_session = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_session == null) return "/";
		// 사용자가 url로 다른 사용자 정보 페이지 접근 차단(관리자 제외)
		if (!user_session.getRole().equals("admin")) {
			if (user_session.getId() != id) {
				return "/error";
		***REMOVED***
	***REMOVED***
		
		// *** 세션에서가 아닌 파라미터에서 넘어온 id를 통해 가져온 user_dto 객체 준비 ***
		UserDTO user_dto = user_dao.selectOne(id);
		
		// 사용자의 번호를 세션에서 가져오기
		int user_id = user_dto.getId();
		// 사용자의 권한을 세션에서 가져오기
		String role = user_dto.getRole();
		
		// 시작, 종료 페이지 계산
		int start = (page - 1) * Common.Course.BLOCKLIST + 1;
		int end = start + Common.Course.BLOCKLIST - 1;
		
		// 페이지 정보를 map에 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		// 전체 게시글 수 조회
		int rowTotal = 0;
		
		// 전체 코스 list
		List<CourseDTO> list = null; // 관리자
		List<UserCourseViewDTO> list_user = null; // 학생과 멘토
		
		if (role.equals("admin")) { // 관리자일 경우
			// 페이지 번호에 따른 전체 코스 조회
			list = course_dao.selectList(map);

			rowTotal = course_dao.getRowTotal(); // 전체 코스 개수

	***REMOVED*** else { // 학생이나 멘토일 경우
			map.put("user_id", user_id); // map에 사용자 정보 저장

			// 페이지 번호에 따른 특정 사용자의 코스 전체 조회
			list_user = uc_view_dao.selectList_user(map);
			
			// 특정 사용자가 속한 코스의 전체 게시글 수
			rowTotal = uc_view_dao.getRowTotal(user_id);
	***REMOVED***
		
		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("course_list", 
											page, 
											rowTotal, 
											Common.Course.BLOCKLIST, 
											Common.Course.BLOCKPAGE,
											user_id);
		
		// 관리자라면 전체 코스 조회 내역을 포워딩
		if (role.equals("admin")) {
			model.addAttribute("list", list);
	***REMOVED*** else { // 학생과 멘토라면 참여한 코스의 조회 내역을 포워딩
			model.addAttribute("list", list_user);
	***REMOVED***
		// 데이터를 포워딩
		model.addAttribute("user_dto", user_dto);
		model.addAttribute("pageMenu", pageMenu);
		model.addAttribute("role", role);
		
		return Common.COURSE_PATH + "course_list.jsp?id=" + user_id + "&page=" + page;
***REMOVED***
		
	// 코스 상세 보기
	@RequestMapping("course_view")
	public String course_view(Model model, int id, int page) {	
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
	***REMOVED*** else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
	***REMOVED***
		
		// id로 코스 조회하기
		CourseDTO dto = course_dao.selectOne(id);
		
		// 페이지에 코스 포워딩
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_view.jsp?page=" + page;
***REMOVED***

	
	// 코스 추가 페이지로 이동
	// admin만 가능
	@RequestMapping("course_insert_form")
	public String course_insert_form() {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
	***REMOVED*** else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
	***REMOVED***
		
		return Common.ADMIN_PATH + "course_insert_form.jsp";

		//return Common.COURSE_PATH + "error_page.jsp";
***REMOVED***
	
	
	// 코스 추가하기
	// admin만 가능
	@RequestMapping("course_insert")
	public String course_insert(CourseDTO dto, int admin_id) {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
	***REMOVED*** else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
	***REMOVED***
		
		// 코스 추가
		int res = course_dao.insert(dto);
	
		// 코스 추가 완료 시 코스 보기 화면으로 
		if (res > 0) {
			return "redirect:course_list?id="+admin_id;
	***REMOVED***
		
		return "/error";
***REMOVED***
	
	
	// 코스 수정 페이지로 이동
	// admin만 가능
	@RequestMapping("course_modify_form")
	public String course_modify_form(Model model, int id) {
		
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
	***REMOVED*** else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
	***REMOVED***
		
		// 요청 페이지에서 코스의 id를 받아 코스 조회
		CourseDTO dto = course_dao.selectOne(id);
		
		// 코스 객체를 수정 페이지로 포워딩
		model.addAttribute("dto", dto);
		
		return Common.ADMIN_PATH + "course_modify_form.jsp";
//		return Common.COURSE_PATH + "error_page.jsp";
***REMOVED***
	
	
	// 코스 수정하기
	// admin만 가능
	@RequestMapping("course_modify")
	public String course_modify(CourseDTO dto, int id) {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
	***REMOVED*** else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
	***REMOVED***
		
		// 새로 변경할 dto의 id를 저장
		dto.setId(id);
		
		// 코스 수정
		int res = course_dao.modify(dto);

		// 코스 수정 완료 시 코스 보는 화면으로 돌아가기
		if (res > 0) {
			return "redirect:course_list";
	***REMOVED***
		
		return "/error";
***REMOVED***
	
	// 코스 삭제된 것처럼 수정하기(논리적 삭제)
	// admin만 가능
	@RequestMapping("course_delete")
	@ResponseBody
	public String course_delete(int id) {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
	***REMOVED*** else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
	***REMOVED***
		
		// 코스 먼저 del_flag = -1 설정
		int res = course_dao.delete_update(id);

		// 코스의 공지글들도 논리적 삭제 처리
		int res2 = course_board_dao.delete_update_course(id);
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***
	
***REMOVED***
