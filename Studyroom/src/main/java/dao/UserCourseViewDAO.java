package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.UserCourseViewDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCourseViewDAO {
	final SqlSession sqlSession; 
	
	// 특정 사용자의 코스 전체 조회
	public List<UserCourseViewDTO> selectList_user(HashMap<String, Integer> map) { 
		return sqlSession.selectList("ucv.uc_list", map);
***REMOVED***
	
	// 특정 사용자의 전체 코스 수 조회
	public int getRowTotal(int user_id) {
		return sqlSession.selectOne("ucv.uc_count", user_id);
***REMOVED***
***REMOVED***
