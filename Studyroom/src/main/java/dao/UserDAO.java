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
	
	// ���� ����� ���� ��ȸ(�α��� �̸���Ȯ�ο�)
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("u.login_check", email);
	}
	
	// ����� �߰�(ȸ������)
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert", userDTO);
	}
	
	// ����� ���� ����		// �̿ϼ�
	public int modify(UserDTO userDTO) {
		return sqlSession.update("u.update", userDTO);
	}
	
	// ��ü ����� ��ȸ(admin��)	// �̿ϼ�
	public List<UserDTO> selectList() {
		return sqlSession.selectList("u.user_list");
	}
	
	
}
