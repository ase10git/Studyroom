***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***

import dao.CourseBoardDAO;
import dao.CourseDAO;

***REMOVED***
public class Context_3_dao {
	
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

***REMOVED***
