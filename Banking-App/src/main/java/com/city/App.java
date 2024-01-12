package com.city;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.city.account.Account;
import com.city.account.repo.AccountRepository;
import com.city.account.repo.AccountRepositoryImpl;
import com.city.customer.model.Customer;
import com.city.customer.repo.CustomerRepository;
import com.city.customer.repo.CustomerRepositoryImpl;
import com.city.loan.model.Loan;
import com.city.loan.model.LoanType;
import com.city.loan.model.ResponseLoan;
import com.city.loan.repo.LoanRepository;
import com.city.loan.repo.LoanRepositoryImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CustomerRepository customerRepository=new CustomerRepositoryImpl();
	private static AccountRepository accountRepository=new AccountRepositoryImpl();
	private static LoanRepository loanRepository=new LoanRepositoryImpl();
	private static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args ) throws SQLException
    {
      int choice=0;
     
      do {
    	  System.out.println("1. Display All Customers: ");
          System.out.println("2. Display All Accounts: ");
          System.out.println("3. Create An Account: ");
          System.out.println("4. find by account number: ");
          System.out.println("5. Create Loan: ");
          System.out.println("6. Display All Available Loans: ");
          System.out.println("0. Exit.");
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
		case 3:
			System.out.println("Enter Account Holder Name: ");
			String name=scanner.next();
			System.out.println("Enter Amount: ");
			int amount=scanner.nextInt();
			accountRepository.createAccount(new Account(new Random().nextInt(10000), name, amount));
			break;
		case 4:
			System.out.println("Enter Account Number: ");
			int n=scanner.nextInt();
			Account account=accountRepository.findByAccountNumber(n);
			if(account==null)
			{
				System.out.println("no such account...");
			}
			else
			{
				System.out.println(account);
			}
			
			break;
		case 5:
			System.out.print("Enter Loan Type: ");
			String loanString=scanner.next();
			System.out.println("enter customer id: ");
			String customerid=scanner.next();
			loanRepository.createLoan(new Loan(LoanType.valueOf(loanString), customerid));
			break;
		case 6:
			List<ResponseLoan> list2=loanRepository.displayAllLoans();
			for(ResponseLoan r:list2)
			{
				System.out.println(r);
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
