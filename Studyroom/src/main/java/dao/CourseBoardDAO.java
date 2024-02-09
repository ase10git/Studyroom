package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseBoardDAO {
	final SqlSession sqlSession;

		// 페이지별 코스 공지글 조회
		public List<CourseBoardDTO> selectList(HashMap<String, Integer> map){
			return sqlSession.selectList("cb.board_list");
	***REMOVED***
	
		// 전체 코스 공지글 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("cb.board_count");
	***REMOVED***
		
		// 코스 공지글 한 건 조회
		public CourseBoardDTO selectOne(int id) {
			return sqlSession.selectOne("cb.board_one", id);
	***REMOVED***
				
		// 코스 공지글 추가하기
		public int insert(CourseBoardDTO dto) {
			return sqlSession.insert("cb.board_insert",dto);
	***REMOVED***

		// 코스 공지글 수정하기
		public int modify(CourseBoardDTO dto) {
			return sqlSession.update("cb.board_modify",dto);
	***REMOVED***
		
		// 삭제한것처럼 수정하기
		public int delete_update(int id) {
			return sqlSession.update("cb.board_delete_update",id);
	***REMOVED***
		
		// 코스 공지글 물리적 삭제
		public int delete_physical() {
			return sqlSession.delete("cb.board_delete");
	***REMOVED***

***REMOVED***
