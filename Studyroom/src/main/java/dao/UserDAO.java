package dao;

import org.apache.ibatis.session.SqlSession;

import dto.UserDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDAO {
	
	final SqlSession sqlSession;
	
	//�α���
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("login_check",email);
	}
	
	//ȸ������
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert",userDTO);
	}
}
