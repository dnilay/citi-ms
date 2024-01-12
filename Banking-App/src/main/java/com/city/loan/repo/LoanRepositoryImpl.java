package com.city.loan.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.city.facory.MariadbConnectionFactory;
import com.city.loan.model.Loan;
import com.city.loan.model.LoanType;

public class LoanRepositoryImpl implements LoanRepository {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
    private static Scanner scanner=new Scanner(System.in);
	private ResultSet resultSet;
	{
		try {
			connection = MariadbConnectionFactory.mariaDBConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createLoan(Loan loan) throws SQLException {
		preparedStatement = connection.prepareStatement("insert into loans(loan_type,customer_id) values(?,?)");
		preparedStatement.setString(1, loan.getLoanType().toString());
		preparedStatement.setString(2, loan.getCustomerId());
		preparedStatement.executeUpdate();
		System.out.println("loan created");

	}

	@Override
	public List<Loan> displayAllLoans() throws SQLException {

		List<Loan> list = new ArrayList<Loan>();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from loans");

		while (resultSet.next()) {
			list.add(new Loan(resultSet.getInt(1), LoanType.valueOf(resultSet.getString(2)), resultSet.getString(3)));
		}
		return list;
	}

	@Override
	public void updateLoanByLoanId(int loanId) throws SQLException {
		// TODO Auto-generated method stub
		
		//find loan by loan id
		//if its present then update
		
		preparedStatement=connection.prepareStatement("select * from loans where loan_id=?");
		preparedStatement.setInt(1, loanId);
		resultSet=preparedStatement.executeQuery();
		List<Loan> list=new ArrayList<Loan>();
		
		while(resultSet.next())
		{
			list.add(new Loan(resultSet.getInt(1),LoanType.valueOf( resultSet.getString(2)),resultSet.getString(3)));
		}
		if(list.isEmpty())
		{
			System.out.println("no loan account found");
		}
		else
		{
			Loan loan=list.get(0);
			System.out.println("Enter new Loan Type: ");
			String lType=scanner.next();
			preparedStatement=connection.prepareStatement("update  loans set loan_type=? where loan_id=?");
			preparedStatement.setString(1, lType);
			preparedStatement.setInt(2, loan.getLoanId());
			preparedStatement.executeUpdate();
			System.out.println("Loan Account Updated..");
			
		}
		
	}

	@Override
	public void deleteLoanAccountById(int loanId) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement=connection.prepareStatement("select * from loans where loan_id=?");
		preparedStatement.setInt(1, loanId);
		resultSet=preparedStatement.executeQuery();
		List<Loan> list=new ArrayList<Loan>();
		
		while(resultSet.next())
		{
			list.add(new Loan(resultSet.getInt(1),LoanType.valueOf( resultSet.getString(2)),resultSet.getString(3)));
		}
		if(list.isEmpty())
		{
			System.out.println("no loan account found");
		}
		else
		{
			Loan loan=list.get(0);
			preparedStatement=connection.prepareStatement("delete from loans where loan_id=?");
			preparedStatement.setInt(1, loan.getLoanId());
			preparedStatement.executeUpdate();
		}
		
	}

}
