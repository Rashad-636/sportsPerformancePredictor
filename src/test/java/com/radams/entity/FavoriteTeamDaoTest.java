package com.radams.entity;

import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FavoriteTeamDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(FavoriteTeam.class);

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getByIdSuccess() {
        FavoriteTeam favoriteTeam = (FavoriteTeam) genericDao.getById(1);
        assertNotNull(favoriteTeam); // see if a favorite team us being returned

        // verify if both objects match (calls .equals method generated in User class to compare)
        FavoriteTeam favoriteTeam2 = (FavoriteTeam) genericDao.getById(1);
        assertEquals(favoriteTeam, favoriteTeam2);
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }

    @Test
    void testGetByPropertyEqual() {
    }
}