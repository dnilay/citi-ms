package com.city.account.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private PreparedStatement preparedStatement;
	
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
	@Override
	public void createAccount(Account account) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement=connection.prepareStatement("insert into accounts(acoount_no,account_holder_name,amount_available)values(?,?,?)");
		preparedStatement.setInt(1, account.getAccountNumber());
		preparedStatement.setString(2, account.getAccountHolderName());
		preparedStatement.setInt(3, account.getAmountAvailable());
		int result= preparedStatement.executeUpdate();
		System.out.println(result+" row(s) updated.");
	}
	@Override
	public Account findByAccountNumber(int accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		
		preparedStatement=connection.prepareStatement("select * from accounts where acoount_no=?");
		preparedStatement.setInt(1, accountNumber);
		resultSet=preparedStatement.executeQuery();
		List<Account> list=new ArrayList<Account>();
		while(resultSet.next())
		{
			list.add(new Account(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
		}
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
		
	}

}
