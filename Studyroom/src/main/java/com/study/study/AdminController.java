package com.study.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserDAO;
import dto.CommunityDTO;
import dto.CourseBoardDTO;
import dto.CourseDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

// 관리자만 수행할 수 있는 동작을 저장한 클래스
// 코스, 코스보드 등의 동작은 해당 컨트롤러에 추가함

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	final UserDAO user_dao;
	final CourseDAO course_dao;
	final CourseBoardDAO course_board_dao;
//	final CustomerServiceDAO cs_dao;
	final CommunityDAO community_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;

	// 삭제 관리 페이지로 이동
	@RequestMapping("delete_management")
	public String delete_management(Model model) {
		
		// 사용자 권한을 세션에서 가져옴
		String role = (String)session.getAttribute("role");
		
		// 관리자 외의 다른 사용자의 접근 차단
		if (!role.equals("admin")) {
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
		
		// 페이지에서 삭제 체크박스로 선택한 각 카테고리의 id 정보를 배열로 가져옴
		String[] userId = request.getParameterValues("userId");
		String[] courseId = request.getParameterValues("courseId");
		String[] courseboardId = request.getParameterValues("courseboardId");
		String[] communityId = request.getParameterValues("communityId");

		// DB에 넘겨주기 위해 List에 저장
		ArrayList<Integer> userList = new ArrayList<>();
		ArrayList<Integer> courseList = new ArrayList<>();
		ArrayList<Integer> courseBoardList = new ArrayList<>();
		ArrayList<Integer> communityList = new ArrayList<>();
		
		// 각 카테고리의 삭제 요청 결과를 저장하는 변수
		// -1 : 페이지에서 선택된 id가 없음(userId, courseId, courseboardId, communityId)
		// 1 : 삭제 요청 성공
		// 0 : 삭제 요청 실패
		int userResult = -1;
		int courseResult = -1;
		int courseBoardResult = -1;
		int communityResult = -1;
		
		// List에 데이터를 저장하고, 각 카테고리별 삭제 동작 수행
		if (userId != null) { // 사용자 제거
			for(int i = 0; i < userId.length; i++) {
				userList.add(Integer.parseInt(userId[i]));
			}
			
			System.out.println("userId : " + Arrays.toString(userId));
			userResult = user_dao.delete_physical(userList);
		}
		
		if (courseId != null) { // 코스 제거
			for(int i = 0; i < courseId.length; i++) {
				courseList.add(Integer.parseInt(courseId[i]));
			}
			
			System.out.println("courseId : " + Arrays.toString(courseId));
			courseResult = course_dao.delete_physical(courseList);
		}
		
		if (courseboardId != null) { // 코스 공지글 제거
			for(int i = 0; i < courseboardId.length; i++) {
				courseBoardList.add(Integer.parseInt(courseboardId[i]));
			}
			
			System.out.println("courseboardId : " + Arrays.toString(courseboardId));
			courseBoardResult = course_board_dao.delete_physical(courseBoardList);
		}

		if (communityId != null) { // 커뮤니티 게시글 제거
			for(int i = 0; i < communityId.length; i++) {
				communityList.add(Integer.parseInt(communityId[i]));
			}	
			
			System.out.println("communityId : " + Arrays.toString(communityId));
			communityResult = community_dao.delete_physical(communityList);
		}

		// 삭제 결과를 통해 최종 반환값 결정
		if (userResult == 0) {
			System.out.println("사용자 삭제를 실패했습니다.");
			return "redirect:error";
		} 
		
		if (courseResult == 0) {
			System.out.println("코스 삭제를 실패했습니다.");
			return "redirect:error";
		} 
		
		if (courseBoardResult == 0) {
			System.out.println("공지글 삭제를 실패했습니다.");
			return "redirect:error";
		} 
		
		if (communityResult == 0) {
			System.out.println("커뮤니티 게시글 삭제를 실패했습니다.");
			return "redirect:error";
		} 
		
		System.out.println("요청받은 삭제를 모두 수행했습니다.");
		return "redirect:delete_management";
	}
	
	@RequestMapping("/error")
	public String error() {
		return Common.VIEW_PATH + "error.jsp";
	}
}
