package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseDTO;
import dto.UserCourseDTO;
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
		public int delete_physical(ArrayList<Integer> courseList) {
			// 특정 코스 수강 내역 제거
			this.only_course_delete(courseList);
			
			// 특정 코스들의 공지글 삭제
			CourseBoardDAO course_board_dao = new CourseBoardDAO(sqlSession);
			int res = course_board_dao.delete_physical_course(courseList);
			
			return sqlSession.delete("co.course_delete", courseList);
		}
		
		// 사용자를 코스에 등록
		public int user_course_insert(int user_id, int course_id) {
			// 데이터를 넘겨줄 객체 생성
			// 데이터를 넣을 때는 user_id와 course_id만 넣기
			UserCourseDTO dto = new UserCourseDTO();
			
			// 데이터 넘겨주기
			dto.setUser_id(user_id);
			dto.setId(course_id);
			return sqlSession.insert("co.user_course_insert", dto);
		}
		
		// 특정 사용자를 특정 코스에서 제거
		public int user_course_delete(int user_id, int course_id) {
			// 데이터를 넘겨줄 객체 생성
			// 삭제 요청시에도 user_id와 course_id만 넣기
			UserCourseDTO dto = new UserCourseDTO();
			
			// 데이터 넘겨주기
			dto.setUser_id(user_id);
			dto.setId(course_id);
			return sqlSession.delete("co.user_course_delete", dto);
		}
		
		// 사용자 코스 테이블에서 특정 코스 제거
		public int only_course_delete(ArrayList<Integer> courseList) {
			return sqlSession.delete("co.only_course_delete", courseList);
		}
		
		// 사용자 코스 테이블에서 특정 사용자를 제거
		public int only_user_delete(ArrayList<Integer> userList) {
			return sqlSession.delete("co.only_user_delete", userList);
		}
}
