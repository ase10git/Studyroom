package context;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context_1_dataSource {
	
	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@1.213.238.239:1521:xe");
		ds.setUsername("Studyroom");
		ds.setPassword("study1234");

		ds.addConnectionProperty("allowMultiQueries", "true");
		return ds;
	}

}
