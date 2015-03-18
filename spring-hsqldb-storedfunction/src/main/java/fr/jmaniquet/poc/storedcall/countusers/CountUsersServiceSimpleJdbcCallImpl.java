package fr.jmaniquet.poc.storedcall.countusers;

import java.sql.Types;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

@Service(BeanConstants.SIMPLE_JDBC_CALL_SERVICE)
public class CountUsersServiceSimpleJdbcCallImpl implements CountUsersService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall countUsers;
	
	private SimpleJdbcCall countUsersWithIn;
	
	@PostConstruct
	public void postConstruct() {
		this.countUsers = new SimpleJdbcCall(jdbcTemplate)
			.withFunctionName("countUsers")
			.declareParameters(new SqlOutParameter("FUNCTION_RESULT", Types.INTEGER));
		
		this.countUsersWithIn = new SimpleJdbcCall(jdbcTemplate)
			.withFunctionName("countUsersWithIn")
			.declareParameters(
								new SqlOutParameter("FUNCTION_RESULT", Types.INTEGER),
								new SqlParameter("PARAM_IN", Types.INTEGER));
	}
	
	@Override
	public Integer countUsers() {
		Integer nbUsers = this.countUsers.executeFunction(Integer.class);
		return nbUsers;
	}

	@Override
	public Integer countUsersWithIn(int paramIn) {
		Integer result = this.countUsersWithIn.executeFunction(Integer.class, paramIn);
		return result;
	}

}
