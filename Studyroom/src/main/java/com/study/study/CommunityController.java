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
import dto.UserCommunityLikeDTO;
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

	//커뮤니티 화면 페이지
	@RequestMapping("/community_list")
	public String community_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
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
	
	//게시글 상세보기 페이지
	@RequestMapping("community_view")
	public String community_view(Model model, int id, int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";	
		
		// 게시글 정보 조회
		CommunityDTO dto = community_dao.selectOne(id);
		
		// 사용자 아이디를 세션에서 가져옴
		int user_id = user_dto.getId();

		// 현재 사용자와 커뮤니티 아이디를 DB에 넘겨주기 위해 객체에 저장하기 
		 UserCommunityLikeDTO likedto = new UserCommunityLikeDTO();
		 likedto.setUser_id(user_id);
		 likedto.setCommunity_board_id(id);
		
		// 사용자가 특정 게시글에 추천을 했었는지 확인
		 int user_like = community_dao.like_count(likedto);
		
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
		model.addAttribute("user_id", user_id);
		
		return Common.VIEW_PATH + "/community/community_view.jsp?page="+page;
	}
	
	//게시글 추가 페이지
	@RequestMapping("community_insert_form")  
	public String community_insert_form(int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		return Common.VIEW_PATH+"community/community_insert_form.jsp?page="+page;
	}
	
	//게시글 추가 하기
	@RequestMapping("community_insert") 
	public String community_insert(CommunityDTO dto,int page) {
	
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		// 파일 업로드를 진행하고 dto에 파일 이름 저장
		AnnouncementController.fileManager.fileUpload(dto);
	
		String ip = request.getRemoteAddr();
		dto.setIp_addr(ip);
		dto.setUser_id(user_dto.getId());
		int res = community_dao.insert(dto);
		
		if(res > 0) {
			return "redirect:community_list?page="+page;
		}
		return "/error";
	}
	
	//게시글 수정하기 페이지
	@RequestMapping("community_modify_form") 
	public String community_modify_form(Model model, int id, int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		CommunityDTO dto = community_dao.selectOne(id); //한건을 조회 하려고함
		
		// 글 작성자가 아니라면 접근 불가
		if (user_dto.getId() != dto.getUser_id()) {
			return "/error";
		}
		
		model.addAttribute("dto",dto);
		// 다시 뒤로 갈 때 필요한 page 정보도 넘겨줌
		model.addAttribute("page", page);
		return Common.VIEW_PATH+"community/community_modify_form.jsp";
	}
		
	//게시글 수정하기
	@RequestMapping("community_modify")
	public String community_modify(CommunityDTO dto, HttpServletRequest request) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		System.out.println("현재 사용자 " + user_dto.getId());
		System.out.println("저장된 사용자 : " + dto.getUser_id());
		// 글 작성자가 아니라면 접근 불가
		if (user_dto.getId() != dto.getUser_id()) {
			return "/error";
		}
			
		String ip = request.getRemoteAddr();
		dto.setIp_addr(ip);
		
		//where절에서 사용할 id도 받아와야함.
		int res = community_dao.update(dto);
		return "redirect:community_list";
	}

	//게시글 삭제된 것처럼 처리
	@RequestMapping("community_delete") 
	@ResponseBody
	public String community_delete(int id) {	
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";

		CommunityDTO baseDTO = community_dao.selectOne(id);
		
		// 글 작성자가 아니라면 접근 불가
		if (user_dto.getId() != baseDTO.getUser_id()) {
			return "/error";
		}
		
		baseDTO.setTitle("이미 삭제된 글입니다.");
		baseDTO.setNickname("unknown");
		
		int res = community_dao.del_update(baseDTO);
		
		if(res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
			}
		}

	//답글 추가하기
	@RequestMapping("community_reply") 
	public String community_reply(CommunityDTO dto, Integer id, int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
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
	
	// 사용자 커뮤니티 테이블에 데이터 저장
	@RequestMapping("community_like")
	public String community_like(int id,int page) {
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		int user_id = user_dto.getId();
		
		UserCommunityLikeDTO likedto = new UserCommunityLikeDTO();
	    likedto.setUser_id(user_id);
	    likedto.setCommunity_board_id(id);
	
	    int res1 = community_dao.community_like(likedto);
	    int res2 = community_dao.community_likehit(id);
	      
	    if(res1 > 0 && res2 > 0 ) {
	    	return "redirect:community_list?id="+id+"&page="+page;
	    }
	    return "/error";
	}
	
}



