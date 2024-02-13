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
	
	// ���� ����� ���� ��ȸ
	public UserDTO selectOne(int id) {
		return sqlSession.selectOne("user.user_one", id);
	}
	
	// ����� ���� ����
	
	
	// ��ü ����� ��ȸ(admin��)
	public List<UserDTO> selectList() {
		return sqlSession.selectList("user.user_list");
	}
	
	
}
