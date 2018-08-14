package com.frontEnd.service;

import com.frontEnd.domain.User;

public interface UserService {
	
	public void save(User user);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public boolean checkUserExists(String username, String email);
	
	public boolean checkUsernameExists(String username);
	
	public boolean checkEmailExists(String email);
	
}
