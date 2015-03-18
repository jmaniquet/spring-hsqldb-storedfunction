package fr.jmaniquet.poc.storedcall.countusers.dao;

import java.sql.Types;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class CountUsersWithInStoredProcedure extends AbsractCountUsersFunction {

	@Autowired 
	public CountUsersWithInStoredProcedure(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "countUsersWithIn");		
	}
	
	@PostConstruct
	public void postConstruct() {
		super.postConstruct(
					new SqlOutParameter("FUNCTION_RESULT", Types.INTEGER),
					new SqlParameter("PARAM_IN", Types.INTEGER));
	}
}
