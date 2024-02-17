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
	
		// �ڽ� ��ü ��ȸ
		public List<CourseDTO> selectList(HashMap<String, Integer> map) { 
			return sqlSession.selectList("co.course_list", map);
	***REMOVED***
		
		// ��ü �ڽ� �� ��ȸ
		public int getRowTotal() {
			return sqlSession.selectOne("co.course_count");
	***REMOVED***
	
		// Ư�� ������� �ڽ� ��ü ��ȸ
		public List<UserCourseDTO> selectList_user(HashMap<String, Integer> map) { 
			return sqlSession.selectList("co.course_list_user", map);
	***REMOVED***
		
		// Ư�� ������� ��ü �ڽ� �� ��ȸ
		public int getRowTotal_user(int user_id) {
			return sqlSession.selectOne("co.course_count_user", user_id);
	***REMOVED***
		
		// �ڽ� �� �� ��ȸ
		public CourseDTO selectOne(int id) {
			return sqlSession.selectOne("co.course_view",id);
	***REMOVED***

		// ���� ��û�� �ڽ� ��ȸ
		public List<CourseDTO> deleteList() { 
			return sqlSession.selectList("co.course_delete_list");
	***REMOVED***
		
		// �ڽ� �߰�
		public int insert(CourseDTO dto) {
			return sqlSession.insert("co.course_insert",dto);
	***REMOVED***
		
		// �ڽ� ����
		public int modify(CourseDTO dto) {
			return sqlSession.update("co.course_modify",dto);
	***REMOVED***
		
		// �ڽ� ������ ��ó�� ó��
		public int delete_update(int id) {
			return sqlSession.update("co.course_delete_update", id);
	***REMOVED***

		// �ڽ� ������ ����
		public int delete_physical() {
			return sqlSession.delete("co.course_delete");
	***REMOVED***
***REMOVED***
