package dao;

import org.apache.ibatis.session.SqlSession;

import dto.UserDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDAO {

	
final SqlSession sqlSession;
	
	//로그인 체크
	public UserDTO selectOne(String id) {
		return sqlSession.selectOne("u.loginCheck",id);
	}
	
	public int insert(UserDTO dto) {
		return sqlSession.insert("u.insert",dto);
	}
	
	
}
