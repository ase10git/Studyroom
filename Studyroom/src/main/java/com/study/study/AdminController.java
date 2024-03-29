package com.study.study;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserCourseDAO;
import dao.UserDAO;
import dto.CommunityDTO;
import dto.CourseBoardDTO;
import dto.CourseDTO;
import dto.UserCourseDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import service.DeleteService;
import util.Common;
import util.Paging;

// 관리자만 수행할 수 있는 동작을 저장한 클래스
// 코스, 코스보드 등의 동작은 해당 컨트롤러에 추가함

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	final UserDAO user_dao;
	final CourseDAO course_dao;
	final UserCourseDAO user_course_dao;
	final CourseBoardDAO course_board_dao;
	final CommunityDAO community_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	DeleteService deleteService;

	// 관리메뉴 페이지 이동
	@RequestMapping("management_list")
	public String management_list() {
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
		}
		
		return Common.ADMIN_PATH + "management_list.jsp";
	}
	
	@RequestMapping("user_all_info_list")
	public String user_all_info_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
		}
		
		int start = (page - 1) * Common.Course.BLOCKLIST+1;
		int end = start + Common.Course.BLOCKLIST - 1;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		List<UserDTO> list = user_dao.selectList(map);
		
		int rowTotal = user_dao.getRowTotal();
		
		String pageMenu = Paging.getPaging("user_all_info_list",
										   page,
										   rowTotal, 
										   Common.Course.BLOCKLIST,
										   Common.Course.BLOCKPAGE,
										   null);
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return Common.ADMIN_PATH + "user_all_info_list.jsp?page="+page;
	}
	
	@RequestMapping("user_course_insert_form")
	public String user_course_insert_form(Model model, int id, @RequestParam(required=false, defaultValue="1") int page) {
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_session = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_session == null) {
			return "/";
		// 관리자만 허용
		} else if (!user_session.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
		}
		
		int start = (page - 1) * Common.Course.BLOCKLIST+1;
		int end = start + Common.Course.BLOCKLIST - 1;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		List<CourseDTO> list = course_dao.selectList(map);
		
		int rowTotal = course_dao.getRowTotal();
		
		String pageMenu = Paging.getPaging("user_course_insert_form",
										   page,
										   rowTotal, 
										   Common.Course.BLOCKLIST,
										   Common.Course.BLOCKPAGE,
										   id);
		
		UserDTO user_dto = user_dao.selectOne(id);
		model.addAttribute("user_dto", user_dto);
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		
		return Common.ADMIN_PATH + "user_course_insert_form.jsp?page=" + page;
	}
	
	@RequestMapping("user_course_insert")
	public String user_course_insert(UserCourseDTO dto, RedirectAttributes redirectAttributes) {
		int res = user_course_dao.insert(dto);
		
        if (res > 0) {
        	// 성공
            redirectAttributes.addFlashAttribute("insertSuccess", 1);
        } else {
        	// 실패
        	redirectAttributes.addFlashAttribute("insertSuccess", 2);
        }
        return "redirect:course_list?id="+dto.getUser_id();
    }
	
	@RequestMapping("user_course_delete")
	@ResponseBody
	public String user_course_delete(UserCourseDTO dto) {
	    int res = user_course_dao.delete(dto);
	    
	    if(res == 1) {
	        return "[{'result':'yes'}]";
	    } else {
	        return "[{'result':'no'}]";
	    }
	}
	
	
	// 삭제 관리 페이지로 이동
	@RequestMapping("delete_management")
	public String delete_management(Model model) {
			
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		// 관리자만 허용
		} else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
		}

		
		// del_flag = -1인 사용자 조회
		List<UserDTO> user_list = user_dao.deleteList();
		
		// del_flag = -1인 코스 조회
		List<CourseDTO> course_list = course_dao.deleteList();
		
		// del_flag = -1인 코스 공지글 조회
		List<CourseBoardDTO> course_board_list = course_board_dao.deleteList();

		// del_flag = -1인 커뮤니티글 조회
		List<CommunityDTO> community_list = community_dao.deleteList();
					
		// 데이터를 삭제 관리 페이지에 포워딩
		model.addAttribute("user_list", user_list);
		model.addAttribute("course_list", course_list);
		model.addAttribute("course_board_list", course_board_list);
		model.addAttribute("community_list", community_list);
		
		return  Common.ADMIN_PATH + "delete_management.jsp";
		
	}

	// 물리적 삭제 진행
	@RequestMapping("delete_physical")
	public String delete_physical() {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) {
			return "/";
		} else if (!user_dto.getRole().equals("admin")) { // 관리자만 접근 가능
			return "/error";
		}
		
		// DeleteService 실행
		deleteService.delete_all();
		
		System.out.println("요청받은 삭제를 모두 수행했습니다.");
		return "redirect:delete_management";
	}
	
	// 에러 페이지 이동
	@RequestMapping("/error")
	public String error() {
		return Common.VIEW_PATH + "error.jsp";
	}
}
