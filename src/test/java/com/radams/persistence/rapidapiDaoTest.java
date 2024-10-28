package com.radams.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rapidapiDaoTest {

    @Test
    void getTeamnameSucess() {
        RapidapiDao dao = new RapidapiDao();
        assertEquals("Magic", dao.getTeams().getBody().get(0).getTeamName());
    }

}