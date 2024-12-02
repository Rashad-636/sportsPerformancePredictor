package com.radams.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/signout")
public class SignOut extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties;
    private String CLIENT_ID;
    private String COGNITO_DOMAIN;
    private String LOGOUT_URL;

    public void init() {
        properties = (Properties)getServletContext().getAttribute("myProperties");
        CLIENT_ID = properties.getProperty("client.id");
        COGNITO_DOMAIN = properties.getProperty("cognitoDomain");
        LOGOUT_URL = properties.getProperty("logoutURL");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Invalidate session
        HttpSession session = request.getSession();
        session.invalidate();

        // Redirect to Cognito logout
        String logoutUrl = COGNITO_DOMAIN +
                "/logout?client_id=" + CLIENT_ID +
                "&logout_uri=" + LOGOUT_URL;

        logger.debug("Redirecting to logout URL: " + logoutUrl);
        response.sendRedirect(logoutUrl);
    }
}
