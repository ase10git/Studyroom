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

import dao.AnnouncementDAO;
import dto.CourseBoardDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.FileManager;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
	
	final AnnouncementDAO announcement_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	// FileManager 클래스 인스턴스 생성
	public static FileManager fileManager = new FileManager();

	String webPath = "/resources/upload/"; // 프로젝트상 경로
	
	@RequestMapping("announcement_list") 
	public String announcement_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		// FileManager의 파일 저장 경로를 request로부터 받아와 저장하기
		if (fileManager.getSavePath() == null) {

			String realPath = request.getServletContext().getRealPath("/resources/upload/");
			fileManager.setSavePath(realPath);
			System.out.println(realPath);
	***REMOVED***
		
		
		int start = (page - 1) * Common.Announcement.BLOCKLIST+1;
		int end = start + Common.Announcement.BLOCKLIST -1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//페이지 번호에 따른 전체 게시글 조회
		List<CourseBoardDTO> list = announcement_dao.selectList(map);
		
		//전체 게시글 수 조회
		int rowTotal = announcement_dao.getRowTotal();
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("announcement_list",
											page,
											rowTotal,
											Common.Announcement.BLOCKLIST,
											Common.Announcement.BLOCKPAGE);
		
		request.getSession().removeAttribute("show");
		
		// 데이터 포워딩
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		model.addAttribute("role", user_dto.getRole());
		
		return Common.ANNOUNCEMENT_PATH + "announcement_list.jsp?page="+page;
***REMOVED***
	
	// 전체 공지글 상세보기
	@RequestMapping("view")
	public String view(Model model, int id, int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
				
		CourseBoardDTO dto = announcement_dao.selectOne(id);

		model.addAttribute("dto",dto);
		model.addAttribute("role",user_dto.getRole());
		
		return Common.ANNOUNCEMENT_PATH+"announcement_view.jsp?page="+page;
***REMOVED***
	
***REMOVED***
