package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.study.AnnouncementController;

import dto.CourseBoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseBoardDAO {
	final SqlSession sqlSession;

		// 페이지별 코스 공지글 조회
		public List<CourseBoardDTO> selectList(HashMap<String, Integer> map){
			return sqlSession.selectList("cb.board_list", map);
	***REMOVED***
	
		// 전체 코스 공지글 중 삭제 안된 글의 수 조회
		public int getRowTotal(int course_id) {
			return sqlSession.selectOne("cb.board_count", course_id);
	***REMOVED***
		
		// 코스 공지글 한 건 조회
		public CourseBoardDTO selectOne(int id) {
			return sqlSession.selectOne("cb.board_one", id);
	***REMOVED***
			
		// 삭제 요청된 코스 공지글 조회
		public List<CourseBoardDTO> deleteList() {
			return sqlSession.selectList("cb.board_delete_list");
	***REMOVED***
		
		// 코스 공지글 추가하기
		public int insert(CourseBoardDTO dto) {
			// 전체 공지글 추가
			int course_id = dto.getCourse_id();
			
			if (course_id == 0) {
				return sqlSession.insert("a.announcement_insert", dto);
		***REMOVED*** else {
				return sqlSession.insert("cb.board_insert", dto);
		***REMOVED***
	***REMOVED***

		// 코스 공지글 수정하기
		public int modify(CourseBoardDTO dto) {
			return sqlSession.update("cb.board_modify", dto);
	***REMOVED***
		
		// 삭제한 것처럼 수정하기
		public int delete_update(int id) {
			// id로 공지글 조회
			CourseBoardDTO dto = this.selectOne(id);
			
			// 첨부된 파일 제거
			AnnouncementController.fileManager.fileDelete(dto);
			
			return sqlSession.update("cb.board_delete_update", id);
	***REMOVED***
		
		// 삭제된 코스의 공지글들도 삭제한 것처럼 수정하기
		public int delete_update_course(int course_id) {
			return sqlSession.update("cb.delete_update_course", course_id);
	***REMOVED***
		
		// 코스 공지글 물리적 삭제
		public int delete_physical(ArrayList<Integer> courseBoardList) {
			return sqlSession.delete("cb.board_delete", courseBoardList);
	***REMOVED***

		// 특정 코스들의 공지글 물리적 삭제
		public int delete_physical_course(ArrayList<Integer> courseList) {
			return sqlSession.delete("cb.board_delete_course", courseList);
	***REMOVED***
***REMOVED***
