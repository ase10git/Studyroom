package dao;

import org.apache.ibatis.session.SqlSession;

import dto.UserDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDAO {
	
	final SqlSession sqlSession;
	
	//�α��� üũ
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("u.login_check",email);
***REMOVED***
	
	//ȸ������
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert",userDTO);
***REMOVED***
***REMOVED***
