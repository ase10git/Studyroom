package dao;

import lombok.RequiredArgsConstructor;


// sample dao
// 파일을 바꾸지 말고 복사해서 사용해주세요
@RequiredArgsConstructor
public class TestDAO {

//	SqlSession sqlSession;
//	
//	//페이지별 게시글 조회
//		public List<BoardDTO> selectList(HashMap<String,Integer> map){
//			return sqlSession.selectList("b.board_list",map);
//		}
//	
//		//전체 게시물 수 조회
//		public int getRowTotal() {
//			return sqlSession.selectOne("b.board_count");
//		}
//		
//		//게시글 한 건 조회
//		public BoardDTO selectOne(int idx) {
//			return sqlSession.selectOne("b.board_one",idx);
//		}
//		
//		//조회수 증가
//		public int update_readhit(int idx) {
//			int res = sqlSession.update("b.update_readhit",idx);
//			return res;
//		}
//		
//		//게시글 추가하기
//		public int insert(BoardDTO dto) {
//			return sqlSession.insert("b.board_insert",dto);
//		}
//		
//		//삭제한것처럼 수정하기
//		public int del_update(BoardDTO dto) {
//			return sqlSession.update("b.del_update",dto);
//		}
//		
//		//댓글추가를 위한 step + 1
//		public int update_step(BoardDTO dto) {
//			return sqlSession.update("b.board_update_step",dto);
//		}
//		
//		//답글 추가하기
//		public int reply(BoardDTO dto) {
//			return sqlSession.insert("b.board_reply",dto);
//		}
		
	
}
