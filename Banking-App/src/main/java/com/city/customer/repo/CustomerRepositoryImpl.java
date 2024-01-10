package com.city.customer.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.city.customer.model.Customer;
import com.city.facory.MariadbConnectionFactory;

public class CustomerRepositoryImpl implements CustomerRepository {

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
	public List<Customer> getAllCustomers()throws SQLException{
		// TODO Auto-generated method stub
		List<Customer> list=null;
		statement=connection.createStatement();
		resultSet=statement.executeQuery("select * from customer");
		list=new ArrayList<Customer>();
		while(resultSet.next())
		{
			list.add(new Customer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
		}
		return list;
	}

}
