package com.radams.controller;

import com.radams.entity.Sport;
import com.radams.entity.Team;
import com.radams.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@WebServlet(
        name = "appStartup",
        urlPatterns = {},
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void init() {

        Properties properties;

        try {
            properties = loadProperties("/cognito.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info("Properties loaded successfully");

        // servlet context object that gets the servlet context
        ServletContext context = getServletContext();
        logger.info("ServletContext obtained");

        // assign properties object to the servlet context to be accessed later
        context.setAttribute("myProperties", properties);
        logger.info("Properties set in ServletContext");

        logger.info("Servlet initialization completed successfully");
    }

//    private void loadNBATeams() {
//        GenericDao<Sport> sportDao = new GenericDao<>(Sport.class);
//        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
//
//        // Check if teams already exist
//        List<Team> existingTeams = teamDao.getAll();
//        if (!existingTeams.isEmpty()) {
//            logger.debug("Teams already exist in database");
//            return;
//        }
//
//        // If no teams exist, proceed with loading
//        // get nba id
//        Sport nba = sportDao.getById(1);
//
//        // Load the rest of the nba teams
//        List<String> nbaTeams = List.of(
//                "Celtics", "Nets", "Hornets",
//                "Cavaliers", "Mavericks", "Nuggets", "Pistons", "Warriors",
//                "Rockets", "Pacers", "Clippers", "Lakers", "Grizzlies",
//                "Heat", "Bucks", "Timberwolves", "Pelicans", "Knicks",
//                "Thunder", "Magic", "76ers", "Suns", "Trail Blazers",
//                "Kings", "Spurs", "Raptors", "Jazz", "Wizards", "Hawks", "Bulls"
//        );
//
//        // for each teamName in nbaTeams list
//        for (String teamName : nbaTeams) {
//            Team team = new Team(teamName, nba); // create new team in/on nba object
//            teamDao.insert(team);
//        }
//
//        logger.debug("Loading NBA teams for the first time");
//    }
}
