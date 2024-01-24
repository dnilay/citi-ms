package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountApi {

	private AccountService accountService;

	public AccountApi(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account)
	{
		return accountService.createAccount(account);
	}
	@GetMapping("/accounts")
	public List<Account> listAccounts()
	{
		return accountService.getAllAccounts();
	}
	
}
