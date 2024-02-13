package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseBoardDAO {
	final SqlSession sqlSession;
	
		//페이지별 게시글 조회
		public List<CourseBoardDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("cb.board_list",map);
		}
	
		//전체 게시물 수 조회
		public int getRowTotal() {
			return sqlSession.selectOne("cb.board_count");
		}
		
		//게시글 한 건 조회
		public CourseBoardDTO selectOne(int idx) {
			return sqlSession.selectOne("cb.board_one",idx);
		}
				
		//게시글 추가하기
		public int insert(CourseBoardDTO dto) {
			return sqlSession.insert("cb.board_insert",dto);
		}
		
		//삭제한것처럼 수정하기
		public int del_update(CourseBoardDTO dto) {
			return sqlSession.update("cb.del_update",dto);
		}
		
		//댓글추가를 위한 step + 1
		public int update_step(CourseBoardDTO dto) {
			return sqlSession.update("cb.board_update_step",dto);
		}
		
		//답글 추가하기
		public int reply(CourseBoardDTO dto) {
			return sqlSession.insert("cb.board_reply",dto);
		}

}
