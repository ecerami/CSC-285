package edu.bhcc;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet that Connects to Database via JDBC.
 */
public class UserDb extends HttpServlet {

    /**
     * Process HTTP GET Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();

        try {
            //  Get the Database Connection
            Connection connection = this.getDbConnection();

            //  Query for all Users
            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM WEB_USER");
            ResultSet resultSet = pStatement.executeQuery();

            //  Here we embed HTML Results within the servlet.
            //  This is not recommended, but enough to get us started.
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>Users</h1>");

            //  Iterate through all results
            while (resultSet.next()) {
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String email = resultSet.getString("EMAIL");
                writer.println("<p>" + firstName + " " + lastName + ": " + email);
            }
            writer.println("</body>");
            writer.println("</html>");

        } catch (ClassNotFoundException e) {
            writer.println("Class not found:   " + e.getMessage());
        } catch (SQLException e) {
            writer.println("SQL Error:  " + e.getMessage());
        }
    }

    /**
     * Get Database Connection.
     * Here we create a new database connection for each request.
     * This is not recommended, but enough to get us started.
     */
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        //  Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //  Create connect string
        String connectUrl = "jdbc:mysql://localhost/sample";

        //  Create JDBC Connection
        return DriverManager.getConnection(connectUrl, "user", "password");
    }
}