package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CommunityDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunityDAO {

	final SqlSession sqlSession;
	
	//�������� �Խñ� ��ȸ
		public List<CommunityDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("cm.community_list",map);
		}
	
		//��ü �Խù� �� ��ȸ
		public int getRowTotal() {
			return sqlSession.selectOne("cm.community_count");
		}
		
		//�Խñ� �� �� ��ȸ
		public CommunityDTO selectOne(int id) {
			return sqlSession.selectOne("cm.community_view",id);
		}
		
		//��ȸ�� ����
		public int update_readhit(int id) {
			int res = sqlSession.update("cm.update_readhit",id);
			return res;
		}
		
		//�Խñ� �߰��ϱ�
		public int insert(CommunityDTO dto) {
			System.out.println("nickName : " + dto.getNickname());
			return sqlSession.insert("cm.community_insert",dto);
		}
		
		//�����Ѱ�ó�� �����ϱ�
		public int del_update(CommunityDTO dto) {
			return sqlSession.update("cm.del_update",dto);
		}
		
		// �Խñ� ������ ����
		public int community_delete() {
			return sqlSession.delete("cm.community_delete");
		}
		
		//����߰��� ���� step + 1
		public int update_step(CommunityDTO dto) {
			return sqlSession.update("cm.community_update_step",dto);
		}
		
		//��� �߰��ϱ�
		public int reply(CommunityDTO dto) {
			return sqlSession.insert("cm.community_reply",dto);
		}
		
		//�Խñ� �����ϱ�
		public int update(CommunityDTO dto) {
			return sqlSession.update("cm.community_update",dto);
		}	
		
		//��� ��ȸ 
		public List<CommunityDTO> select_reply(int ref){
			return sqlSession.selectList("cm.community_reply_list",ref);
		}
}
