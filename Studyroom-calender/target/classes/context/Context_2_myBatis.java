***REMOVED***

***REMOVED***

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
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
		
		// mapper를 알고있는 mybatis-config.xml 파일의 위치를 알려줘야 함
		factoryBean.setConfigLocation(new ClassPathResource("config/mybatis/mybatis-config.xml"));
		
		return factoryBean.getObject();
***REMOVED***

***REMOVED***
