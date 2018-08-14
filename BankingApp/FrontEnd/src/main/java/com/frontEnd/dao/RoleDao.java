package com.frontEnd.dao;

import org.springframework.data.repository.CrudRepository;

import com.frontEnd.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
	Role findByName(String name);
}
