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
 * Hello, World Servlet.
 */
public class HelloServlet extends HttpServlet {

    /**
     * Process an HTTP Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        // Create the Model
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("user", "Ethan");

        // Get the FreeMarker Template Engine
        FreeMarkerUtil setup = FreeMarkerUtil.getInstance();
        Configuration cfg = setup.getFreeMarkerConfiguration();
        Template template = cfg.getTemplate("hello.html");

        //  Merge the Model with the Template
        PrintWriter writer = response.getWriter();
        try {
            template.process(root, writer);
        } catch (TemplateException e) {
            writer.println("Could not process template:  " + e.getMessage());
        }
    }
}
