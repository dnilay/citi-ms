package com.city;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.city.facory.MariadbConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
       Connection connection= MariadbConnectionFactory.mariaDBConnection();
       System.out.println(connection);
       System.out.println("connection is succeed");
       
       Statement statement=connection.createStatement();
       ResultSet resultSet= statement.executeQuery("select * from customer");
       System.out.println("CUSTOMER_ID  FIRST_NAME  LAST_NAME  EMAIL");
       while(resultSet.next())
       {
    	   System.out.println(resultSet.getString("customer_id")+"  "+resultSet.getString("first_name")+" "+resultSet.getString("last_name")+" "+resultSet.getString("email"));
       }
    }
}
