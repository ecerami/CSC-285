package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Hello World Servlet with HTML.
 */
public class HelloServlet extends HttpServlet {

    /**
     * Process HTTP GET Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();

        //  Here we embed HTML within the servlet.
        //  This is not recommended, but enough to get us started.
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Hello, World!</h1>");
        writer.println("<h3>The time is now:  " + new Date() + "</h3>");
        writer.println("</body>");
        writer.println("</html>");
    }
}