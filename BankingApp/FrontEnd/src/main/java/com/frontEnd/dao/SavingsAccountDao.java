package com.frontEnd.dao;

import org.springframework.data.repository.CrudRepository;

import com.frontEnd.domain.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

	SavingsAccount findByAccountNumber(int accountNumber); 

}
