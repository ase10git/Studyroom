package dao;

import org.apache.ibatis.session.SqlSession;

import dto.UserDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDAO {
	
	final SqlSession sqlSession;
	
	//로그인
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("login_check",email);
	}
	
	//회원가입
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert",userDTO);
	}
}
