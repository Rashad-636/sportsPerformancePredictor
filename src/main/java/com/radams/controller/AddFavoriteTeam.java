package com.radams.controller;

import com.radams.entity.FavoriteTeam;
import com.radams.entity.Team;
import com.radams.entity.User;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/addFavorite")
public class AddFavoriteTeam extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // get session
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        // check for userID and insert new favorite team
        if (userId != null) {
            int teamId = Integer.parseInt(req.getParameter("teamId"));

            GenericDao<User> userDao = new GenericDao<>(User.class);
            GenericDao<Team> teamDao = new GenericDao<>(Team.class);
            GenericDao<FavoriteTeam> favoriteDao = new GenericDao<>(FavoriteTeam.class);

            User user = userDao.getById(userId);
            Team team = teamDao.getById(teamId);

            FavoriteTeam favorite = new FavoriteTeam();
            favorite.setUser(user);
            favorite.setTeam(team);

            favoriteDao.insert(favorite);
        }

        resp.sendRedirect("dashboard");
    }
}
