***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***

import dao.UserDAO;

***REMOVED***
public class Context_3_dao {
	
***REMOVED***
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
***REMOVED***
	
***REMOVED***
