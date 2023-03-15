package edu.bhcc;

import java.sql.*;

/**
 * Database Application 1.
 * Illustrates SQL Queries.
 * Note:  We assume that the WEB_USER table already exists in the sample database.
 */
public class DbApp1 {

    /**
     * Execute Database Query.
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //  Create connect string
        String connectUrl = "jdbc:mysql://localhost/sample";

        //  Create JDBC Connection
        Connection connection = DriverManager.getConnection(connectUrl, "user", "password");

        //  Create the SQL Statement
        Statement statement = connection.createStatement();

        //  To query for data, use executeQuery()
        ResultSet resultSet = statement.executeQuery("select * from WEB_USER");

        //  Iterate through all records in result set
        while (resultSet.next()) {
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            String email = resultSet.getString("EMAIL");
            System.out.println(String.format("%s %s --> %s", firstName, lastName, email));
        }

        //  Clean up
        connection.close();
    }
}
