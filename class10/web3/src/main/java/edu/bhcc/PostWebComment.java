package edu.bhcc;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Post/Process Web Comments.
 */
public class PostWebComment extends HttpServlet {

    /**
     * Process HTTP POST Request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();

        String userId = request.getParameter("user_id");
        String comment = request.getParameter("comment");

        if (userId == null || userId.length() == 0) {
            userId = "[Not specified]";
        }
        if (comment == null || comment.length() == 0) {
            comment = "[Not specified]";
        }

        //  Here we embed HTML Form within the servlet.
        //  This is not recommended, but enough to get us started.
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Thanks!  Web Comments Received.</h1>");
        writer.println("<h3>User ID:  " + userId + "</h3>");
        writer.println("<h3>Comment:  " + comment + "</h3>");
        writer.println("</body>");
        writer.println("</html>");
    }
}