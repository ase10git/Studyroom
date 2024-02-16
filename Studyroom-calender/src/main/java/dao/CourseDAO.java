package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseDAO {
	final SqlSession sqlSession; 
	
		// �ڽ� ��ü ��ȸ
		public List<CourseDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("c.course_list",map);
		}
		
		// �ڽ� �� �� ��ȸ
		public CourseDTO selectOne(int idx) {
			return sqlSession.selectOne("c.course_view",idx);
		}

		// �ڽ� �߰�
		public int insert(CourseDTO dto) {
			return sqlSession.insert("c.course_insert",dto);
		}
		
		// �ڽ� ������ ��ó�� ó��
		public int del_update(CourseDTO dto) {
			return sqlSession.update("c.course_del_update",dto);
		}

		// �ڽ� ����
		public int update(CourseDTO dto) {
			return sqlSession.update("c.course_update",dto);
		}
}
