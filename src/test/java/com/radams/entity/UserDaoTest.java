package com.radams.entity;

import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(User.class);

        Database database = Database.getInstance();
        database.runSQL("testDB.sql");
    }

    @Test
    void getByIdSuccess() {
        User user = (User) genericDao.getById(1);
        assertNull(user); // see if a favorite team us being returned

        // verify if both objects match (calls .equals method generated in User class to compare)
        User user2 = (User) genericDao.getById(1);
        assertEquals(user, user2);
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