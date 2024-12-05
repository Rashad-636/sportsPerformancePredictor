package com.radams.persistence;

import com.radams.entity.Team;
import com.rapidapi.Tank01Team.Teams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class rapidApiDaoTest {

    private final Logger logger = LogManager.getLogger(rapidApiDaoTest.class);

    @Test
    void getTeamNameSuccess() {
        RapidapiDao dao = new RapidapiDao();
        assertEquals("Magic", dao.getTeams().getBody().get(0).getTeamName());

//        logger.info("Magic schedule: {}", dao.getTeams().getBody().get(0).getTeamSchedule());
    }

    @Test
    public void verifyTeamAbv() {

        RapidapiDao dao = new RapidapiDao();
        List<Teams> apiTeams = dao.getTeams().getBody();

        // get all teams from database
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        List<Team> databaseTeams = teamDao.getAll();
//        logger.info("Database teams: {}", databaseTeams);

//        Verification - match database teams to apiTeams and get team abv in log
        for (Team team : databaseTeams) {
            boolean found = false;
            for (Teams apiTeam : apiTeams) {
                if (team.getTeamAbv().equals(apiTeam.getTeamAbv())) {
                    found = true;
//                    logger.info("Found team in API: {}", team.getTeamAbv());
                    break;
                }
            }
            assertTrue(found, "Team abbreviation " + team.getTeamAbv() + " not found in API");
        }
    }

    @Test
    public void testGetTeamScheduleByAbv() {
        RapidapiDao dao = new RapidapiDao();
        List<Teams> apiTeams = dao.getTeams().getBody();

        // get all teams from database
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);
        List<Team> databaseTeams = teamDao.getAll();

        assertNotNull(databaseTeams.isEmpty(), "Database teams list should not be empty");
        assertNotNull(apiTeams.isEmpty(), "API teams list should not be empty");

        // Verification - match database teams to apiTeams. return the team name and  schedule in log
        for (Team team : databaseTeams) {
            boolean found = false;
            for (Teams apiTeam : apiTeams) {
                if (team.getTeamAbv().equals(apiTeam.getTeamAbv())) {
                    found = true;
//                    logger.info("Found team in API: {}", team.getTeamName());
//                    logger.info("and this is their schedule: {}", apiTeam.getTeamSchedule());

                    // get team schedule map object from api and store Example response:("20250125_TOR@ATL", schedule object)
                    Map<String, Map<String, Object>> schedule = (Map<String, Map<String, Object>>) apiTeam.getTeamSchedule();

                    assertNotNull(schedule,"Schedule should not be null");

                    // for each schedule(for each team), get the game date, homeTeam, awayTeam, and game time
                    // NOTE: gameDate needs to be sorted and formatted
                    for (Map.Entry<String, Map<String, Object>> gameEntry : schedule.entrySet()) {
                        String gameDate = (String) gameEntry.getValue().get("gameDate");
                        String homeTeam = (String) gameEntry.getValue().get("home");
                        String awayTeam = (String) gameEntry.getValue().get("away");
                        String gameTime = (String) gameEntry.getValue().get("gameTime");

//                        logger.info("Game Date: {}, Home Team: {}, Away Team: {}, Game Time: {}",
//                                gameDate, homeTeam, awayTeam, gameTime);
                    }
                    break;
                }
            }
            assertTrue(found, "Team " + team.getTeamName() + " should have a schedule");
        }
    }

}