***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.Advice;
import dao.CalendarDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;

import dao.AnnouncementDAO;
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
	
	// CalendarDAO Bean : Ķ����
***REMOVED***
	public CalendarDAO calendarDAO(SqlSession sqlSession) {
		return new CalendarDAO(sqlSession);
***REMOVED***
	
	// AOP
***REMOVED***
	public Advice advice() {
		return new Advice();
***REMOVED***
***REMOVED***