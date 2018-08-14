package com.frontEnd.service;

import com.frontEnd.domain.PrimaryAccount;
import com.frontEnd.domain.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();

}
