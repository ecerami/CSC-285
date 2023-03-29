package edu.bhcc;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Movie List Servlet.
 */
public class MovieListServlet extends HttpServlet {

    /**
     * Process an HTTP Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // Create the Model
        Map<String, Object> root = new HashMap<String, Object>();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("John Wick: Chapter 4",
                "John Wick uncovers a path to defeating The High Table. "
                + "But before he can earn his freedom, Wick must face off against a new enemy "
                + "with powerful alliances across the globe and forces that turn old friends into foes.",
                "https://m.media-amazon.com/images/M/MV5BMDExZGMyOTMtMDgyYi00NGIwLWJhMTEtOTdkZGFjNmZiMTEw"
                + "XkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_FMjpg_UX1000_.jpg");
        Movie movie2 = new Movie("Avatar: The Way of Water",
                "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. "
                + "Once a familiar threat returns to finish what was previously started, Jake must work "
                + "with Neytiri and the army of the Na'vi race to protect their home.",
                "https://m.media-amazon.com/images/M/MV5BYjhiNjBlODctY2ZiOC00YjVlLWFlNzAtNTVhNzM1YjI1NzMx"
                + "XkEyXkFqcGdeQXVyMjQxNTE1MDA@._V1_QL75_UY281_CR3,0,190,281_.jpg");
        movieList.add(movie1);
        movieList.add(movie2);
        root.put("movie_list", movieList);

        // Get the FreeMarker Template Engine
        FreeMarkerUtil setup = FreeMarkerUtil.getInstance();
        Configuration cfg = setup.getFreeMarkerConfiguration();
        Template template = cfg.getTemplate("movie_list.html");

        //  Merge the Model with the Template
        PrintWriter writer = response.getWriter();
        try {
            template.process(root, writer);
        } catch (TemplateException e) {
            writer.println("Could not process template:  " + e.getMessage());
        }
    }
}
