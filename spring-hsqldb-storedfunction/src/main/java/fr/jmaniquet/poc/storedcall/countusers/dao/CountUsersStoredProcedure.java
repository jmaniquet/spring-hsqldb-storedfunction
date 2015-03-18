package fr.jmaniquet.poc.storedcall.countusers.dao;

import java.sql.Types;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

@Repository
public class CountUsersStoredProcedure extends AbsractCountUsersFunction {

	@Autowired 
	public CountUsersStoredProcedure(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "countUsers");
	}
	
	@PostConstruct
	public void postConstruct() {
		super.postConstruct(new SqlOutParameter("FUNCTION_RESULT", Types.INTEGER));
	}
}
