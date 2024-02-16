package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseDAO {
	final SqlSession sqlSession; 
	
		// 코스 전체 조회
		public List<CourseDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("c.course_list",map);
		}
		
		// 코스 한 건 조회
		public CourseDTO selectOne(int idx) {
			return sqlSession.selectOne("c.course_view",idx);
		}

		// 코스 추가
		public int insert(CourseDTO dto) {
			return sqlSession.insert("c.course_insert",dto);
		}
		
		// 코스 삭제한 것처럼 처리
		public int del_update(CourseDTO dto) {
			return sqlSession.update("c.course_del_update",dto);
		}

		// 코스 수정
		public int update(CourseDTO dto) {
			return sqlSession.update("c.course_update",dto);
		}
}
