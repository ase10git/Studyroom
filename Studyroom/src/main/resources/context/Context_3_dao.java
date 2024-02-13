package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.Advice;
import dao.CalendarDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;

import dao.AnnouncementDAO;
import dao.UserDAO;

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
	
	// CalendarDAO Bean : 캘린더
	@Bean
	public CalendarDAO calendarDAO(SqlSession sqlSession) {
		return new CalendarDAO(sqlSession);
	}
	
	// AOP
	@Bean
	public Advice advice() {
		return new Advice();
	}
}