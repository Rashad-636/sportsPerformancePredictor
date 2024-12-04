package com.radams.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import com.rapidapi.Tank01Team.Response;
import com.rapidapi.Tank01Team.Teams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamDaoTest {

    GenericDao genericDao;
    GenericDao genericDao2;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(Team.class);
        genericDao2 = new GenericDao<>(Sport.class);

        Database database = Database.getInstance();
        database.runSQL("testDB.sql");
    }

    @Test
    void getByIdSuccess() {
        Team team = (Team) genericDao.getById(1);
        assertNotNull(team);

        // verification
        Team team2 = (Team) genericDao.getById(1);
        assertEquals(team, team2);

//        logger.debug("The team that is being returned is: " + team.getTeamName());
    }

    @Test
    void updateTeamSuccess() {
        Team team = (Team) genericDao.getById(1);
        team.setTeamName("Updated Team");
        genericDao.update(team);

        // verification
        Team team2 = (Team) genericDao.getById(1);
        assertEquals(team, team2);

//        logger.debug("The team that is being returned is: " + team.getTeamName());
    }

    @Test
    void deleteTeamSuccess() {
        Team team = (Team) genericDao.getById(1);
        genericDao.delete(team);

        // verification
        assertNull(genericDao.getById(1)); // favorite team entries auto deleted
    }

    @Test
    void insertTeamSuccess() {
        // get sport
        Sport nba = (Sport) genericDao2.getById(1); // NBA

        // create new team and insert
        Team team = new Team("New team", nba);
        int insert = genericDao2.insert(team);

        // verification
        assertNotNull(insert);
        Team insertedTeam = (Team) genericDao.getById(insert);
        assertEquals(team, insertedTeam);

//        logger.debug("The team that is being inserted is: " + team.getTeamName());
    }

    @Test
    void getAllTeamsFromSportSuccess() {
        // get a sport (NBA)
        Sport sport = (Sport) genericDao2.getById(1);
        assertNotNull(sport);

        // get all teams in the nba
        List<Team> teams = genericDao.getByPropertyEqual("sport", sport);

        // verification
        assertNotNull(teams);

        for (Team team : teams) {
            assertEquals(sport.getId(), team.getSport().getId());// verify team belongs to the sport by comparing ID
//            logger.debug("Found team: " + team.getTeamName() + " for sport: " + team.getSport().getSportName());
        }

//        logger.debug("Total teams found: " + teams.size());
    }

    @Test
    void getAllTeamsFromDatabaseSuccess() {
        List<Team> teams = genericDao.getAll();
        assertNotNull(teams);
        assertEquals(4, teams.size());

//        logger.debug("Total teams found: " + teams.size());
    }

    @Test
    void getByPropertyEqual() {
        List<Team> teams = genericDao.getByPropertyEqual("teamName", "Bulls");
        assertNotNull(teams);
        assertEquals(1, teams.size());

//        logger.debug("Found team: " + teams.get(0).getTeamName());
    }

    @Test
    void getByPropertyLike() {
        List<Team> teams = genericDao.getByPropertyLike("teamName", "s");
        assertNotNull(teams);
        assertEquals(4, teams.size()); // all sample teams have an s

        for (Team team : teams) {
//            logger.debug("Found team: " + team.getTeamName()); // for each team get me the team name
        }
    }
}