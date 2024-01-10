package com.city;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.city.account.Account;
import com.city.account.repo.AccountRepository;
import com.city.account.repo.AccountRepositoryImpl;
import com.city.customer.model.Customer;
import com.city.customer.repo.CustomerRepository;
import com.city.customer.repo.CustomerRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CustomerRepository customerRepository=new CustomerRepositoryImpl();
	private static AccountRepository accountRepository=new AccountRepositoryImpl();
	private static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args ) throws SQLException
    {
      int choice=0;
     
      do {
    	  System.out.println("1. Display All Customers: ");
          System.out.println("2. Display All Accounts: ");
          System.out.print("enter your choice: ");
          choice=scanner.nextInt();
          switch (choice) {
		case 1:
			List<Customer> list=customerRepository.getAllCustomers();
			for(Customer c:list)
			{
				System.out.println(c);
			}
			break;
		case 2:
			List<Account> list1=accountRepository.getAccounts();
			
			for(Account a:list1)
			{
				System.out.println(a);
			}
			break;
		case 0:
			System.exit(0);

		default:
			System.out.println("invalid choice");
			break;
		}
		
	} while (choice!=0);
      
    }
}
