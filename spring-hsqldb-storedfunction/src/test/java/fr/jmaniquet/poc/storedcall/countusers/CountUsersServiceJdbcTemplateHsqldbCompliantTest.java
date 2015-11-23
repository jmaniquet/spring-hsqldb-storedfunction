package fr.jmaniquet.poc.storedcall.countusers;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.jmaniquet.poc.storedcall.countusers.service.CountUsersService;

public class CountUsersServiceJdbcTemplateHsqldbCompliantTest extends AbstractCountUsersServiceTest {
	
	@Autowired
	@Qualifier(BeanConstants.JDBC_TEMPLATE_HSQLDB_COMPLIANT_SERVICE)
	private CountUsersService countUsersService;
	
	@Before
	public void before() {
		super.init(countUsersService);
	}
}
