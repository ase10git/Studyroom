package dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import dto.UserCommunityLikeDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCommunityLikeDAO {
	
	final SqlSession sqlSession;
	
	// 특정 사용자의 커뮤니티 글 추천 여부 조회
	public int like_count(int user_id, int community_board_id) {
		
		UserCommunityLikeDTO dto = new UserCommunityLikeDTO();
		dto.setUser_id(user_id);
		dto.setCommunity_board_id(community_board_id);
		
		Integer result = sqlSession.selectOne("cm.like_count", dto);
		
		return (result != null) ? result.intValue() : 0;
***REMOVED***
	
***REMOVED***
