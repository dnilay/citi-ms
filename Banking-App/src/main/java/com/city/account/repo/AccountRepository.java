package com.city.account.repo;

import java.sql.SQLException;
import java.util.List;

import com.city.account.Account;

public interface AccountRepository {
	
	List<Account> getAccounts() throws SQLException;

}
