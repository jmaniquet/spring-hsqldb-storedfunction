package fr.jmaniquet.poc.storedcall.countusers.service;

public interface CountUsersService {

	Integer countUsers();
	
	Integer countUsersWithIn(int paramIn);
}
