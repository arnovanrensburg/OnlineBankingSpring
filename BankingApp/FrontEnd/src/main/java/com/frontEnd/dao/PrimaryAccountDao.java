package com.frontEnd.dao;

import com.frontEnd.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;


public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
	
	PrimaryAccount findByAccountNumber(int accountNumber);

}
