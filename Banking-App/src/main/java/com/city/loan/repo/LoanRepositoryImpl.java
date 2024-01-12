package com.city.loan.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.city.facory.MariadbConnectionFactory;
import com.city.loan.model.Loan;
import com.city.loan.model.LoanType;

public class LoanRepositoryImpl implements LoanRepository {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;

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

}
