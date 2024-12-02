package com.radams.controller;

import com.radams.entity.FavoriteTeam;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/removeFavorite")
public class RemoveFavoriteTeam extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {

            int teamId = Integer.parseInt(req.getParameter("teamId")); // Integer gets our teamID object

            GenericDao<FavoriteTeam> favoriteDao = new GenericDao<>(FavoriteTeam.class);

            // Get all favorite teams for this user
            List<FavoriteTeam> allFavorites = favoriteDao.getAll();

            // Find and remove the specific favorite
            for (FavoriteTeam favorite : allFavorites) {
                if (favorite.getTeam().getId() == teamId &&
                        favorite.getUser().getId() == userId) { // match both teamID and userID
                    favoriteDao.delete(favorite);
                    break;
                }
            }
        }

        resp.sendRedirect("dashboard");
    }
}
