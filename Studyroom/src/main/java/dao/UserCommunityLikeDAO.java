package dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import dto.UserCommunityLikeDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCommunityLikeDAO {
	
	final SqlSession sqlSession;
	
	public int like_count(int community_id, int user_id) {
		
		UserCommunityLikeDTO dto = new UserCommunityLikeDTO();
		dto.setUser_id(user_id);
		dto.setCommunity_id(community_id);
		
		return sqlSession.selectOne("c.like_count",dto);
***REMOVED***
	
***REMOVED***
