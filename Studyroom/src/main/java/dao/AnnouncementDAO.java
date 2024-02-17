package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnouncementDAO {
	
	final SqlSession sqlSession;
	
	//�������� �Խñ� ��ȸ
	public List<CourseBoardDTO> selectList(HashMap<String, Integer> map) {
		return sqlSession.selectList("a.announcement_list",map);
***REMOVED***
	
	//��ü �Խù� �� ��ȸ
	public int getRowTotal() {
		return sqlSession.selectOne("a.announcement_count");
***REMOVED***
	
	//�Խñ� �� �� ��ȸ
	public CourseBoardDTO selectOne(int id) {
		return sqlSession.selectOne("a.announcement_one", id);
***REMOVED***
	
	//�Խñ� �߰��ϱ�(����)
	public int insert(CourseBoardDTO dto) {
		return sqlSession.insert("a.anouncement_insert",dto);
***REMOVED***
	
	//������ ����
	public int modify(CourseBoardDTO dto) {
		return sqlSession.update("a.announcement_modify",dto);
***REMOVED***
	
	//�����Ѱ�ó�� �����ϱ�(����)
	public int delete_update(CourseBoardDTO dto) {
		return sqlSession.update("a.anouncement_delete_update",dto);
***REMOVED***
	
***REMOVED***
