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
import lombok.RequiredArgsConstructor;
import util.Common;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
	
	final AnnouncementDAO announcement_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("announcement_list")
	public String announcement_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
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
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return Common.ANNOUNCEMENT_PATH + "announcement_list.jsp?page="+page;
***REMOVED***
	
***REMOVED***
