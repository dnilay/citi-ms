package com.city.facory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariadbConnectionFactory {
	
	private static Connection connection=null;
	
	public static Connection mariaDBConnection()throws SQLException
	{
		//step-1 registering mariadb driver
		DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
		//step-2 create connection
		connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/asiahumanresource","root","root");
		return connection;
		
	}

}
