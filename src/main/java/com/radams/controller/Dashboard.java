package com.radams.controller;

import com.radams.entity.FavoriteTeam;
import com.radams.entity.Team;
import com.radams.entity.User;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

// When user is logged in, show their favorite teams dashboard
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            // get user object
            // First get the User object
            GenericDao<User> userDao = new GenericDao<>(User.class);
            User user = userDao.getById(userId);

            // Get user's favorite teams
            GenericDao<FavoriteTeam> favoriteDao = new GenericDao<>(FavoriteTeam.class);
            List<FavoriteTeam> favoriteTeams = favoriteDao.getByPropertyEqual("user", user);

            req.setAttribute("favoriteTeams", favoriteTeams);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp"); // Redirect to the index page
        }
    }
}
