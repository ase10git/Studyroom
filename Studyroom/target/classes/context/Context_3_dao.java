package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.SessionCheckAspect;
import dao.UserDAO;

@Configuration
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// UserDAO bean 积己
	@Bean
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
	}
	
	// SessionCheckAspect 努贰胶 bean 积己
	@Bean
	public SessionCheckAspect sessionCheckAspect() {
		return new SessionCheckAspect();
	}
	
	
}
