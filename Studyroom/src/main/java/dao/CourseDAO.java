package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseDAO {
	final SqlSession sqlSession; 
	
//	final UserDTO user_dto;
	
		// �ڽ� ��ü ��ȸ
		public List<CourseDTO> selectList() {
			return sqlSession.selectList("c.course_list");
		}
		
		// �ڽ� �� �� ��ȸ
		public CourseDTO selectOne(int idx) {
			return sqlSession.selectOne("c.course_view",idx);
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
		public int delete_update(CourseDTO dto) {
			return sqlSession.update("c.course_delete_update",dto);
		}

		// �ڽ� ������ ����
		public int delete_physical(int id) {
			return sqlSession.delete("c.course_delete", id);
		}
}
