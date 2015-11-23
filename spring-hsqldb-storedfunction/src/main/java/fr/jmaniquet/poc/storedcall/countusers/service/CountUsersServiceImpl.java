package fr.jmaniquet.poc.storedcall.countusers.service;

import fr.jmaniquet.poc.storedcall.countusers.dao.CountUsersDao;

public class CountUsersServiceImpl implements CountUsersService {

	private CountUsersDao countUsersDao;
	
	public CountUsersServiceImpl(CountUsersDao countUsersDao) {
		super();
		this.countUsersDao = countUsersDao;
	}
	
	@Override
	public Integer countUsers() {
		return countUsersDao.countUsers();
	}

	@Override
	public Integer countUsersWithIn(int paramIn) {
		return countUsersDao.countUsersWithIn(paramIn);
	}

}
