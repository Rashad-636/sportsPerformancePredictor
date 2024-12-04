package com.radams.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radams.entity.Team;
import com.rapidapi.Tank01Team.Response;
import com.rapidapi.Tank01Team.Teams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class rapidapiDaoTest {

    private final Logger logger = LogManager.getLogger(rapidapiDaoTest.class);

    @Test
    void getTeamnameSucess() {
        RapidapiDao dao = new RapidapiDao();
        assertEquals("Magic", dao.getTeams().getBody().get(0).getTeamName());

//        logger.info("team name is:" + dao.getTeams().getBody().get(0).getTeamName());
        logger.info("team schedule is: {}", dao.getTeams().getBody().get(1).getTeamSchedule());
    }

    @Test
    public void verifyTeamAbv() {

        RapidapiDao dao = new RapidapiDao();
        List<Teams> apiTeams = dao.getTeams().getBody();

        // get all teams from database
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        List<Team> databaseTeams = teamDao.getAll();
//        logger.info("Database teams: {}", databaseTeams);

//        Verification - match database teams to apiTeams and get team abv
        for (Team team : databaseTeams) {
            boolean found = false;
            for (Teams apiTeam : apiTeams) {
                if (team.getTeamAbv().equals(apiTeam.getTeamAbv())) {
                    found = true;
                    logger.info("Found team in API: {}", team.getTeamAbv());
                    break;
                }
            }
        }
    }

    @Test
    public void testGetTeamSchedulebyAbv() {
        RapidapiDao dao = new RapidapiDao();
        List<Teams> apiTeams = dao.getTeams().getBody();

        // get all teams from database
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        List<Team> databaseTeams = teamDao.getAll();

        //        Verification - match database teams to apiTeams and get team abv
        for (Team team : databaseTeams) {
            boolean found = false;
            for (Teams apiTeam : apiTeams) {
                if (team.getTeamAbv().equals(apiTeam.getTeamAbv())) {
                    found = true;
                    logger.info("Found team in API: {}", team.getTeamName());
                    logger.info("and this is their schedule: {}", apiTeam.getTeamSchedule());
                }
            }
        }


    }

}