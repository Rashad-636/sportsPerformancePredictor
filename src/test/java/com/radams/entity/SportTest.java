package com.radams.entity;

import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportTest {

    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(Sport.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }


    @Test
    void getIdSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        assertNotNull(sport); // see if a sport is being returned

        // verify if both objects match (calls .equals method generated in User class to compare)
        Sport sport2 = (Sport) genericDao.getById(1);
        assertEquals(sport, sport2);
        assertEquals("Football" , sport.getSportName()); // confirming football is being called

        logger.info("The sport name that is being returned is: " + sport.getSportName());
    }

    @Test
    void updateSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        sport.setSportName("Name Change");
        genericDao.update(sport);

        // verify if both objects match (calls .equals method generated in User class to compare)
        Sport sport2 = (Sport) genericDao.getById(1);
        assertEquals(sport, sport2);
        logger.info("Sport name after change: " + sport.getSportName());
    }

    @Test
    void deleteSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        genericDao.delete(sport);
        assertNull(genericDao.getById(1));
    }

    @Test
    void insertWithTeamSuccess() {
        // create a sport
        Sport newSport = new Sport("New Sport" , "newSportApi");

        // create a new team
        Team team = new Team( "New Team", "Kansas", newSport);

        // add team to sport
        newSport.addTeam(team);

        // insert sport
        int insert = genericDao.insert(newSport); // insert method returns an int which is assigned to int variable

        // verify if both objects match (calls .equals method generated in User class to compare)
        assertNotNull(insert);
        Sport insertedSport = (Sport) genericDao.getById(insert);
        assertEquals(insertedSport, newSport);

        logger.info("Inserted sport: " + newSport.getSportName());
    }

    @Test
    void getPlayers() {
    }

    @Test
    void setPlayers() {
    }

    @Test
    void getTeams() {
    }

    @Test
    void setTeams() {
    }

    @Test
    void getApiEndpoint() {
    }

    @Test
    void setApiEndpoint() {
    }

    @Test
    void getSportName() {
    }

    @Test
    void setSportName() {
    }
}