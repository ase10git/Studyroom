package com.study.study;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.UserDAO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	final UserDAO user_dao;
	
	@Autowired
	HttpSession session;
	
	// 사용자 정보 화면 보기
	@RequestMapping("user_view")
	public String user_view(Model model, int id) {
		
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
		
		UserDTO userDTO = user_dao.selectOne(id);
		model.addAttribute("dto", userDTO);
		model.addAttribute("role", userDTO.getRole());
		return Common.USER_PATH+"user_view.jsp";
***REMOVED***
	
	// 사용자 정보 수정하기 전 비밀번호 확인 페이지 이동
	@RequestMapping("user_pw_auth_form")
	public String user_pw_auth_form(Model model, int id, @RequestParam("action") String action) {
	    
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		UserDTO dto = user_dao.selectOne(id);
	    model.addAttribute("dto", dto);
	    model.addAttribute("action", action);
	    return Common.USER_PATH + "user_pw_auth_form.jsp";
***REMOVED***
	
	// 비밀번호 확인 로직
	@RequestMapping("authenticate")
	@ResponseBody
	public String authenticate(int id, String pwd, @RequestParam("action") String action) { 
		UserDTO dto = user_dao.selectOne(id);
		if(!pwd.equals(dto.getPwd())){
			return "[{'param':'no_pwd'***REMOVED***]";
	***REMOVED***
		session.setAttribute("authenticated", "true");
		String jsonResponse = "[{'param':'clear', 'action':'" + action + "'***REMOVED***]";
		return jsonResponse;
***REMOVED***

	
	// 사용자 정보 수정 페이지 이동
	@RequestMapping("user_modify_form")
    public String user_modify_form(Model model, int id, RedirectAttributes redirectAttributes) {
        if (!session.getAttribute("authenticated").equals("true")) {
        	redirectAttributes.addFlashAttribute("authFail", true);
            return "redirect:user_pw_auth_form?id="+id+"&action=update";
        ***REMOVED***
        session.removeAttribute("authenticated");
	    UserDTO dto = user_dao.selectOne(id);
	    model.addAttribute("dto", dto);
        return Common.USER_PATH + "user_modify_form.jsp";
    ***REMOVED***
	
	// 사용자 정보 수정 로직
	@RequestMapping("user_modify")
    public String user_modify(UserDTO dto, RedirectAttributes redirectAttributes) {
        int res = user_dao.modify(dto);
        
        if (res > 0) {
            redirectAttributes.addFlashAttribute("updateSuccess", true);
        ***REMOVED***
        return "redirect:user_view?id="+dto.getId();
    ***REMOVED***
	
	// 사용자 회원 탈퇴 확인 페이지 이동
	@RequestMapping("user_delete_confirm")
    public String user_delete_confirm(Model model, int id, RedirectAttributes redirectAttributes) {
        if (!session.getAttribute("authenticated").equals("true")) {
        	redirectAttributes.addFlashAttribute("authFail", true);
            return "redirect:user_pw_auth_form?id="+id+"&action=update";
        ***REMOVED***
        session.removeAttribute("authenticated");
	    model.addAttribute("id", id);
        return Common.USER_PATH + "user_delete_confirm.jsp";
    ***REMOVED***

	// 사용자 회원 탈퇴(한것처럼 보이는) 로직
	@RequestMapping("user_delete")
	public String user_delete(int id) {
		UserDTO dto = user_dao.selectOne(id);
		dto.setUsername("unknown");
		dto.setEmail("unknown");
		dto.setTel("unknown");
		dto.setEmail("unknown");
		dto.setPwd("0000");
		int res = user_dao.del_update(dto);
	    if(res == 1) {
	        return "[{'result':'yes'***REMOVED***]";
	    ***REMOVED*** else {
	        return "[{'result':'no'***REMOVED***]";
	    ***REMOVED***
***REMOVED***
***REMOVED***
