package fr.jmaniquet.poc.storedcall.countusers.dao;

public interface CountUsersDao {
	
	Integer countUsers();
	
	Integer countUsersWithIn(int paramIn);
}
