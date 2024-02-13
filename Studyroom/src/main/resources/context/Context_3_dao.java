package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.CommunityDAO;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Context_3_dao {
	
	final SqlSession sqlSession;
	
	@Bean
	public CommunityDAO communityDAO() {
		return new CommunityDAO(sqlSession);
	}
//	
//	@Bean
//	public UserDAO userDAO(SqlSession sqlSession) {
//		return new UserDAO(sqlSession);
//	}
}
