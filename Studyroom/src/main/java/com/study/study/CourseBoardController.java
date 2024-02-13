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
	
	// FileManager 클래스 인스턴스 생성
	FileManager fileManager = new FileManager();
		
	String webPath = "/resources/upload/"; // 프로젝트상 경로
	
	// 코스 공지글 전체를 페이지별로
	@RequestMapping("course_board_list")
	public String course_board_list(Model model, Integer course_id, @RequestParam(required=false, defaultValue="1") int page) {
		
		// FileManager의 파일 저장 경로를 request로부터 받아와 저장하기
		if (fileManager.getSavePath() == null) {

			String realPath = request.getServletContext().getRealPath(webPath);
			fileManager.setSavePath(realPath);
	***REMOVED***
		
		// 시작, 종료 페이지 계산
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// 페이지 정보를 map에 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
	
		// 페이지 번호에 따른 전체 게시글 조회
		List<CourseBoardDTO> list = course_board_dao.selectList(map, course_id); // test용 course_id = 1
		
		// 전체 게시글 수 조회
		int rowTotal = course_board_dao.getRowTotal(course_id);
		
		// course의 정보 가져오기
		CourseDTO course_dto = course_dao.selectOne(course_id);
		
		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("course_board_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		// 페이지에 데이터 포워딩
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		model.addAttribute("course_id", course_id);
		model.addAttribute("course_dto", course_dto);
		
		return Common.COURSE_PATH +"course_board_list.jsp?page=" + page;
***REMOVED***
	
	// 코스 공지글 상세보기
	@RequestMapping("course_board_view")
	public String course_board_view(Model model, int id, int page) {
		
		// id로 공지글 조회하기
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// 페이지에 조회한 공지글 포워딩
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_view.jsp?page=" + page;
***REMOVED***
	
	// 코스 공지글 추가하기 페이지 이동
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form() {
		// 로그인 확인 및 권한 확인 추가 예정
//		UserDTO show = (UserDTO)session.getAttribute("id");
//		
//		if (show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//	***REMOVED***
		
		return Common.ADMIN_PATH + "course_board_insert_form.jsp";
***REMOVED***
	
	
	// 코스 공지글 추가하기
	@RequestMapping("course_board_insert")
	public String course_board_insert(CourseBoardDTO dto) {
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		fileManager.fileUpload(dto);
		
		// 공지글 추가
		int res = course_board_dao.insert(dto);
	
		// 추가 완료 시 공지글 보는 페이지로 돌아가기
		if (res > 0) {
			return "course_board_list";
	***REMOVED***
		
		return "";
***REMOVED***
	
	// 코스 공지글 수정 페이지 이동
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(Model model, int id) {
		// 로그인 확인 및 권한 확인 추가 예정
//		MemberDTO show = (MemberDTO)session.getAttribute("id");
//		
//		if(show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//	***REMOVED***
		
		// 요청 페이지에서 공지글의 id를 받아 공지글을 조회
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// 공지글 객체를 수정 페이지로 포워딩
		model.addAttribute("dto", dto);
		
		return Common.ADMIN_PATH + "course_board_modify_form.jsp";
***REMOVED***
	
	// 코스 공지글 수정하기
	@RequestMapping("course_board_modify")
	public String course_board_modify(CourseBoardDTO dto, int id, int page, int delete_flag) {

		// 원본 origin_dto를 id로 조회
		CourseBoardDTO origin_dto = course_board_dao.selectOne(id);
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		// 만약 첨부 파일 삭제 요청이 있으면 삭제를 진행
		fileManager.fileUpload(dto, origin_dto, delete_flag);
		
		// 수정한 내용을 origin_dto에 저장
		origin_dto.setTitle(dto.getTitle());
		origin_dto.setContent(dto.getContent());
		
		// 공지글 수정
		int res = course_board_dao.modify(origin_dto);
		
		// 공지글 수정 완료 시 ajax를 위한 메시지 전송
		if (res > 0) {
			return "redirect:course_board_view?id="+dto.getId()+"&page="+page;
	***REMOVED***
		
		return "/";
***REMOVED***
	
	// 코스 공지글 삭제된 것처럼 수정하기
	@RequestMapping("course_board_delete")
	@ResponseBody
	public String course_board_delete(int id) {
		// 권한 설정 예정
		
		// 공지글 삭제된 것처럼 수정하기(논리적 삭제)
		int res = course_board_dao.delete_update(id);
	
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***
	
	// 코스 공지글 물리적 삭제
	@RequestMapping("course_board_delete_physical")
	@ResponseBody
	public String course_board_delete_physical() {
		// 권한 설정 예정
		
		// 공지글 DB에서 삭제하기(물리적 삭제)
		int res = course_board_dao.delete_physical();
	
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
	***REMOVED***

***REMOVED***

	// 첨부 파일 다운로드
	@RequestMapping("course_board_filedownload")
	public String course_board_filedownload(Model model, int id) {
		
		// id로 CourseBoardDTO 조회
		CourseBoardDTO dto = course_board_dao.selectOne(id);

		// 파일 다운로드를 처리할 페이지에 dto와 fileManager를 포워딩
		model.addAttribute("dto", dto);
		model.addAttribute("fileManager", fileManager);
		
		return Common.COURSE_PATH + "filedownload.jsp";
***REMOVED***
		
	
***REMOVED***
