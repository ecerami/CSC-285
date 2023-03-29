package edu.bhcc;


import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.TimeZone;

/**
 * FreeMarker Utility Class.
 */
public class FreeMarkerUtil {
    private static FreeMarkerUtil freeMarkerUtil;
    private Configuration freeMarkerConfig;

    /**
     * Get the FreeMarker Singleton Object.
     */
    public static FreeMarkerUtil getInstance() throws IOException {
        if (freeMarkerUtil == null) {
            freeMarkerUtil = new FreeMarkerUtil();
        }
        return freeMarkerUtil;
    }

    /**
     * Private Constructor to Enforce Singleton Pattern.
     */
    private FreeMarkerUtil() throws IOException {
        this.freeMarkerConfig = new Configuration(Configuration.VERSION_2_3_32);
        freeMarkerConfig.setDirectoryForTemplateLoading(new File("src/main/templates"));

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        freeMarkerConfig.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        freeMarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will throw at you anyway:
        freeMarkerConfig.setLogTemplateExceptions(false);

        // Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        freeMarkerConfig.setWrapUncheckedExceptions(true);

        // Do not fall back to higher scopes when reading a null loop variable:
        freeMarkerConfig.setFallbackOnNullLoopVariable(false);

        // To accommodate to how JDBC returns values; see Javadoc!
        freeMarkerConfig.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
    }

    /**
     * Get the FreeMarker Configuration.
     */
    public Configuration getFreeMarkerConfiguration() {
        return freeMarkerConfig;
    }
}
