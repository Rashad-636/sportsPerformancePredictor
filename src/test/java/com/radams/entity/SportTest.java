package com.radams.entity;

import com.radams.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(Sport.class);

//        Database database = Database.getInstance();
//        database.runSQL("cleanDB.sql");
    }


    @Test
    void getIdSuccess() {
        Sport sport = (Sport) genericDao.getById(1);
        assertNotNull(sport); // see if a sport is being returned

        // verify if both objects match (calls .equals method generated in User class to compare)
        Sport sport2 = (Sport) genericDao.getById(1);
        assertEquals(sport, sport2);
        assertEquals("Football" , sport.getSportName()); // confirming football is being called
    }

    @Test
    void setId() {
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