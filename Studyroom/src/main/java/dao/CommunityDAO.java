package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CommunityDTO;
import dto.UserCommunityLikeDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommunityDAO {

	final SqlSession sqlSession;
	
	//�������� �Խñ� ��ȸ
		public List<CommunityDTO> selectList(HashMap<String,Integer> map){
			return sqlSession.selectList("cm.community_list",map);
	***REMOVED***
	
		//��ü �Խù� �� ��ȸ
		public int getRowTotal() {
			return sqlSession.selectOne("cm.community_count");
	***REMOVED***
		
		//�Խñ� �� �� ��ȸ
		public CommunityDTO selectOne(int id) {
			return sqlSession.selectOne("cm.community_view",id);
	***REMOVED***
		
		//��ȸ�� ����
		public int update_readhit(int id) {
			int res = sqlSession.update("cm.update_readhit",id);
			return res;
	***REMOVED***
		
		//�Խñ� �߰��ϱ�
		public int insert(CommunityDTO dto) {
			System.out.println("nickName : " + dto.getNickname());
			return sqlSession.insert("cm.community_insert",dto);
	***REMOVED***
		
		//�����Ѱ�ó�� �����ϱ�
		public int del_update(CommunityDTO dto) {
			return sqlSession.update("cm.del_update",dto);
	***REMOVED***
		
		// �Խñ� ������ ����
		public int community_delete() {
			return sqlSession.delete("cm.community_delete");
	***REMOVED***
		
		//����߰��� ���� step + 1
		public int update_step(CommunityDTO dto) {
			return sqlSession.update("cm.community_update_step",dto);
	***REMOVED***
		
		//��� �߰��ϱ�
		public int reply(CommunityDTO dto) {
			return sqlSession.insert("cm.community_reply",dto);
	***REMOVED***
		
		//�Խñ� �����ϱ�
		public int update(CommunityDTO dto) {
			return sqlSession.update("cm.community_update",dto);
	***REMOVED***	
		
		//��� ��ȸ 
		public List<CommunityDTO> select_reply(int ref){
			return sqlSession.selectList("cm.community_reply_list",ref);
	***REMOVED***
		
		// Ư�� ������� Ŀ�´�Ƽ �� ��õ ���� ��ȸ
        public int like_count(UserCommunityLikeDTO likedto) {
            Integer result = sqlSession.selectOne("cm.like_count", likedto);

            return (result != null) ? result.intValue() : 0;
        ***REMOVED***
        
        //����Ŀ�´�Ƽ����ũ ���̺� userid�� communityid�ֱ�
        public int community_like(UserCommunityLikeDTO likedto) {
			return sqlSession.insert("cm.community_like",likedto);
        ***REMOVED***
        
        public int community_likehit(int id) {
        	return sqlSession.update("cm.community_likehit",id);
        ***REMOVED***
        
        
        
***REMOVED***
