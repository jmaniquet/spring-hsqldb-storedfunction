package fr.jmaniquet.poc.storedcall.countusers.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.jmaniquet.poc.storedcall.countusers.BeanConstants;
import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersDao;

@Repository(BeanConstants.JDBC_DAO)
public class CountUsersDaoJdbcImpl implements CountUsersDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public Integer countUsers() {
		Integer result = null;
		
		try (	Connection con = dataSource.getConnection();
				CallableStatement cs = con.prepareCall("{? = call countUsers()}")) {
			
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			
			int extracted = cs.getInt(1);
			result = (cs.wasNull() ? null : extracted);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	@Override
	public Integer countUsersWithIn(int paramIn) {
		Integer result = null;
		
		try (	Connection con = dataSource.getConnection();
				CallableStatement cs = con.prepareCall("{? = call countUsersWithIn(?)}")) {
			
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, paramIn);
			cs.execute();
			
			int extracted = cs.getInt(1);
			result = (cs.wasNull() ? null : extracted);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

}
