package com.radams.controller;

import com.radams.persistence.RapidapiDao;
import com.rapidapi.Tank01Team.DailySchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/dailySchedule")
public class DailyScheduleServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RapidapiDao dao = new RapidapiDao();
        List<DailySchedule> games = dao.getDailySchedule().getBody();
        req.setAttribute("games", games);

//        logger.info("Daily Schedule Servlet {}", games);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/dailySchedule.jsp");
        dispatcher.forward(req, resp);
    }
}
