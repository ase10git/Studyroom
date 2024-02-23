package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dto.UserCourseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCourseDAO {

	final SqlSession sqlSession; 
	
	// 사용자의 코스들 조회와 코스의 사용자들 조회는 UserCourseViewDAO에서도 확인 가능
	
	// 사용자를 코스에 등록
	public int insert(UserCourseDTO dto) {
		return sqlSession.insert("uco.user_course_insert", dto);
	}
	
	// 특정 사용자를 특정 코스에서 제거
	public int delete(UserCourseDTO dto) {
		return sqlSession.delete("uco.user_course_delete", dto);
	}
	
	// 사용자 코스 테이블에서 특정 코스 제거
	public int course_delete(ArrayList<Integer> courseList) {
		return sqlSession.delete("uco.course_delete", courseList);
	}
	
	// 사용자 코스 테이블에서 특정 사용자를 제거
	public int user_delete(ArrayList<Integer> userList) {
		return sqlSession.delete("uco.user_delete", userList);
	}
}
