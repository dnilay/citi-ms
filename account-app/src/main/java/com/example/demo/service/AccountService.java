package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {
	Account createAccount(Account account);

	List<Account> getAllAccounts();
}
