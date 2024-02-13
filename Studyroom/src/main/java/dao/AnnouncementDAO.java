package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.AnnouncementDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnouncementDAO {
	
	final SqlSession sqlSession;
	
	//�������� �Խñ� ��ȸ
	public List<AnnouncementDTO> selectList(HashMap<String, Integer> map) {
		return sqlSession.selectList("a.announcement_list",map);
***REMOVED***
	
	//��ü �Խù� �� ��ȸ
	public int getRowTotal() {
		return sqlSession.selectOne("a.announcement_count");
***REMOVED***
	
	//�Խñ� �� �� ��ȸ
	public AnnouncementDTO selectOne(int id) {
		return sqlSession.selectOne("a.aanouncement_one", id);
***REMOVED***
***REMOVED***
