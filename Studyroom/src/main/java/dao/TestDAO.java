package dao;

import org.apache.ibatis.session.SqlSession;


// sample dao
// ������ �ٲ��� ���� �����ؼ� ������ּ���
//@RequiredArgsConstructor
public class TestDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void test() {
		System.out.println("-- call TestDAO.test()---");
	}

//	SqlSession sqlSession;
//	
//	//�������� �Խñ� ��ȸ
//		public List<BoardDTO> selectList(HashMap<String,Integer> map){
//			return sqlSession.selectList("b.board_list",map);
//		}
//	
//		//��ü �Խù� �� ��ȸ
//		public int getRowTotal() {
//			return sqlSession.selectOne("b.board_count");
//		}
//		
//		//�Խñ� �� �� ��ȸ
//		public BoardDTO selectOne(int idx) {
//			return sqlSession.selectOne("b.board_one",idx);
//		}
//		
//		//��ȸ�� ����
//		public int update_readhit(int idx) {
//			int res = sqlSession.update("b.update_readhit",idx);
//			return res;
//		}
//		
//		//�Խñ� �߰��ϱ�
//		public int insert(BoardDTO dto) {
//			return sqlSession.insert("b.board_insert",dto);
//		}
//		
//		//�����Ѱ�ó�� �����ϱ�
//		public int del_update(BoardDTO dto) {
//			return sqlSession.update("b.del_update",dto);
//		}
//		
//		//����߰��� ���� step + 1
//		public int update_step(BoardDTO dto) {
//			return sqlSession.update("b.board_update_step",dto);
//		}
//		
//		//��� �߰��ϱ�
//		public int reply(BoardDTO dto) {
//			return sqlSession.insert("b.board_reply",dto);
//		}
		
	
}
