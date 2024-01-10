package com.city.account.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.city.account.Account;
import com.city.facory.MariadbConnectionFactory;

public class AccountRepositoryImpl implements AccountRepository {
	private Connection connection;
	private Statement statement;
	
	private ResultSet resultSet;
	{
		try {
			connection=MariadbConnectionFactory.mariaDBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Account> getAccounts() throws SQLException {
		// TODO Auto-generated method stub
		List<Account> list=new ArrayList<Account>();
		statement=connection.createStatement();
		resultSet=statement.executeQuery("select * from accounts");
		while(resultSet.next())
		{
			list.add(new Account(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
		}
		
		return list;
	}

}
