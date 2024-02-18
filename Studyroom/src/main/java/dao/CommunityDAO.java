package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.study.AnnouncementController;

import dto.CommunityDTO;
import dto.UserCommunityLikeDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunityDAO {

	final SqlSession sqlSession;
	
	//페이지별 게시글 조회
		public List<CommunityDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("cm.community_list",map);
	***REMOVED***
	
		//전체 게시물 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("cm.community_count");
	***REMOVED***
		
		//게시글 한 건 조회
		public CommunityDTO selectOne(int id) {
			return sqlSession.selectOne("cm.community_view",id);
	***REMOVED***
		
		//조회수 증가
		public int update_readhit(int id) {
			int res = sqlSession.update("cm.update_readhit",id);
			return res;
	***REMOVED***
		
		//게시글 추가하기
		public int insert(CommunityDTO dto) {
			System.out.println("nickName : " + dto.getNickname());
			return sqlSession.insert("cm.community_insert",dto);
	***REMOVED***
		
		//삭제한것처럼 수정하기
		public int del_update(CommunityDTO dto) {
			// 첨부된 파일 제거
			AnnouncementController.fileManager.fileDelete(dto);
			
			return sqlSession.update("cm.del_update",dto);
	***REMOVED***
		
		// 삭제 요청한 게시글 조회
		public List<CommunityDTO> deleteList() {
			return sqlSession.selectList("cm.delete_list");
	***REMOVED***
		
		// 게시글 물리적 삭제
		public int delete_physical(ArrayList<Integer> communityList) {
			// 특정 게시글 추천 내역 제거
			this.only_community_delete(communityList);
			return sqlSession.delete("cm.community_delete", communityList);
	***REMOVED***
		
		//댓글추가를 위한 step + 1
		public int update_step(CommunityDTO dto) {
			return sqlSession.update("cm.community_update_step",dto);
	***REMOVED***
		
		//답글 추가하기
		public int reply(CommunityDTO dto) {
			return sqlSession.insert("cm.community_reply",dto);
	***REMOVED***
		
		//게시글 수정하기
		public int update(CommunityDTO dto) {
			return sqlSession.update("cm.community_update",dto);
	***REMOVED***	
		
		//답글 조회 
		public List<CommunityDTO> select_reply(int ref){
			return sqlSession.selectList("cm.community_reply_list",ref);
	***REMOVED***
		
		// 특정 사용자의 커뮤니티 글 추천 여부 조회
		public int like_count(int user_id, int community_board_id) {
			
			UserCommunityLikeDTO dto = new UserCommunityLikeDTO();
			dto.setUser_id(user_id);
			dto.setCommunity_board_id(community_board_id);
			
			Integer result = sqlSession.selectOne("cm.like_count", dto);
			
			return (result != null) ? result.intValue() : 0;
	***REMOVED***
		
		// 사용자 커뮤니티 테이블에서 특정 사용자 추천 내역 제거
		public int only_user_delete(ArrayList<Integer> userList) {
			return sqlSession.delete("cm.only_user_delete", userList);
	***REMOVED***
		
		// 사용자 커뮤니티 테이블에서 특정 사용자 추천 내역 제거
		public int only_community_delete(ArrayList<Integer> communityList) {
			return sqlSession.delete("cm.only_community_delete", communityList);
	***REMOVED***
***REMOVED***
