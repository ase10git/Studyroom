***REMOVED***

***REMOVED***

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
***REMOVED***
***REMOVED***
import org.springframework.core.io.ClassPathResource;

import lombok.RequiredArgsConstructor;

***REMOVED***
@RequiredArgsConstructor
public class Context_2_myBatis {
	
	final DataSource ds;
	
***REMOVED***
	public SqlSessionFactory factoryBean() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(ds);
		
		// mapper�� �˰��ִ� mybatis-config.xml ������ ��ġ�� �˷���� ��
		factoryBean.setConfigLocation(new ClassPathResource("config/mybatis/mybatis-config.xml"));
		
		return factoryBean.getObject();
***REMOVED***
	
***REMOVED***
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factoryBean) {
		return new SqlSessionTemplate(factoryBean);
   ***REMOVED***

***REMOVED***
