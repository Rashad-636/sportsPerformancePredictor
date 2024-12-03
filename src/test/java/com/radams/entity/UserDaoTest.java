package com.radams.entity;

import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao<>(User.class);

        Database database = Database.getInstance();
        database.runSQL("testDB.sql");
    }

    @Test
    void getByIdSuccess() {

        // get user
        User user = (User) genericDao.getById(1);
        assertNotNull(user);

        // verify if both objects match (calls .equals method generated in User class to compare)
        User user2 = (User) genericDao.getById(1);
        assertEquals(user, user2);

//        logger.debug("User being returned:" + user);
    }

    @Test
    void updateUserSuccess() {

        // get user
        User user = (User) genericDao.getById(1);

        // update user email
        user.setUserEmail("Updated@123.com");
        genericDao.update(user);

        // verify if both objects match (calls .equals method generated in User class to compare)
        User user2 = (User) genericDao.getById(1);
        assertEquals(user, user2);

//        logger.debug("Updated user being returned:" + user);
    }

    @Test
    void insertUserSuccess() {

        // create a new user
        User newUser = new User("newUser@123.com");

        //insert new
        int insert = genericDao.insert(newUser); // insert method returns int

        // verification
        assertNotNull(insert);
        User insertedUser = (User) genericDao.getById(insert);
        assertEquals(newUser, insertedUser);

//        logger.debug("Inserted user being returned:" + insertedUser.getUserEmail());
    }

    @Test
    void deleteUserSuccess() {
        // get user
        User user = (User) genericDao.getById(1);

        //delete user
        genericDao.delete(user);

        // verification
        User user2 = (User) genericDao.getById(1);
        assertNull(user2);

//        logger.debug("Deleted user being returned:" + user);
    }

    @Test
    void getAllUsersSuccess() {
        List<User> users = genericDao.getAll();
        assertNotNull(users);
        assertEquals(2, users.size()); // list size should be two

//        logger.debug("Users being returned:" + users);
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = genericDao.getByPropertyEqual("userEmail", "Test@123.com");
        assertNotNull(users);
        assertEquals(1, users.size());

//        logger.debug("Users being returned by property equal:" + users);
    }

    @Test
    void getByPropertyLike() {
        List<User> users = genericDao.getByPropertyLike("userEmail", ".com");
        assertNotNull(users);
        assertEquals(2, users.size());

//        logger.debug("Users being returned by property like:" + users);
    }

}