package com.radams.controller;

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

@WebServlet("/allTeams")
public class DisplayAllTeams extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // get session and the user's ID
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        // if user is found, add their favorite teams to userFavorites attribute
        // to be accessed in jsp
        if (userId != null) {
            GenericDao<User> userDao = new GenericDao<>(User.class);
            User user = userDao.getById(userId);
            req.setAttribute("userFavorites", user.getFavoriteTeams());
        }

        // get all teams from the database
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        List<Team> allTeams = teamDao.getAll();
        logger.debug(allTeams);

        // set all teams into allTeams attribute to be accessed in jsp
        req.setAttribute("allTeams", allTeams);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allTeams.jsp");
        dispatcher.forward(req, resp);
    }
}
