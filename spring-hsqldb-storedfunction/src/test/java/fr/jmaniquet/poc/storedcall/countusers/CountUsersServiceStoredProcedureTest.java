package fr.jmaniquet.poc.storedcall.countusers;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CountUsersServiceStoredProcedureTest extends AbstractCountUsersServiceTest/*AbstractTransactionalJUnit4SpringContextTests*/ {
	
	@Autowired
	@Qualifier(BeanConstants.STORED_PROCEDURE_SERVICE)
	private CountUsersService countUsersService;
	
	@Before
	public void before() {
		super.init(countUsersService);
	}
}