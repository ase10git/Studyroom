***REMOVED***

import org.apache.ibatis.session.SqlSession;
***REMOVED***
***REMOVED***

import dao.CommunityDAO;
import lombok.RequiredArgsConstructor;

***REMOVED***
@RequiredArgsConstructor
public class Context_3_dao {
	
	final SqlSession sqlSession;
	
***REMOVED***
	public CommunityDAO communityDAO() {
		return new CommunityDAO(sqlSession);
***REMOVED***
//	
//***REMOVED***
//	public UserDAO userDAO(SqlSession sqlSession) {
//		return new UserDAO(sqlSession);
//***REMOVED***
***REMOVED***
