package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// UserDAO Bean : 사용자
	@Bean
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
	}

	// AnnouncementDAO Bean : 전체 공지사항
	@Bean
	public AnnouncementDAO announcementDAO(SqlSession sqlSession) {
		return new AnnouncementDAO(sqlSession);
	}

	// CourseDAO Bean : 코스
	@Bean
	public CourseDAO courseDAO(SqlSession sqlSession) {
		return new CourseDAO(sqlSession);
	}
	
	// CourseBoardDAO Bean : 코스 공지글
	@Bean
	public CourseBoardDAO courseBoardDAO(SqlSession sqlSession) {
		return new CourseBoardDAO(sqlSession);
	}
	
	// CommunityDAO Bean : 커뮤니티
	@Bean
	public CommunityDAO communityDAO(SqlSession sqlSession) {
		return new CommunityDAO(sqlSession);
	}
	
	// CalendarDAO Bean : 캘린더
	@Bean
	public CalendarDAO calendarDAO(SqlSession sqlSession) {
		return new CalendarDAO(sqlSession);
	}

	// UserCourseDAO Bean : 사용자-코스
	@Bean
	public UserCourseDAO userCourseDAO(SqlSession sqlSession) {
		return new UserCourseDAO(sqlSession);
	}
		
	// UserCourseViewDAO Bean : 사용자-코스
	@Bean
	public UserCourseViewDAO userCourseViewDAO(SqlSession sqlSession) {
		return new UserCourseViewDAO(sqlSession);
	}
			
	// DeleteService : 삭제 서비스
	@Bean
	public DeleteService deleteService(UserDAO user_dao, CourseDAO course_dao, CourseBoardDAO course_board_dao, UserCourseDAO user_course_dao, CommunityDAO community_dao, CalendarDAO calendar_dao) {
		return new DeleteService(user_dao, course_dao, course_board_dao, user_course_dao, community_dao, calendar_dao);
	}

}


