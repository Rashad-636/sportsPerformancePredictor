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
import java.util.List;

@WebServlet("/allTeams")
public class DisplayAllTeams extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        List<Team> allTeams = teamDao.getAll();
        logger.debug(allTeams);

        req.setAttribute("allTeams", allTeams);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allTeams.jsp");
        dispatcher.forward(req, resp);
    }
}
