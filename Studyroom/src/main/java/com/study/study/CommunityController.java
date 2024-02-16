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
	
	
	
	// FileManager Ŭ���� �ν��Ͻ� ����
		public static FileManager fileManager = new FileManager();
	
		String webPath = "/resources/upload/";// ������Ʈ�� ���
	
	//Ŀ�´�Ƽ ȭ�� ������
	@RequestMapping("/community_list")
	public String community_list(Model model, @RequestParam(required=false, defaultValue="1") int page) {
		
		// FileManager�� ���� ���� ��θ� request�κ��� �޾ƿ� �����ϱ�
		if (fileManager.getSavePath() == null) {

		String realPath = request.getServletContext().getRealPath(webPath);
		fileManager.setSavePath(realPath);
		}
		
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
	}
	
	//����� �ۼ��� ��� ������
	@RequestMapping("/community_list_user")
	public String community_list_user() {
		return Common.VIEW_PATH + "community/community_list_user.jsp";
	}
	
	//�Խñ� �󼼺��� ������
	@RequestMapping("community_view")
	public String community_view(Model model, int id, int page) {
		CommunityDTO dto = community_dao.selectOne(id);
		
		int user_id = (int)session.getAttribute("userId");

		// ����ڰ� Ư�� �Խñۿ� ��õ�� �߾����� Ȯ��
		int user_like = uclDAO.like_count(user_id, id);	
		
		//��� ��ȸ
		List<CommunityDTO> reply_list = community_dao.select_reply(id);
		
		//��ȸ�� ����
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
	
	//�Խñ� �߰� ������
	@RequestMapping("community_insert_form")  
	public String community_insert_form(int page) {
	
	UserDTO show = (UserDTO)session.getAttribute("id");
	
	if(show ==null) {
		return Common.VIEW_PATH + "/community/community_insert_form.jsp?page"+page;
	}
	return Common.VIEW_PATH+"community/community_insert_form.jsp?page="+page;
}
	
	//�Խñ� �߰� �ϱ�
	@RequestMapping("community_insert") 
	public String community_insert(CommunityDTO dto,int page) {
	
		// ���� ���ε带 �����ϰ� dto�� ���� �̸� ����
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
	
	//�Խñ� �����ϱ� ������
	@RequestMapping("community_modify_form") 
	public String community_modify_form(Model model, int id) {
	CommunityDTO dto = community_dao.selectOne(id); //�Ѱ��� ��ȸ �Ϸ�����
	
	model.addAttribute("dto",dto);
	return Common.VIEW_PATH+"community/community_modify_form.jsp";
}
	
	//�Խñ� �����ϱ�
	@RequestMapping("community_modify")
	public String community_modify(CommunityDTO dto, HttpServletRequest request) {
	String ip = request.getRemoteAddr();
	dto.setIp_addr(ip);
	
	//where������ ����� id�� �޾ƿ;���.
	int res = community_dao.update(dto);
	return "redirect:community_list";
}

	//�Խñ� �����ϱ�
	@RequestMapping("community_delete") 
	@ResponseBody
	public String community_delete(int id) {
		
		CommunityDTO baseDTO = community_dao.selectOne(id);
		
		baseDTO.setTitle("�̹� ������ ���Դϴ�.");
		baseDTO.setNickname("unknown");
		
		int res = community_dao.del_update(baseDTO);
		
		if(res == 1) {
			return "[{'result':'yes'}]";
		} else {
			return "[{'result':'no'}]";
			}
		}
	
	//�Խñ� ������ �����ϱ�
	@RequestMapping("community_delete_physical")
	@ResponseBody
	public String community_delete_physical(int id) {
		return null;
	}
	
	//��� �߰��ϱ�
	@RequestMapping("community_reply") 
	public String community_reply(CommunityDTO dto, Integer id, int page) {
		System.out.println("��Ʈ�ѷ� ��");
		String ip = request.getRemoteAddr();
		
		CommunityDTO baseDTO = community_dao.selectOne(id);
		
		int res = community_dao.update_step(baseDTO);
		
		dto.setIp_addr(ip);
		
		//����� �� ��ġ ����
		dto.setRef(baseDTO.getRef());
		dto.setStep(baseDTO.getStep()+1);
		dto.setDepth(baseDTO.getDepth()+1);
		
		res = community_dao.reply(dto);
		
		return "redirect:community_view?id="+id+"&page="+page;
	}
	
	
}








