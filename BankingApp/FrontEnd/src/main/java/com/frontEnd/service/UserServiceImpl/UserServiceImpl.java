package com.frontEnd.service.UserServiceImpl;

import java.util.Set;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frontEnd.dao.RoleDao;
import com.frontEnd.dao.UserDao;
import com.frontEnd.domain.User;
import com.frontEnd.domain.security.UserRole;
import com.frontEnd.service.AccountService;
import com.frontEnd.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private RoleDao roleDao;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private AccountService accountService;
	
	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userDao.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);

			for (UserRole ur : userRoles) {
				roleDao.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);

			user.setPrimaryAccount(accountService.createPrimaryAccount());
			user.setSavingsAccount(accountService.createSavingsAccount());

			localUser = userDao.save(user);
		}

		return localUser;
	}

	@Override
	public boolean checkUserExists(String username, String email) {
		return checkUsernameExists(username) || checkEmailExists(email);
	}
	
	@Override
	public boolean checkUsernameExists(String username) {
		return (null != findByUsername(username));
	}
	
	@Override
	public boolean checkEmailExists(String email) {
		return (null != findByEmail( email));
	}

	

	
	
	
	
}
