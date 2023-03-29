package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Movie Servlet.
 */
public class MovieServlet extends HttpServlet {

    /**
     * Process an HTTP Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // Create the Model
        Map<String, Object> root = new HashMap<String, Object>();
        Movie movie = new Movie("John Wick: Chapter 4",
                "John Wick uncovers a path to defeating The High Table. "
                + "But before he can earn his freedom, Wick must face off against a new enemy "
                + "with powerful alliances across the globe and forces that turn old friends into foes.",
                "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEw"
                + "XkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_FMjpg_UX1000_.jpg");
        root.put("movie", movie);

        // Get the FreeMarker Template Engine
        FreeMarkerUtil setup = FreeMarkerUtil.getInstance();
        Configuration cfg = setup.getFreeMarkerConfiguration();
        Template template = cfg.getTemplate("movie.html");

        //  Merge the Model with the Template
        PrintWriter writer = response.getWriter();
        try {
            template.process(root, writer);
        } catch (TemplateException e) {
            writer.println("Could not process template:  " + e.getMessage());
        }
    }
}
