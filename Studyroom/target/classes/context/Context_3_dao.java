***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.SessionCheckAspect;
import dao.UserDAO;

***REMOVED***
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// UserDAO bean 积己
***REMOVED***
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
***REMOVED***
	
	// SessionCheckAspect 努贰胶 bean 积己
***REMOVED***
	public SessionCheckAspect sessionCheckAspect() {
		return new SessionCheckAspect();
***REMOVED***
	
	
***REMOVED***
