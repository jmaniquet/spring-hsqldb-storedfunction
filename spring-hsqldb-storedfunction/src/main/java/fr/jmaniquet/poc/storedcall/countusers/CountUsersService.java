package fr.jmaniquet.poc.storedcall.countusers;

public interface CountUsersService {

	Integer countUsers();
	
	Integer countUsersWithIn(int paramIn);
}
