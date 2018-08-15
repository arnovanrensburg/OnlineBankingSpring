package com.frontEnd.service;

import java.util.Set;

import com.frontEnd.domain.User;
import com.frontEnd.domain.security.UserRole;

public interface UserService {
	
	User findByUsername(String username);

	User findByEmail(String email);

	boolean checkUserExists(String username, String email);
	
	boolean checkUsernameExists(String username);
	
	boolean checkEmailExists(String email);

    User createUser(User user, Set<UserRole> userRoles);
	
    User saveUser (User user); 
	
}
