package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import dto.UserDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDAO {
	
	final SqlSession sqlSession;
	
	// 단일 사용자 정보 조회
	public UserDTO selectOne(int id) {
		return sqlSession.selectOne("user.user_one", id);
	}
	
	// 사용자 정보 수정
	
	
	// 전체 사용자 조회(admin용)
	public List<UserDTO> selectList() {
		return sqlSession.selectList("user.user_list");
	}
	
	
}
