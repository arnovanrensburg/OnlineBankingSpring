package com.frontEnd.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontEnd.dao.UserDao;
import com.frontEnd.domain.User;
import com.frontEnd.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public final void save(User user) {
		userDao.save(user);
	}
	
	@Override
	public final User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public final User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	@Override
	public final boolean checkUserExists(String username, String email) {
		return checkUsernameExists(username) || checkEmailExists(email);
	}
	
	@Override
	public final boolean checkUsernameExists(String username) {
		return (null != findByUsername(username));
	}
	
	@Override
	public final boolean checkEmailExists(String email) {
		return (null != findByEmail(email));
	}
	
	
	
}
