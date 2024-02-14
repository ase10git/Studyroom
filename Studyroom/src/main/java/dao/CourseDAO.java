package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseDAO {
	final SqlSession sqlSession; 
	
//	final UserDTO user_dto;
	
		// �ڽ� ��ü ��ȸ
		public List<CourseDTO> selectList(HashMap<String, Integer> map) { 
			return sqlSession.selectList("c.course_list");
		}
		
		// ��ü �ڽ� �� ��ȸ
		public int getRowTotal() {
			return sqlSession.selectOne("c.course_count");
		}
		
		// �ڽ� �� �� ��ȸ
		public CourseDTO selectOne(int id) {
			return sqlSession.selectOne("c.course_view",id);
		}

		// ���� ��û�� �ڽ� ��ȸ
		public List<CourseDTO> deleteList() { 
			return sqlSession.selectList("c.course_delete_list");
		}
		
		// �ڽ� �߰�
		public int insert(CourseDTO dto) {
			return sqlSession.insert("c.course_insert",dto);
		}
		
		// �ڽ� ����
		public int modify(CourseDTO dto) {
			return sqlSession.update("c.course_modify",dto);
		}
		
		// �ڽ� ������ ��ó�� ó��
		public int delete_update(int id) {
			return sqlSession.update("c.course_delete_update", id);
		}

		// �ڽ� ������ ����
		public int delete_physical() {
			return sqlSession.delete("c.course_delete");
		}
}
