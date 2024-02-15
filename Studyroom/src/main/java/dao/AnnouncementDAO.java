package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnnouncementDAO {
	
	final SqlSession sqlSession;
	
	//페이지별 게시글 조회
	public List<CourseBoardDTO> selectList(HashMap<String, Integer> map) {
		return sqlSession.selectList("a.announcement_list",map);
***REMOVED***
	
	//전체 게시물 수 조회
	public int getRowTotal() {
		return sqlSession.selectOne("a.announcement_count");
***REMOVED***
	
	//게시글 한 건 조회
	public CourseBoardDTO selectOne(int id) {
		return sqlSession.selectOne("a.announcement_one", id);
***REMOVED***
	
	//게시글 추가하기(어드민)
	public int insert(CourseBoardDTO dto) {
		return sqlSession.insert("a.anouncement_insert",dto);
***REMOVED***
	
	//공지글 수정
	public int modify(CourseBoardDTO dto) {
		return sqlSession.update("a.announcement_modify",dto);
***REMOVED***
	
	//삭제한것처럼 수정하기(어드민)
	public int delete_update(CourseBoardDTO dto) {
		return sqlSession.update("a.anouncement_delete_update",dto);
***REMOVED***
	
***REMOVED***
