package com.radams.controller;

import com.radams.persistence.RapidapiDao;
import com.rapidapi.Tank01Team.Teams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/schedule"}
)
public class Schedule extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the user ID from the session
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        // get team_abv from database
        String teamAbv = req.getParameter("team_abv"); // jsp link passes team_abv from previous page as param
        logger.info("Received parameter for team abbreviation: {}", teamAbv);

        // get rapidapi connection and all teams
        RapidapiDao dao = new RapidapiDao();
        List<Teams> apiTeams = dao.getTeams().getBody();

        boolean found = false;

        // match database and apiTeams team_abv and set into the team attribute
        for (Teams team : apiTeams) {
            if (team.getTeamAbv().equals(teamAbv)) {
                req.setAttribute("team", team);
                found = true;
                break;
            }
        }

        if (found) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("schedule.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp"); // Redirect to the index page if team not found
        }
    }
}
