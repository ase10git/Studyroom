package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Common;

// 테스트용 컨트롤러
// 파일을 변경하지 말고 복사해서 사용해주세요
@Controller
public class TestController {

	@RequestMapping("/")
	public String test() {
		return Common.VIEW_PATH + "home.jsp";
	}
	
	/*
	@RequestMapping("/")
	public String board_list(Model model) {
		
	}
	
	@RequestMapping("/")
	public String board_list_user() {
		
	}
	
	@RequestMapping("/")
	public String board_view(Model model) {
		
	}
	
	@RequestMapping("/")
	public String board_view_delete(int idx) {
		
	}
	
	@RequestMapping("/")
	public String board_insert_form() {
		
	}
	
	@RequestMapping("/")
	public String board_insert() {
		
	}
	
	@RequestMapping("/")
	public String board_reply_insert(int idx) {
		
	}
	
	@RequestMapping("/")
	public String board_modify_form() {
		
	}
	
	@RequestMapping("/")
	public String board_modify(int idx) {
		
	}
	*/
}
