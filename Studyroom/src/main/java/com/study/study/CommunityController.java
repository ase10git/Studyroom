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

import dao.CommunityDAO;
import dto.CommunityDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class CommunityController {
	
	final CommunityDAO community_dao;
	
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/community_list")//Ŀ�´�Ƽ ȭ�� ������
	public String community_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		
		int start = (page - 1) * Common.Board.BLOCKLIST+1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//������ ��ȣ�� �ٸ� ��ü �Խñ� ��ȸ
		List<CommunityDTO> list = community_dao.selectList(map);
		
		//��ü �Խñ� �� ��ȸ
		int rowTotal = community_dao.getRowTotal();
		
		//������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("community_list", 
											page,
											rowTotal,
											Common.Board.BLOCKLIST,
											Common.Board.BLOCKPAGE);
		
		
		request.getSession().removeAttribute("show");
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		
		return Common.VIEW_PATH+"community/community_list.jsp?page="+page;
***REMOVED***
	
	@RequestMapping("/community_list_user")//����� �ۼ��� ��� ������
	public String community_list_user() {
		return Common.VIEW_PATH + "community/community_list_user.jsp";
***REMOVED***
	
	@RequestMapping("community_view")//�Խñ� �󼼺��� ������
	public String community_view(Model model, int id, int page) {
		CommunityDTO dto = community_dao.selectOne(id);
		
		//��ȸ�� ����
		HttpSession session = request.getSession();
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			int res = community_dao.update_readhit(id);
			session.setAttribute("show", "0");
	***REMOVED***
		
		model.addAttribute("dto",dto);
		
		return Common.VIEW_PATH+"/community/community_view.jsp?page="+page;
	//return Common.VIEW_PATH+"/community/community_view.jsp";
***REMOVED***

@RequestMapping("community_insert_form") //�Խñ� �߰� ������ 
public String community_insert_form(int page) {
	
	UserDTO show = (UserDTO)session.getAttribute("id");
	
	if(show ==null) {
		return Common.VIEW_PATH + "/community/community_insert_form.jsp?page"+page;
***REMOVED***
	
	
	return Common.VIEW_PATH+"community/community_insert_form.jsp?page="+page;
***REMOVED***

@RequestMapping("community_insert") // �Խñ� �߰� �ϱ�
public String community_insert(CommunityDTO dto,int page) {
	
	System.out.println("nickname : " + dto.getNickname());
		String ip = request.getRemoteAddr();
		dto.setIp_addr(ip);
		int res = community_dao.insert(dto);
		
		if(res > 0) {
			return "redirect:community_list?page="+page;
	***REMOVED***
		return null;
		
***REMOVED***

@RequestMapping("community_modify_form") //�Խñ� �����ϱ� ������
public String community_modify_form(Model model, int id) {
	CommunityDTO dto = community_dao.selectOne(id); //�Ѱ��� ��ȸ �Ϸ�����
	
	model.addAttribute("dto",dto);
	return Common.VIEW_PATH+"community/community_modify_form.jsp";
***REMOVED***


@RequestMapping("community_modify")//�Խñ� �����ϱ�
public String community_modify(CommunityDTO dto, HttpServletRequest request) {
	String ip = request.getRemoteAddr();
	dto.setIp_addr(ip);
	
	//where������ ����� id�� �޾ƿ;���.
	
	int res = community_dao.update(dto);
	return "redirect:community_list";
***REMOVED***
	
	@RequestMapping("community_delete") //�Խñ� �����ϱ�
	@ResponseBody
	public String community_delete(int id) {
		
		CommunityDTO baseDTO = community_dao.selectOne(id);
		
		baseDTO.setTitle("�̹� ������ ���Դϴ�.");
		baseDTO.setNickname("unknown");
		
		int res = community_dao.del_update(baseDTO);
		
		if(res == 1) {
			return "[{'result':'yes'***REMOVED***]";
	***REMOVED*** else {
			return "[{'result':'no'***REMOVED***]";
		***REMOVED***
	***REMOVED***
		
	
	
	
	@RequestMapping("community_delete_physical")//�Խñ� ������ �����ϱ�
	@ResponseBody
	public String community_delete_physical(int id) {
		return null;
***REMOVED***
	
	
	@RequestMapping("community_reply_insert") //��� �߰��ϱ�
	public String community_reply_insert(CommunityDTO dto, int id, int page) {

	return null;
***REMOVED***
	
	
	
	
***REMOVED***








