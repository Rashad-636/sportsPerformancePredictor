package com.radams.entity;

import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class SportDaoTest {

    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(Sport.class);

        Database database = Database.getInstance();
        database.runSQL("testDB.sql");
    }


    @Test
    void getIdSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        assertNotNull(sport); // see if a sport is being returned

        // verify if both objects match (calls .equals method generated in User class to compare)
        Sport sport2 = (Sport) genericDao.getById(1);
        assertEquals(sport, sport2);
        assertEquals("NBA" , sport.getSportName()); // confirming NBA is being called

        logger.debug("The sport name that is being returned is: " + sport.getSportName());
    }

    @Test
    void updateSportSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        sport.setSportName("Name Change");
        genericDao.update(sport);

        // verify if both objects match (calls .equals method generated in User class to compare)
        Sport sport2 = (Sport) genericDao.getById(1);
        assertEquals(sport, sport2);
        logger.debug("Sport name after change: " + sport.getSportName());
    }

    @Test
    void deleteSportSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        genericDao.delete(sport);
        assertNull(genericDao.getById(1));
    }

    @Test
    void insertNewSportWithNewTeamSuccess() {
        // create a sport
        Sport newSport = new Sport("New Sport");

        // create a new team
        Team team = new Team( "New Team", newSport);

        // add team to sport
        newSport.addTeam(team);

        // insert sport
        int insert = genericDao.insert(newSport); // insert method returns an int which is assigned to int variable

        // verify if both objects match (calls .equals method generated in User class to compare)
        assertNotNull(insert);
        Sport insertedSport = (Sport) genericDao.getById(insert);
        assertEquals(insertedSport, newSport);

        logger.debug("Inserted sport: " + newSport.getSportName());
    }

    @Test
    void getAllSportsSuccess() {
        List<Sport> sports = genericDao.getAll();
        assertNotNull(sports);
        assertEquals(2, sports.size()); // two sports

        // Log results
        logger.debug("Sports found: " + sports);
    }

    @Test
    void getByPropertyEqual() {
        List<Sport> sports = genericDao.getByPropertyEqual("sportName", "NBA");
        assertNotNull(sports);
        assertEquals(1, sports.size());

        logger.debug("Sports found with property equal: " + sports);
    }

    @Test
    void getByPropertyLike() {
        List<Sport> sports = genericDao.getByPropertyLike("sportName", "N");
        assertNotNull(sports);
        assertEquals(2, sports.size()); // should be two sports that start with the letter n

        for (Sport sport : sports) {
            logger.debug("Sport: " + sport.getSportName());
        }
    }

    @Test
    void loadNBATeams() {
        GenericDao<Team> teamDao = new GenericDao<>(Team.class);

        // get nba id
        Sport nba = (Sport) genericDao.getById(1);

        // Load the rest of the nba teams
        List<String> nbaTeams = List.of(
                "Celtics", "Nets", "Hornets",
                "Cavaliers", "Mavericks", "Nuggets", "Pistons", "Warriors",
                "Rockets", "Pacers", "Clippers", "Lakers", "Grizzlies",
                "Heat", "Bucks", "Timberwolves", "Pelicans", "Knicks",
                "Thunder", "Magic", "76ers", "Suns", "Trail Blazers",
                "Kings", "Spurs", "Raptors", "Jazz", "Wizards"
        );

        // Afor each teamName in nbaTeams list
        for (String teamName : nbaTeams) {
            Team team = new Team(teamName, nba); // create new team in/on nba object
            teamDao.insert(team);
        }

        // Verify teams were added (should be 30 total including Hawks and Bulls)
        List<Team> teams = teamDao.getByPropertyEqual("sport", nba);
        assertEquals(30, teams.size());
        logger.debug("Added " + teams.size() + " NBA teams to database");
    }
}