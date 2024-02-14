package dao;

import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

import dto.UserDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDAO {
	
	final SqlSession sqlSession;
	
	//�α��� üũ
	// ���� ����� ���� ��ȸ(�α��� �̸���Ȯ�ο�)
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("u.login_check",email);
***REMOVED***
	
	//ȸ������
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert",userDTO);
***REMOVED***
	
	// ����� ���� ����		// �̿ϼ�
	public int modify(UserDTO userDTO) {
		return sqlSession.update("u.update", userDTO);
***REMOVED***
	
	// ��ü ����� ��ȸ(admin��)	// �̿ϼ�
	public List<UserDTO> selectList() {
		return sqlSession.selectList("u.user_list");
***REMOVED***

***REMOVED***
