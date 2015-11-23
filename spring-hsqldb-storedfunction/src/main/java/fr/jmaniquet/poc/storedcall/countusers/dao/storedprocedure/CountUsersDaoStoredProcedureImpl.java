package fr.jmaniquet.poc.storedcall.countusers.dao.storedprocedure;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.jmaniquet.poc.storedcall.countusers.BeanConstants;
import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersDao;

@Repository(BeanConstants.STORED_PROCEDURE_DAO)
public class CountUsersDaoStoredProcedureImpl implements CountUsersDao {

	@Autowired
	private CountUsersStoredProcedure countUsersStoredProcedure;
	
	@Autowired
	private CountUsersWithInStoredProcedure countUsersWithInStoredProcedure;
	
	@Override
	public Integer countUsers() {
		Map<String, Object> resultMap = countUsersStoredProcedure.execute();
		return (Integer) resultMap.get("FUNCTION_RESULT");
	}

	@Override
	public Integer countUsersWithIn(int paramIn) {
		Map<String, Object> resultMap = countUsersWithInStoredProcedure.execute(paramIn);
		return (Integer) resultMap.get("FUNCTION_RESULT");
	}
}
