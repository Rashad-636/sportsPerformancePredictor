package com.radams.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rapidapiDaoTest {

    private final Logger logger = LogManager.getLogger(rapidapiDaoTest.class);

    @Test
    void getTeamnameSucess() {
        RapidapiDao dao = new RapidapiDao();
        assertEquals("Magic", dao.getTeams().getBody().get(0).getTeamName());

        logger.info("team name is:" + dao.getTeams().getBody().get(0).getTeamName());
    }

}