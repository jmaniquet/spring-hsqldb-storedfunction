package fr.jmaniquet.poc.storedcall.countusers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersStoredProcedure;
import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersWithInStoredProcedure;

@Service(BeanConstants.STORED_PROCEDURE_SERVICE)
public class CountUsersServiceStoredProcedureImpl implements CountUsersService {

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
