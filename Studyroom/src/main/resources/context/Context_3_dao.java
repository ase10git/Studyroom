package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.Advice;
import dao.CourseBoardDAO;
import dao.CourseDAO;

@Configuration
@EnableAspectJAutoProxy
public class Context_3_dao {
	
	// CourseDAO Bean : �ڽ�
	@Bean
	public CourseDAO courseDAO(SqlSession sqlSession) {
		return new CourseDAO(sqlSession);
	}
	
	// CourseBoardDAO Bean : �ڽ� ������
	@Bean
	public CourseBoardDAO courseBoardDAO(SqlSession sqlSession) {
		return new CourseBoardDAO(sqlSession);
	}
	
	// AOP
	@Bean
	public Advice advice() {
		return new Advice();
	}
}
