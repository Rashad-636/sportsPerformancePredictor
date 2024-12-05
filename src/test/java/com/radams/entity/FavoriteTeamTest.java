package com.radams.entity;

import com.radams.persistence.Database;
import com.radams.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FavoriteTeamTest {

    GenericDao favoriteDao;
    GenericDao teamDao;
    GenericDao userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        favoriteDao = new GenericDao<>(FavoriteTeam.class);
        teamDao = new GenericDao<>(Team.class);
        userDao = new GenericDao<>(User.class);

        Database database = Database.getInstance();
        database.runSQL("testDB.sql");
    }

    @Test
    void getIdSuccess(){
        // Test getting by ID
        FavoriteTeam retrievedFavorite = (FavoriteTeam) favoriteDao.getById(1);

        // Verify
        assertNotNull(retrievedFavorite);
        FavoriteTeam team2 = (FavoriteTeam) favoriteDao.getById(1);
        assertEquals(retrievedFavorite.getId(), team2.getId()); // compare IDs

//        logger.info("This favorite team is: " + retrievedFavorite.getTeam().getTeamName() +
//                ". And belongs to user: " + retrievedFavorite.getUser().getUserEmail());

    }

    @Test
    void updateFavoriteSuccess(){
        FavoriteTeam retrievedFavorite = (FavoriteTeam) favoriteDao.getById(1);
        assertNotNull(retrievedFavorite);

        // Get new team to update to
        Team newTeam = (Team) teamDao.getById(4);
        assertNotNull(newTeam);

        // update and verify
        retrievedFavorite.setTeam(newTeam);
        favoriteDao.update(retrievedFavorite);

        // verify
        FavoriteTeam updatedFavorite = (FavoriteTeam) favoriteDao.getById(1);
        assertEquals(retrievedFavorite.getId(), updatedFavorite.getId()); // compare ID only

//        logger.debug("Updated favorite team from Hawks to: " + updatedFavorite.getTeam().getTeamName());
    }

    @Test
    void deleteFavoriteSuccess(){
        FavoriteTeam retrievedFavorite = (FavoriteTeam) favoriteDao.getById(1);
        assertNotNull(retrievedFavorite);
        favoriteDao.delete(retrievedFavorite);

        // verification
        FavoriteTeam updatedFavorite = (FavoriteTeam) favoriteDao.getById(1);
        assertNull(updatedFavorite);
    }

    @Test
    void insertFavoriteSuccess(){
        // get user
        User user = (User) userDao.getById(1);

        // get team
        Team team = (Team) teamDao.getById(4);

        // create new favorite
        FavoriteTeam newFavorite = new FavoriteTeam(user, team);
        int insert = favoriteDao.insert(newFavorite);

        // verification
        assertNotNull(insert);
        FavoriteTeam insertedFavorite = (FavoriteTeam) favoriteDao.getById(insert);
        assertEquals(newFavorite.getId(), insertedFavorite.getId()); // compare ID only

//        logger.debug("Inserted favorite team: " + insertedFavorite.getTeam().getTeamName());
    }

    @Test
    void getAllFavoritesFromDatabaseSuccess(){
        List<FavoriteTeam> favs = favoriteDao.getAll();
        assertNotNull(favs);
        assertEquals(4, favs.size());
//        logger.debug("Favs: " + favs.size());
    }

    @Test
    void getAllFavoritesByUserSuccess(){
        // get a user
        User user = (User) userDao.getById(1);
        assertNotNull(user);

        // get all the user's favorite teams
        List<FavoriteTeam> favs = favoriteDao.getByPropertyEqual("user", user);

        // verification
        assertNotNull(favs);

        for (FavoriteTeam fav : favs) {
            assertEquals(user.getId(), fav.getUser().getId()); // verify the fav team belongs to the user
//            logger.debug("Found User: " + user.getUserEmail() + " and the " + fav.getTeam().getTeamName()
//            + " is a favorited team");
        }

//        logger.debug("Favorite team total: " + favs.size());
    }
}