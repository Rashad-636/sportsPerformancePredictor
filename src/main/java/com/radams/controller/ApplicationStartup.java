package com.radams.controller;

import com.radams.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Properties;


@WebServlet(
        name = "appStartup",
        urlPatterns = {},
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void init() {
        Properties properties;
        try {
            properties = loadProperties("/cognito.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info("Properties loaded successfully");

        // servlet context object that gets the servlet context
        ServletContext context = getServletContext();
        logger.info("ServletContext obtained");

        // assign properties object to the servlet context to be accessed later
        context.setAttribute("myProperties", properties);
        logger.info("Properties set in ServletContext");

        logger.info("Servlet initialization completed successfully");
    }
}
