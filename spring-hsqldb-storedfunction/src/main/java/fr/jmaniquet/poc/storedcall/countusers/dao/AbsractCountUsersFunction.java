package fr.jmaniquet.poc.storedcall.countusers.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class AbsractCountUsersFunction extends StoredProcedure {

	protected AbsractCountUsersFunction(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
	}
	
	public void postConstruct(SqlParameter ... parameters) {
		for (SqlParameter sqlParameter : parameters) {
			declareParameter(sqlParameter);
		}
		this.setFunction(true);
		super.compile();
	}
}
