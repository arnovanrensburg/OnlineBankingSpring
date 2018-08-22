package com.frontEnd.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frontEnd.domain.PrimaryAccount;
import com.frontEnd.domain.PrimaryTransaction;
import com.frontEnd.domain.SavingsAccount;
import com.frontEnd.domain.SavingsTransaction;
import com.frontEnd.domain.User;
import com.frontEnd.service.AccountService;
import com.frontEnd.service.TransactionService;
import com.frontEnd.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model, Principal principal) {
		List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
		
		User user = userService.findByUsername(principal.getName()); 
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		model.addAttribute("primaryAccount",primaryAccount);
		model.addAttribute("primaryTransactionList",primaryTransactionList);
		return "primaryAccount";
	}
	
	@RequestMapping("/savingsAccount")
	public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
		
		
		User user = userService.findByUsername(principal.getName()); 
		SavingsAccount savingsAccount = user.getSavingsAccount();
		model.addAttribute("savingsAccount",savingsAccount);
		model.addAttribute("savingsTransactionList",savingsTransactionList);
		return "savingsAccount";
	}
	
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET) 
	public String deposit(Model model) {
		model.addAttribute("accountType","");
		model.addAttribute("amount","10.0");
		return "deposit";
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST) 
	public String depositPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
		accountService.deposit(accountType, Double.parseDouble(amount), principal);
		
		return "redirect:/frontEnd";
	}
	
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET) 
	public String withdraw(Model model) {
		model.addAttribute("accountType","");
		model.addAttribute("amount","10.0");
		return "withdraw";
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST) 
	public String withdrawPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
		accountService.withdraw(accountType, Double.parseDouble(amount), principal);
		
		return "redirect:/frontEnd";
	}

}
