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
			return sqlSession.selectList("co.course_list", map);
		}
		
		// 전체 코스 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("co.course_count");
		}
	
		// 특정 사용자의 코스 전체 조회
		public List<UserCourseDTO> selectList_user(HashMap<String, Integer> map) { 
			return sqlSession.selectList("co.course_list_user", map);
		}
		
		// 특정 사용자의 전체 코스 수 조회
		public int getRowTotal_user(int user_id) {
			return sqlSession.selectOne("co.course_count_user", user_id);
		}
		
		// 코스 한 건 조회
		public CourseDTO selectOne(int id) {
			return sqlSession.selectOne("co.course_view",id);
		}

		// 삭제 요청된 코스 조회
		public List<CourseDTO> deleteList() { 
			return sqlSession.selectList("co.course_delete_list");
		}
		
		// 코스 추가
		public int insert(CourseDTO dto) {
			return sqlSession.insert("co.course_insert",dto);
		}
		
		// 코스 수정
		public int modify(CourseDTO dto) {
			return sqlSession.update("co.course_modify",dto);
		}
		
		// 코스 삭제한 것처럼 처리
		public int delete_update(int id) {
			return sqlSession.update("co.course_delete_update", id);
		}

		// 코스 물리적 삭제
		public int delete_physical() {
			return sqlSession.delete("co.course_delete");
		}
}
