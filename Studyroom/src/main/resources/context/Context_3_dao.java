***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***

import advice.SessionCheckAspect;
import dao.UserDAO;

***REMOVED***
public class Context_3_dao {
	
	// UserDAO bean ����
***REMOVED***
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
***REMOVED***
	
	// SessionCheckAspect Ŭ���� bean ����
***REMOVED***
	public SessionCheckAspect sessionCheckAspect() {
		return new SessionCheckAspect();
***REMOVED***
	
	
***REMOVED***
