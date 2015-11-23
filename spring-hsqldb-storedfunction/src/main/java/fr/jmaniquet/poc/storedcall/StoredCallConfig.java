package fr.jmaniquet.poc.storedcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.jmaniquet.poc.storedcall.countusers.BeanConstants;
import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersDao;
import fr.jmaniquet.poc.storedcall.countusers.service.CountUsersService;
import fr.jmaniquet.poc.storedcall.countusers.service.CountUsersServiceImpl;

@Configuration
@Import(StoredCallBaseConfig.class)
@ComponentScan
public class StoredCallConfig {

	@Autowired
	@Qualifier(BeanConstants.SIMPLE_JDBC_CALL_DAO)
	private CountUsersDao countUsersDaoSimpleJdbcCall;
	
	@Autowired
	@Qualifier(BeanConstants.STORED_PROCEDURE_DAO)
	private CountUsersDao countUsersDaoStoredProcedure;

	@Bean(name = BeanConstants.SIMPLE_JDBC_CALL_SERVICE)
	public CountUsersService CountUsersServiceWithSimpleJdbcCall() {
		return new CountUsersServiceImpl(countUsersDaoSimpleJdbcCall);
	}

	@Bean(name = BeanConstants.STORED_PROCEDURE_SERVICE)
	public CountUsersService CountUsersServiceWithStoredProcedure() {
		return new CountUsersServiceImpl(countUsersDaoStoredProcedure);
	}
}
