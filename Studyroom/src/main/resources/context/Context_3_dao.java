package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.SessionCheckAspect;
import dao.AnnouncementDAO;
import dao.CalendarDAO;
import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserDAO;
import service.SessionService;

@Configuration
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// UserDAO Bean : �����
	@Bean
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
	}

	// AnnouncementDAO Bean : ��ü ��������
	@Bean
	public AnnouncementDAO announcementDAO(SqlSession sqlSession) {
		return new AnnouncementDAO(sqlSession);
	}

	// CourseDAO Bean : �ڽ�
	@Bean
	public CourseDAO courseDAO(SqlSession sqlSession) {
		return new CourseDAO(sqlSession);
	}
	
	// CourseBoardDAO Bean : �ڽ� ������
	@Bean
	public CourseBoardDAO courseBoardDAO(SqlSession sqlSession) {
		return new CourseBoardDAO(sqlSession);
	}
	
	// CommunityDAO Bean : Ŀ�´�Ƽ
	@Bean
	public CommunityDAO communityDAO(SqlSession sqlSession) {
		return new CommunityDAO(sqlSession);
	}
	
	// CalendarDAO Bean : Ķ����
	@Bean
	public CalendarDAO calendarDAO(SqlSession sqlSession) {
		return new CalendarDAO(sqlSession);
	}

	// SessionCheckAspect Bean : ����üũ Advice
	@Bean
	public SessionCheckAspect sessionCheckAspect() {
		return new SessionCheckAspect();
	}
	
	@Bean
	public SessionService sessionService() {
		return new SessionService();
	}
}


