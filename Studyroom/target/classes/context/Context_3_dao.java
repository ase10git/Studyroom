***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.SessionCheckAspect;
import dao.AnnouncementDAO;
import dao.CalendarDAO;
import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserDAO;

***REMOVED***
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// UserDAO Bean : �����
***REMOVED***
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
***REMOVED***

	// AnnouncementDAO Bean : ��ü ��������
***REMOVED***
	public AnnouncementDAO announcementDAO(SqlSession sqlSession) {
		return new AnnouncementDAO(sqlSession);
***REMOVED***

	// CourseDAO Bean : �ڽ�
***REMOVED***
	public CourseDAO courseDAO(SqlSession sqlSession) {
		return new CourseDAO(sqlSession);
***REMOVED***
	
	// CourseBoardDAO Bean : �ڽ� ������
***REMOVED***
	public CourseBoardDAO courseBoardDAO(SqlSession sqlSession) {
		return new CourseBoardDAO(sqlSession);
***REMOVED***
	
	// CommunityDAO Bean : Ŀ�´�Ƽ
***REMOVED***
	public CommunityDAO communityDAO(SqlSession sqlSession) {
		return new CommunityDAO(sqlSession);
***REMOVED***
	
	// CalendarDAO Bean : Ķ����
***REMOVED***
	public CalendarDAO calendarDAO(SqlSession sqlSession) {
		return new CalendarDAO(sqlSession);
***REMOVED***

	// SessionCheckAspect Bean : ����üũ Advice
***REMOVED***
	public SessionCheckAspect sessionCheckAspect() {
		return new SessionCheckAspect();
***REMOVED***
***REMOVED***


