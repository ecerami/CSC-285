package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * User Servlet with HTML.
 */
public class UserServlet extends HttpServlet {

    /**
     * Process HTTP GET Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();

        //  Get the User Parameter.
        String userId = request.getParameter("user_id");

        //  Check for Null of Empty Value
        if (userId == null || userId.length() == 0) {
            userId = "[No user info provided]";
        }

        //  Here we embed HTML within the servlet.
        //  This is not recommended, but enough to get us started.
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>User Status</h1>");
        writer.println("<h3>User:  " + userId + "</h3>");
        writer.println("</body>");
        writer.println("</html>");
    }
}