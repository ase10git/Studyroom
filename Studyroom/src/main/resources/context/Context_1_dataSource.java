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
		***REMOVED***
		***REMOVED***
		***REMOVED***

		ds.addConnectionProperty("allowMultiQueries", "true");
		return ds;
	}

}
