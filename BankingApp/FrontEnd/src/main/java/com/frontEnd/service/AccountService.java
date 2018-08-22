package com.frontEnd.service;

import java.security.Principal;

import com.frontEnd.domain.PrimaryAccount;
import com.frontEnd.domain.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
	void deposit(String accountType, double parseDouble, Principal principal);
	void withdraw(String accountType, double amount, Principal principal);

}
