package fr.jmaniquet.poc.storedcall.context;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.ResourceTransactionManager;

@Configuration
@ComponentScan("fr.jmaniquet.poc.storedcall")
public class StoredCallContext {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public ResourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}