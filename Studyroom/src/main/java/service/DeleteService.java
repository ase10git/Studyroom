package service;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CalendarDAO;
import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserCourseDAO;
import dao.UserDAO;
import lombok.RequiredArgsConstructor;

// 삭제 관리 서비스
// DB에 저장된 del_flag = -1인 데이터들을 물리적으로 삭제한다.
@Service
@RequiredArgsConstructor
public class DeleteService {
	
	final UserDAO user_dao;
	final CourseDAO course_dao;
	final CourseBoardDAO course_board_dao;
	final UserCourseDAO user_course_dao;
	final CommunityDAO community_dao;
	final CalendarDAO calendar_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	public void delete_all() {
		// 페이지에서 삭제 체크박스로 선택한 각 카테고리의 id 정보를 배열로 가져옴
		String[] userId = request.getParameterValues("userId");
		String[] courseId = request.getParameterValues("courseId");
		String[] courseboardId = request.getParameterValues("courseboardId");
		String[] communityId = request.getParameterValues("communityId");
	
		// DB에 넘겨주기 위해 List에 저장
		ArrayList<Integer> userList = new ArrayList<>();
		ArrayList<Integer> courseList = new ArrayList<>();
		ArrayList<Integer> courseBoardList = new ArrayList<>();
		ArrayList<Integer> communityList = new ArrayList<>();
		
		// 각 카테고리의 삭제 요청 결과를 저장하는 변수
		// -1 : 페이지에서 선택된 id가 없음(userId, courseId, courseboardId, communityId)
		// 1 : 삭제 요청 성공
		// 0 : 삭제 요청 실패
		int userResult = -1;
		int courseResult = -1;
		int courseBoardResult = -1;
		int communityResult = -1;
		
		// List에 데이터를 저장하고, 각 카테고리별 삭제 동작 수행
		// 코스 공지글 제거
		if (courseboardId != null) { 
			for(int i = 0; i < courseboardId.length; i++) {
				courseBoardList.add(Integer.parseInt(courseboardId[i]));
		***REMOVED***
			
			System.out.println("courseboardId : " + Arrays.toString(courseboardId));
			courseBoardResult = course_board_dao.delete_physical(courseBoardList);
			
			// 코스 공지글 삭제 결과 점검
			if (courseBoardResult == 0) {
				System.out.println("공지글 삭제를 실패했습니다.");
		***REMOVED*** 
	***REMOVED***	
				
		// 커뮤니티 게시글 제거
		if (communityId != null) { 
			for(int i = 0; i < communityId.length; i++) {
				communityList.add(Integer.parseInt(communityId[i]));
		***REMOVED***	
			
			System.out.println("communityId : " + Arrays.toString(communityId));
			communityResult = community_dao.delete_physical(communityList);
			
			// 커뮤니티 게시글 삭제 결과 점검
			if (communityResult == 0) {
				System.out.println("커뮤니티 게시글 삭제를 실패했습니다.");
		***REMOVED*** 
	***REMOVED***
		
		// 코스 제거
		if (courseId != null) { 
			for(int i = 0; i < courseId.length; i++) {
				courseList.add(Integer.parseInt(courseId[i]));
		***REMOVED***
			
			user_course_dao.course_delete(courseList);
			
			System.out.println("courseId : " + Arrays.toString(courseId));
			courseResult = course_dao.delete_physical(courseList);
			
			// 코스 제거 결과 점검
			if (courseResult == 0) {
				System.out.println("코스 삭제를 실패했습니다.");
		***REMOVED***
	***REMOVED***
		
		// 사용자 제거
		if (userId != null) { 
			for(int i = 0; i < userId.length; i++) {
				userList.add(Integer.parseInt(userId[i]));
		***REMOVED***
			
			// 캘린더 테이블에서 사용자 데이터 제거			
			calendar_dao.deleteUser(userList);
			
			// 사용자 코스 테이블에서 사용자 데이터 제거
			user_course_dao.user_delete(userList);
			
			// 사용자 커뮤니티 추천 테이블에서 사용자 데이터 제거
			community_dao.only_user_delete(userList);
			
			// 커뮤니티 테이블에서 사용자 데이터 제거
			community_dao.delete_user(userList);
			
			// 사용자 테이블에서 사용자 제거		
			System.out.println("userId : " + Arrays.toString(userId));
			userResult = user_dao.delete_physical(userList);
			
			// 사용자 삭제 결과 점검
			if (userResult == 0) {
				System.out.println("사용자 삭제를 실패했습니다.");
		***REMOVED*** 
	***REMOVED***
			
		
***REMOVED***
	
***REMOVED***
