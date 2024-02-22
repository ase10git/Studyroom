package dao;

import java.util.ArrayList;
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
	
	//로그인 체크
	// 단일 사용자 정보 조회(로그인 이메일확인용)
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("u.login_check",email);
	}
	
	public UserDTO selectOne(int id) {
		return sqlSession.selectOne("u.select_one_by_id", id);
	}
	
	//회원가입
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert",userDTO);
	}
	
	// 사용자 정보 수정	
	public int modify(UserDTO userDTO) {
		return sqlSession.update("u.update", userDTO);
	}
	
	// 사용자 회원 탈퇴(한것처럼 보이게하는 로직)
	public int del_update(UserDTO userDTO) {
		return sqlSession.update("u.del_update",userDTO);
	}
	
	// 전체 사용자 조회(admin용)
	public List<UserDTO> selectList(HashMap<String,Integer> map) {
		return sqlSession.selectList("u.user_list", map);
	}
	
	// 전체 사용자 수 조회
	public int getRowTotal() {
		return sqlSession.selectOne("u.user_count");
	}

	// 삭제 요청한 사용자 조회(admin용)
	public List<UserDTO> deleteList() {
		return sqlSession.selectList("u.delete_list");
	}
	
	// 사용자 물리적 삭제
	public int delete_physical(ArrayList<Integer> userList) {
		return sqlSession.delete("u.user_delete", userList);
	}
}
