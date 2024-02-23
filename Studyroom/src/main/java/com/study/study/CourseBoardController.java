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
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
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
	
	// 코스 공지글 전체를 페이지별로
	@RequestMapping("course_board_list")
	public String course_board_list(Model model, Integer course_id, @RequestParam(required=false, defaultValue="1") int page) {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		// 시작, 종료 페이지 계산
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// 페이지 정보를 map에 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		map.put("course_id", course_id);
	
		// 페이지 번호에 따른 전체 게시글 조회
		List<CourseBoardDTO> list = course_board_dao.selectList(map); // test용 course_id = 1
		
		// 전체 게시글 수 조회
		int rowTotal = course_board_dao.getRowTotal(course_id);
		
		// course의 정보 가져오기
		CourseDTO course_dto = course_dao.selectOne(course_id);
		
		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("course_board_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE,
											null);
		
		// 사용자의 권한을 세션에서 가져오기
		String role = user_dto.getRole();
		int user_id = user_dto.getId();
		
		// 페이지에 데이터 포워딩
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		model.addAttribute("course_dto", course_dto);
		model.addAttribute("user_id", user_id);
		model.addAttribute("role", role);
		
		return Common.COURSE_PATH +"course_board_list.jsp?page=" + page;
	}
	
	// 코스 공지글 상세보기
	@RequestMapping("course_board_view")
	public String course_board_view(Model model, int id, int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		// id로 공지글 조회하기
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// 사용자 권한 세션에서 가져오기
		String role = user_dto.getRole();
		
		// 페이지에 조회한 공지글 포워딩
		model.addAttribute("dto", dto);
		model.addAttribute("role", role);
		
		return Common.COURSE_PATH + "course_board_view.jsp?page=" + page;
	}
	
	// 코스 공지글 추가하기 페이지 이동
	// admin, mentor만 가능
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form() {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} // 관리자와 멘토만 접근 가능 
		else if (!user_dto.getRole().equals("admin") && !user_dto.getRole().equals("mentor")) { 
			return "/error";
		}

		return Common.ADMIN_PATH + "course_board_insert_form.jsp";
	}
	
	
	// 코스 공지글 추가하기
	// admin, mentor만 가능
	@RequestMapping("course_board_insert")
	public String course_board_insert(CourseBoardDTO dto) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} // 관리자와 멘토만 접근 가능 
		else if (!user_dto.getRole().equals("admin") && !user_dto.getRole().equals("mentor")) { 
			return "/error";
		}
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		AnnouncementController.fileManager.fileUpload(dto);
		
		// 공지글 추가
		int res = course_board_dao.insert(dto);
	
		// 코스 id 가져오기
		int isCourse = dto.getCourse_id();
		
		// 추가 완료 시 공지글 보는 페이지로 돌아가기
		if (res > 0) {
			if(isCourse == 0) {
				return "redirect:announcement_list";
			} else {
				return "redirect:course_board_list?course_id="+isCourse;
			}
		}
		
		return "/error";
	}
	
	// 코스 공지글 수정 페이지 이동
	// admin, mentor만 가능
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(Model model, int id) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} // 관리자와 멘토만 접근 가능 
		else if (!user_dto.getRole().equals("admin") && !user_dto.getRole().equals("mentor")) { 
			return "/error";
		}
		
		// 요청 페이지에서 공지글의 id를 받아 공지글을 조회
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// 공지글 객체를 수정 페이지로 포워딩
		model.addAttribute("dto", dto);
		
		return Common.ADMIN_PATH + "course_board_modify_form.jsp";
	}
	
	// 코스 공지글 수정하기
	// admin, mentor만 가능
	@RequestMapping("course_board_modify")
	public String course_board_modify(CourseBoardDTO dto, int id, int page, int delete_flag) {

		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} // 관리자와 멘토만 접근 가능 
		else if (!user_dto.getRole().equals("admin") && !user_dto.getRole().equals("mentor")) { 
			return "/error";
		}
		
		// 원본 origin_dto를 id로 조회
		CourseBoardDTO origin_dto = course_board_dao.selectOne(id);
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		// 만약 첨부 파일 삭제 요청이 있으면 삭제를 진행
		AnnouncementController.fileManager.fileUpload(dto, origin_dto, delete_flag);
		
		// 수정한 내용을 origin_dto에 저장
		origin_dto.setTitle(dto.getTitle());
		origin_dto.setContent(dto.getContent());
		
		// 공지글 수정
		int res = course_board_dao.modify(origin_dto);
		
		// 공지글 수정 완료 시 ajax를 위한 메시지 전송
		if (res > 0) {
			if (origin_dto.getCourse_id() == 0) {
				return "redirect:view?id="+dto.getId()+"&page="+page;
			} else {
				return "redirect:course_board_view?id="+dto.getId()+"&page="+page;
			}
		} else {
			return "/error";
		}
	}
	
	// 코스 공지글 삭제된 것처럼 수정하기
	// admin, mentor만 가능
	@RequestMapping("course_board_delete")
	@ResponseBody
	public String course_board_delete(int id) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} // 관리자와 멘토만 접근 가능 
		else if (!user_dto.getRole().equals("admin") && !user_dto.getRole().equals("mentor")) { 
			return "/error";
		}
		
		// 공지글 삭제된 것처럼 수정하기(논리적 삭제)
		int res = course_board_dao.delete_update(id);
	
		// id로 공지글 조회
		CourseBoardDTO dto = course_board_dao.selectOne(id);		
		
		// 공지글에 첨부된 파일 제거
		AnnouncementController.fileManager.fileDelete(dto);
		
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}

	// 첨부 파일 다운로드
	@RequestMapping("course_board_filedownload")
	public String course_board_filedownload(Model model, int id) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		// id로 CourseBoardDTO 조회
		CourseBoardDTO dto = course_board_dao.selectOne(id);

		// 파일 다운로드를 처리할 페이지에 dto와 fileManager를 포워딩
		model.addAttribute("dto", dto);
		model.addAttribute("fileManager", AnnouncementController.fileManager);
		
		return Common.COURSE_PATH + "filedownload.jsp";
	}
		
	
}
