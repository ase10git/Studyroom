package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseBoardDAO {
	final SqlSession sqlSession;

		// �������� �ڽ� ������ ��ȸ
		public List<CourseBoardDTO> selectList(HashMap<String, Integer> map){
			return sqlSession.selectList("cb.board_list");
		}
	
		// ��ü �ڽ� ������ �� ��ȸ
		public int getRowTotal() {
			return sqlSession.selectOne("cb.board_count");
		}
		
		// �ڽ� ������ �� �� ��ȸ
		public CourseBoardDTO selectOne(int id) {
			return sqlSession.selectOne("cb.board_one", id);
		}
				
		// �ڽ� ������ �߰��ϱ�
		public int insert(CourseBoardDTO dto) {
			return sqlSession.insert("cb.board_insert",dto);
		}

		// �ڽ� ������ �����ϱ�
		public int modify(CourseBoardDTO dto) {
			return sqlSession.update("cb.board_modify",dto);
		}
		
		// �����Ѱ�ó�� �����ϱ�
		public int delete_update(int id) {
			return sqlSession.update("cb.board_delete_update",id);
		}
		
		// �ڽ� ������ ������ ����
		public int delete_physical() {
			return sqlSession.delete("cb.board_delete");
		}

}
