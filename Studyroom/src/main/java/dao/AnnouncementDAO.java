package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.AnnouncementDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnouncementDAO {
	
	final SqlSession sqlSession;
	
	//페이지별 게시글 조회
	public List<AnnouncementDTO> selectList(HashMap<String, Integer> map) {
		return sqlSession.selectList("a.announcement_list",map);
***REMOVED***
	
	//전체 게시물 수 조회
	public int getRowTotal() {
		return sqlSession.selectOne("a.announcement_count");
***REMOVED***
	
	//게시글 한 건 조회
	public AnnouncementDTO selectOne(int id) {
		return sqlSession.selectOne("a.aanouncement_one", id);
***REMOVED***
***REMOVED***
