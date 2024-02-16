package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseBoardDAO {
	final SqlSession sqlSession;
	
		//�������� �Խñ� ��ȸ
		public List<CourseBoardDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("cb.board_list",map);
		}
	
		//��ü �Խù� �� ��ȸ
		public int getRowTotal() {
			return sqlSession.selectOne("cb.board_count");
		}
		
		//�Խñ� �� �� ��ȸ
		public CourseBoardDTO selectOne(int idx) {
			return sqlSession.selectOne("cb.board_one",idx);
		}
				
		//�Խñ� �߰��ϱ�
		public int insert(CourseBoardDTO dto) {
			return sqlSession.insert("cb.board_insert",dto);
		}
		
		//�����Ѱ�ó�� �����ϱ�
		public int del_update(CourseBoardDTO dto) {
			return sqlSession.update("cb.del_update",dto);
		}
		
		//����߰��� ���� step + 1
		public int update_step(CourseBoardDTO dto) {
			return sqlSession.update("cb.board_update_step",dto);
		}
		
		//��� �߰��ϱ�
		public int reply(CourseBoardDTO dto) {
			return sqlSession.insert("cb.board_reply",dto);
		}

}
