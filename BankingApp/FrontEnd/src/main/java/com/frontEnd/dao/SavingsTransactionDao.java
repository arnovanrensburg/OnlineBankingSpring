package com.frontEnd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.frontEnd.domain.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {
	
	List<SavingsTransaction> findAll();

}

