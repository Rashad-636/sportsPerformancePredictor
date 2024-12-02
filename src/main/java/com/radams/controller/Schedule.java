package com.radams.controller;

import com.radams.entity.Team;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/schedule")
public class Schedule extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        int teamId = Integer.parseInt(req.getParameter("teamId")); // Parsing Integer object

        // Get team ID
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        Team team = teamDao.getById(teamId);

        // TODO: Add API call to get schedule

        req.setAttribute("team", team);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/schedule.jsp");
        dispatcher.forward(req, resp);
    }
}
