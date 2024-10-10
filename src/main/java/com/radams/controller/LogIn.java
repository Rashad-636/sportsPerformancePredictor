package com.radams.controller;

import com.radams.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/logIn"}
)

/** Begins the authentication process using AWS Cognito
 *
 */
public class LogIn extends HttpServlet implements PropertiesLoader {

    // Variable declarations
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // get properties for this servlet
        ServletContext context = getServletContext();
        Properties properties = (Properties) context.getAttribute("week7properties");

        // assign variable to property key
        String CLIENT_ID = properties.getProperty("client.id");
        String LOGIN_URL = properties.getProperty("loginURL");
        String REDIRECT_URL = properties.getProperty("redirectURL");
        logger.info("Client ID: " + CLIENT_ID);
        logger.info("Login URL: " + LOGIN_URL);
        logger.info("Redirect URL: " + REDIRECT_URL);

        // TODO if properties weren't loaded properly, route to an error page
        String url = LOGIN_URL + "?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL;
        resp.sendRedirect(url);
    }
}
