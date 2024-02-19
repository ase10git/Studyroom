package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseDAO {
	final SqlSession sqlSession; 
	
		// 코스 전체 조회
		public List<CourseDTO> selectList(HashMap<String, Integer> map) { 
			return sqlSession.selectList("co.course_list", map);
		}
		
		// 전체 코스 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("co.course_count");
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
		public int delete_physical(ArrayList<Integer> courseList) {
			// 특정 코스 수강 내역 제거
			UserCourseDAO user_course_dao = new UserCourseDAO(sqlSession);
			int res_user = user_course_dao.course_delete(courseList);
			
			// 특정 코스들의 공지글 삭제
			CourseBoardDAO course_board_dao = new CourseBoardDAO(sqlSession);
			int res_board = course_board_dao.delete_physical_course(courseList);
			
			return sqlSession.delete("co.course_delete", courseList);
		}
		
}
