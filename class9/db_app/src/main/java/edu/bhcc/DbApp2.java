package edu.bhcc;

import java.sql.*;

/**
 * Database Application 2.
 * Illustrates PreparedStatements.
 * Note:  We assume that the WEB_USER table already exists in the sample database.
 */
public class DbApp2 {

    /**
     * Execute Database Query.
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  Create JDBC Connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

        System.out.println("Adding one new record.");

        //  Create a Prepared Statement
        PreparedStatement preparedStatement = connection.prepareStatement("insert into WEB_USER " +
                "(FIRST_NAME, LAST_NAME, EMAIL) values (?, ?, ?);");
        preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Doe");
        preparedStatement.setString(3, "johndoe@email.com");

        int recordsAdded = preparedStatement.executeUpdate();
        System.out.println("Total number of records added:  " + recordsAdded);

        //  Clean up
        connection.close();
    }
}
