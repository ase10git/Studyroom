package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import advice.SessionCheckAspect;
import dao.UserDAO;

@Configuration
public class Context_3_dao {
	
	// UserDAO bean 생성
	@Bean
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
	}
	
	// SessionCheckAspect 클래스 bean 생성
	@Bean
	public SessionCheckAspect sessionCheckAspect() {
		return new SessionCheckAspect();
	}
	
	
}
