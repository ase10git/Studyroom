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
import dao.UserCommunityLikeDAO;
import dto.CommunityDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.FileManager;
import util.Paging;

@Controller
@RequiredArgsConstructor
public class CommunityController {
	
	final CommunityDAO community_dao;
	final UserCommunityLikeDAO uclDAO;
	
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	
	// FileManager 클래스 인스턴스 생성
		public static FileManager fileManager = new FileManager();
	
		String webPath = "/resources/upload/";// 프로젝트상 경로
	
	//커뮤니티 화면 페이지
	@RequestMapping("/community_list")
	public String community_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		// FileManager의 파일 저장 경로를 request로부터 받아와 저장하기
		if (fileManager.getSavePath() == null) {

		String realPath = request.getServletContext().getRealPath(webPath);
		fileManager.setSavePath(realPath);
		}
		
		int start = (page - 1) * Common.Board.BLOCKLIST+1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//페이지 번호에 다른 전체 게시글 조회
		List<CommunityDTO> list = community_dao.selectList(map);
		
		//전체 게시글 수 조회
		int rowTotal = community_dao.getRowTotal();
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("community_list", 
											page,
											rowTotal,
											Common.Board.BLOCKLIST,
											Common.Board.BLOCKPAGE);
		
		request.getSession().removeAttribute("show");
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return Common.VIEW_PATH+"community/community_list.jsp?page="+page;
	}
	
	//사용자 작성글 목록 페이지
	@RequestMapping("/community_list_user")
	public String community_list_user() {
		return Common.VIEW_PATH + "community/community_list_user.jsp";
	}
	
	//게시글 상세보기 페이지
	@RequestMapping("community_view")
	public String community_view(Model model, int id, int page) {
		CommunityDTO dto = community_dao.selectOne(id);
		
		int user_id = (int)session.getAttribute("userId");

		// 사용자가 특정 게시글에 추천을 했었는지 확인
		int user_like = uclDAO.like_count(user_id, id);	
		
		//답글 조회
		List<CommunityDTO> reply_list = community_dao.select_reply(id);
		
		//조회수 증가
		HttpSession session = request.getSession();
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			int res = community_dao.update_readhit(id);
			session.setAttribute("show", "0");
		}
		model.addAttribute("dto",dto);
		model.addAttribute("reply_list",reply_list);
		model.addAttribute("user_like", user_like);
		
		return Common.VIEW_PATH + "/community/community_view.jsp?page="+page;
}
	
	//게시글 추가 페이지
	@RequestMapping("community_insert_form")  
	public String community_insert_form(int page) {
	
	UserDTO show = (UserDTO)session.getAttribute("id");
	
	if(show ==null) {
		return Common.VIEW_PATH + "/community/community_insert_form.jsp?page"+page;
	}
	return Common.VIEW_PATH+"community/community_insert_form.jsp?page="+page;
}
	
	//게시글 추가 하기
	@RequestMapping("community_insert") 
	public String community_insert(CommunityDTO dto,int page) {
	
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		fileManager.fileUpload(dto);
	
	System.out.println("nickname : " + dto.getNickname());
		String ip = request.getRemoteAddr();
		dto.setIp_addr(ip);
		int res = community_dao.insert(dto);
		
		if(res > 0) {
			return "redirect:community_list?page="+page;
		}
		return null;
	}
	
	//게시글 수정하기 페이지
	@RequestMapping("community_modify_form") 
	public String community_modify_form(Model model, int id) {
	CommunityDTO dto = community_dao.selectOne(id); //한건을 조회 하려고함
	
	model.addAttribute("dto",dto);
	return Common.VIEW_PATH+"community/community_modify_form.jsp";
}
	
	//게시글 수정하기
	@RequestMapping("community_modify")
	public String community_modify(CommunityDTO dto, HttpServletRequest request) {
	String ip = request.getRemoteAddr();
	dto.setIp_addr(ip);
	
	//where절에서 사용할 id도 받아와야함.
	int res = community_dao.update(dto);
	return "redirect:community_list";
}

	//게시글 삭제하기
	@RequestMapping("community_delete") 
	@ResponseBody
	public String community_delete(int id) {
		
		CommunityDTO baseDTO = community_dao.selectOne(id);
		
		baseDTO.setTitle("이미 삭제된 글입니다.");
		baseDTO.setNickname("unknown");
		
		int res = community_dao.del_update(baseDTO);
		
		if(res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
			}
		}
	
	//게시글 물리적 삭제하기
	@RequestMapping("community_delete_physical")
	@ResponseBody
	public String community_delete_physical(int id) {
		return null;
	}
	
	//답글 추가하기
	@RequestMapping("community_reply") 
	public String community_reply(CommunityDTO dto, Integer id, int page) {
		System.out.println("컨트롤러 옴");
		String ip = request.getRemoteAddr();
		
		CommunityDTO baseDTO = community_dao.selectOne(id);
		
		int res = community_dao.update_step(baseDTO);
		
		dto.setIp_addr(ip);
		
		//댓글이 들어갈 위치 선정
		dto.setRef(baseDTO.getRef());
		dto.setStep(baseDTO.getStep()+1);
		dto.setDepth(baseDTO.getDepth()+1);
		
		res = community_dao.reply(dto);
		
		return "redirect:community_view?id="+id+"&page="+page;
	}
	
	
}








