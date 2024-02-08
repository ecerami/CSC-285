package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("This is an info message");
        logger.warn("This is a warning");
        logger.error("This is an error");
        System.out.println( "Hello World!" );
    }
}
