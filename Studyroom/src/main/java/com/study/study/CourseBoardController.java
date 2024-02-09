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
		
	// 코스 공지글 전체를 페이지별로
	@RequestMapping("course_board_list")
	public String course_board_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		// 시작, 종료 페이지 계산
		int start = (page - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		// 페이지 정보를 map에 저장
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
	
		// 페이지 번호에 따른 전체 게시글 조회
		List<CourseBoardDTO> list = course_board_dao.selectList(map);
		
		// 전체 게시글 수 조회
		int rowTotal = course_board_dao.getRowTotal();
		
		// 페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("course_board_list", 
											page, 
											rowTotal, 
											Common.Board.BLOCKLIST, 
											Common.Board.BLOCKPAGE);
		
		// 페이지에 데이터 포워딩
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return Common.COURSE_PATH +"course_board_list.jsp?page=" + page;
	}
	
	// 코스 공지글 상세보기
	@RequestMapping("course_board_view")
	public String course_board_view(Model model, int id, int page) {
		
		// id로 공지글 조회하기
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// 페이지에 조회한 공지글 포워딩
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_view.jsp?page=" + page;
	}
	
	// 코스 공지글 추가하기 페이지 이동
	@RequestMapping("course_board_insert_form")
	public String course_board_insert_form() {
		// 로그인 확인 및 권한 확인 추가 예정
//		UserDTO show = (UserDTO)session.getAttribute("id");
//		
//		if (show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//		}
		
		return Common.COURSE_PATH + "course_board_insert_form.jsp";
	}
	
	
	// 코스 공지글 추가하기
	@RequestMapping("course_board_insert")
	public String course_board_insert(CourseBoardDTO dto) {

		// 파일 업로드 설정 클래스의 인스턴스
		UploadFile uploadFile = new UploadFile();
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		uploadFile.fileUpload(dto, request);

		// 공지글 추가
		int res = course_board_dao.insert(dto);
	
		// 추가 완료 시 공지글 보는 페이지로 돌아가기
		if (res > 0) {
			return "course_board_list";
		}
		
		return "";
	}
	
	// 코스 공지글 수정 페이지 이동
	@RequestMapping("course_board_modify_form")
	public String course_board_modify_form(Model model, int id) {
		// 로그인 확인 및 권한 확인 추가 예정
//		MemberDTO show = (MemberDTO)session.getAttribute("id");
//		
//		if(show == null) {
//			return Common.Board.VIEW_PATH + "login_form.jsp";
//		}
		
		// 요청 페이지에서 공지글의 id를 받아 공지글을 조회
		CourseBoardDTO dto = course_board_dao.selectOne(id);
		
		// 공지글 객체를 수정 페이지로 포워딩
		model.addAttribute("dto", dto);
		
		return Common.COURSE_PATH + "course_board_modify_form.jsp";
	}
	
	// 코스 공지글 수정하기
	@RequestMapping("course_board_modify")
	public String course_board_modify(CourseBoardDTO dto) {
		
		// 파일 업로드 설정 클래스의 인스턴스
		UploadFile uploadFile = new UploadFile();
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		uploadFile.fileUpload(dto, request);
		
		// 공지글 수정
		int res = course_board_dao.modify(dto);
		
		// 공지글 수정 완료 시 공지글 보는 화면으로 돌아가기
		if (res > 0) {
			return "redirect:course_board_list";
		}
		
		return "";
	}
	
	// 코스 공지글 삭제된 것처럼 수정하기
	@RequestMapping("course_board_delete")
	public String course_board_delete(int id) {
		// 권한 설정 예정
		
		// 공지글 삭제된 것처럼 수정하기(논리적 삭제)
		int res = course_board_dao.delete_update(id);
	
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	// 코스 공지글 물리적 삭제
	@RequestMapping("course_board_delete_physical")
	public String course_board_delete_physical() {
		// 권한 설정 예정
		
		// 공지글 DB에서 삭제하기(물리적 삭제)
		int res = course_board_dao.delete_physical();
	
		if (res == 1) { // ajax 콜백 메소드에 전달할 내용
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
		}

	}
	
	
	
	// ajax 테스트용 메소드
	// 코스 공지글 상세보기
//	@RequestMapping("ajax_test")
//	@ResponseBody
//	public String ajax_test(Model model, int id) {
//
//		// id로 공지글 조회하기
//		CourseBoardDTO DTO = course_board_dao.selectOne(id);
//		
//		// 페이지에 조회한 공지글 포워딩
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
