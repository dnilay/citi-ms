package com.city;

import java.sql.Connection;
import java.sql.SQLException;

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
    }
}
