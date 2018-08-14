package com.frontEnd.dao;

import org.springframework.data.repository.CrudRepository;

import com.frontEnd.domain.User;

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);

}
