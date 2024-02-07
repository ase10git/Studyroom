package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.UserDAO;

@Configuration
public class Context_3_dao {
	
	@Bean
	public UserDAO userDAO(SqlSession sqlSession) {
		return new UserDAO(sqlSession);
	}
	
}
