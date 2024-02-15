package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CommunityDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunityDAO {

	final SqlSession sqlSession;
	
	//페이지별 게시글 조회
		public List<CommunityDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("c.community_list",map);
	***REMOVED***
	
		//전체 게시물 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("c.community_count");
	***REMOVED***
		
		//게시글 한 건 조회
		public CommunityDTO selectOne(int id) {
			return sqlSession.selectOne("c.community_view",id);
	***REMOVED***
		
		//조회수 증가
		public int update_readhit(int id) {
			int res = sqlSession.update("c.update_readhit",id);
			return res;
	***REMOVED***
		
		//게시글 추가하기
		public int insert(CommunityDTO dto) {
			System.out.println("nickName : " + dto.getNickname());
			return sqlSession.insert("c.community_insert",dto);
	***REMOVED***
		
		//삭제한것처럼 수정하기
		public int del_update(CommunityDTO dto) {
			return sqlSession.update("c.del_update",dto);
	***REMOVED***
		
		//댓글추가를 위한 step + 1
		public int update_step(CommunityDTO dto) {
			return sqlSession.update("c.community_update_step",dto);
	***REMOVED***
		
		//답글 추가하기
		public int reply(CommunityDTO dto) {
			return sqlSession.insert("c.community_reply",dto);
	***REMOVED***
		
		//게시글 수정하기
		public int update(CommunityDTO dto) {
			return sqlSession.update("c.community_update",dto);
	***REMOVED***
	
***REMOVED***
