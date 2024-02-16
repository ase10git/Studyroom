package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.CalenderDAO;

@Configuration
public class Context_3_dao {
	
//	@Bean
//	public BoardDAO boardDAO(SqlSession sqlSession) {
//		return new BoardDAO(sqlSession);
//	}
	@Bean
	public CalenderDAO calenderDAO(SqlSession sqlSession) {
		return new CalenderDAO(sqlSession);
	}
	
}
