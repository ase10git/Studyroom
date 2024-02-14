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
	
	//로그인 체크
	// 단일 사용자 정보 조회(로그인 이메일확인용)
	public UserDTO selectOne(String email) {
		return sqlSession.selectOne("u.login_check",email);
***REMOVED***
	
	//회원가입
	public int insert(UserDTO userDTO) {
		return sqlSession.insert("u.insert",userDTO);
***REMOVED***
	
	// 사용자 정보 수정		// 미완성
	public int modify(UserDTO userDTO) {
		return sqlSession.update("u.update", userDTO);
***REMOVED***
	
	// 전체 사용자 조회(admin용)	// 미완성
	public List<UserDTO> selectList() {
		return sqlSession.selectList("u.user_list");
***REMOVED***

***REMOVED***
