package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import dto.UserCourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseDAO {
	final SqlSession sqlSession; 
	
//	final UserDTO user_dto;
	
		// 코스 전체 조회
		public List<CourseDTO> selectList(HashMap<String, Integer> map) { 
			return sqlSession.selectList("c.course_list", map);
	***REMOVED***
		
		// 전체 코스 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("c.course_count");
	***REMOVED***
	
		// 특정 사용자의 코스 전체 조회
		public List<UserCourseDTO> selectList_user(HashMap<String, Integer> map) { 
			return sqlSession.selectList("c.course_list_user", map);
	***REMOVED***
		
		// 특정 사용자의 전체 코스 수 조회
		public int getRowTotal_user(int user_id) {
			return sqlSession.selectOne("c.course_count_user", user_id);
	***REMOVED***
		
		// 코스 한 건 조회
		public CourseDTO selectOne(int id) {
			return sqlSession.selectOne("c.course_view",id);
	***REMOVED***

		// 삭제 요청된 코스 조회
		public List<CourseDTO> deleteList() { 
			return sqlSession.selectList("c.course_delete_list");
	***REMOVED***
		
		// 코스 추가
		public int insert(CourseDTO dto) {
			return sqlSession.insert("c.course_insert",dto);
	***REMOVED***
		
		// 코스 수정
		public int modify(CourseDTO dto) {
			return sqlSession.update("c.course_modify",dto);
	***REMOVED***
		
		// 코스 삭제한 것처럼 처리
		public int delete_update(int id) {
			return sqlSession.update("c.course_delete_update", id);
	***REMOVED***

		// 코스 물리적 삭제
		public int delete_physical() {
			return sqlSession.delete("c.course_delete");
	***REMOVED***
***REMOVED***
