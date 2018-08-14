package com.frontEnd.dao;

import org.springframework.data.repository.CrudRepository;

import com.frontEnd.domain.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
	
	PrimaryAccount findByAccountNumber(int accountNumber);

}
