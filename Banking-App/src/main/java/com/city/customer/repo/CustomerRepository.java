package com.city.customer.repo;

import java.sql.SQLException;
import java.util.List;

import com.city.customer.model.Customer;

public interface CustomerRepository {
	
	List<Customer> getAllCustomers() throws SQLException;

}
