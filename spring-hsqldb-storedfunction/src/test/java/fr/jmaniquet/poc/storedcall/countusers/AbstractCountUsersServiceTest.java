package fr.jmaniquet.poc.storedcall.countusers;

import static fr.jmaniquet.poc.storedcall.constants.TestDataConstants.NB_USERS;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import fr.jmaniquet.poc.storedcall.StoredCallTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StoredCallTestConfig.class)
@TestExecutionListeners(listeners = DbUnitTestExecutionListener.class)
@DbUnitConfiguration(databaseConnection = "dataSource")
@DatabaseSetup("classpath:/selectuser-dataset.xml")
public abstract class AbstractCountUsersServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private CountUsersService underTest;
	
	public void init(CountUsersService countUserService) {
		this.underTest = countUserService;
	}
	
	@Test
	public void testCountUsers() {
		Integer nbUsers = underTest.countUsers();
		Assert.assertNotNull(nbUsers);
		Assert.assertEquals(NB_USERS, nbUsers.intValue());
	}
	
	@Test
	public void testCountUsersWithIn() {
		int paramIn = 17;
		int expectedResult = NB_USERS + paramIn;
		
		Integer result = underTest.countUsersWithIn(paramIn);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(expectedResult, result.intValue());
	}
}
