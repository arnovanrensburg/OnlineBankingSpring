package com.frontEnd.service;

import java.util.Set;

import com.frontEnd.dao.UserDao;
import com.frontEnd.domain.User;
import com.frontEnd.domain.security.UserRole;

public interface UserService {
	
	public void save(User user);
	
	//public User findByUsername(String username);
	public User findByUsername(UserDao userDao, String username);
	
	//public User findByEmail(String email);
	public User findByEmail(UserDao userDao, String email);
	
	//public boolean checkUserExists(String username, String email);
	public boolean checkUserExists(UserDao userDao, String username, String email);
	
	//public boolean checkUsernameExists(String username);
	public boolean checkUsernameExists(UserDao userDao, String username);
	
	//public boolean checkEmailExists(String email);
	public boolean checkEmailExists(UserDao userDao, String email);

	public User create(User user, Set<UserRole> userRoles);

	

	


	
	
}
