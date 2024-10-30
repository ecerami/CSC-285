package edu.bhcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database Application 0.
 * Illustrates Insert of New Records.
 * Note:  We assume that the WEB_USER table already exists in the sample database.
 */
public class DbApp0 {

    /**
     * Execute Database Insert.
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  Create JDBC Connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

        //  Create the SQL Statement
        Statement statement = connection.createStatement();

        System.out.println("Adding one new record.");

        //  To modify data, use executeUpdate()
        int recordsAdded = statement.executeUpdate("insert into WEB_USER" +
                " (FIRST_NAME, LAST_NAME, EMAIL) values " +
                "('Ethan', 'Cerami', 'cerami@email.com');");

        System.out.println("Total number of records added:  " + recordsAdded);

        //  Clean up
        connection.close();
    }
}
