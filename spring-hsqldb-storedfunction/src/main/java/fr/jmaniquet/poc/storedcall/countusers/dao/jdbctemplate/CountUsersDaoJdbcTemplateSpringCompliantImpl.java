package fr.jmaniquet.poc.storedcall.countusers.dao.jdbctemplate;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.jmaniquet.poc.storedcall.countusers.BeanConstants;
import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersDao;

@Repository(BeanConstants.JDBC_TEMPLATE_SPRING_COMPLIANT_DAO)
public class CountUsersDaoJdbcTemplateSpringCompliantImpl implements CountUsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer countUsers() {
		return jdbcTemplate.execute("{? = call countUsers()}", new CountUsersCallableStatementCallback());
	}

	@Override
	public Integer countUsersWithIn(int paramIn) {
		return jdbcTemplate.execute("{? = call countUsersWithIn(?)}", new CountUsersWithInCallableStatementCallback(paramIn));
	}
	
	private static class CountUsersCallableStatementCallback implements CallableStatementCallback<Integer> {

		@Override
		public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			
			int extracted = cs.getInt(1);
			Integer result = (cs.wasNull() ? null : extracted);
			
			return result;
		}
	}
	
	private static class CountUsersWithInCallableStatementCallback implements CallableStatementCallback<Integer> {

		private int paramIn;
		
		public CountUsersWithInCallableStatementCallback(int paramIn) {
			super();
			this.paramIn = paramIn;
		}

		@Override
		public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, paramIn);
			cs.execute();
			
			int extracted = cs.getInt(1);
			Integer result = (cs.wasNull() ? null : extracted);
			
			return result;
		}
		
	}
}
