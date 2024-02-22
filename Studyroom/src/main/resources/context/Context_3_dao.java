***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import dao.AnnouncementDAO;
import dao.CalendarDAO;
import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserCourseDAO;
import dao.UserCourseViewDAO;
import dao.UserDAO;
import service.DeleteService;

***REMOVED***
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// UserDAO Bean : 사용자
***REMOVED***
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
***REMOVED***

	// AnnouncementDAO Bean : 전체 공지사항
***REMOVED***
	public AnnouncementDAO announcementDAO(SqlSession sqlSession) {
		return new AnnouncementDAO(sqlSession);
***REMOVED***

	// CourseDAO Bean : 코스
***REMOVED***
	public CourseDAO courseDAO(SqlSession sqlSession) {
		return new CourseDAO(sqlSession);
***REMOVED***
	
	// CourseBoardDAO Bean : 코스 공지글
***REMOVED***
	public CourseBoardDAO courseBoardDAO(SqlSession sqlSession) {
		return new CourseBoardDAO(sqlSession);
***REMOVED***
	
	// CommunityDAO Bean : 커뮤니티
***REMOVED***
	public CommunityDAO communityDAO(SqlSession sqlSession) {
		return new CommunityDAO(sqlSession);
***REMOVED***
	
	// CalendarDAO Bean : 캘린더
***REMOVED***
	public CalendarDAO calendarDAO(SqlSession sqlSession) {
		return new CalendarDAO(sqlSession);
***REMOVED***

	// UserCourseDAO Bean : 사용자-코스
***REMOVED***
	public UserCourseDAO userCourseDAO(SqlSession sqlSession) {
		return new UserCourseDAO(sqlSession);
***REMOVED***
		
	// UserCourseViewDAO Bean : 사용자-코스
***REMOVED***
	public UserCourseViewDAO userCourseViewDAO(SqlSession sqlSession) {
		return new UserCourseViewDAO(sqlSession);
***REMOVED***

	// DeleteService : 삭제 서비스
***REMOVED***
	public DeleteService deleteService(UserDAO user_dao, CourseDAO course_dao, CourseBoardDAO course_board_dao, UserCourseDAO user_course_dao, CommunityDAO community_dao, CalendarDAO calendar_dao) {
		return new DeleteService(user_dao, course_dao, course_board_dao, user_course_dao, community_dao, calendar_dao);
***REMOVED***

***REMOVED***


