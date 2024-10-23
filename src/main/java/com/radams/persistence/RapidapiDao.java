package com.radams.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapidapi.Tank01Team.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RapidapiDao {

    private final Logger logger = LogManager.getLogger(RapidapiDao.class);

    Response getTeams() {

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://tank01-fantasy-stats.p.rapidapi.com/getNBATeams")
                // needs to be read from a properties file?
                .queryParam("schedules", false)
                .queryParam("rosters", false)
                .queryParam("topPerformers", false)
                .queryParam("teamStats", false);

        String response = target.request(MediaType.APPLICATION_JSON)
                // needs to be read from a properties file?
                .header("x-rapidapi-host", "tank01-fantasy-stats.p.rapidapi.com")
                .header("x-rapidapi-key", "2675fa7793msh7dc98ee2c3c8b44p148f76jsn9e60568e447f")
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response team = null;
        try {
            team = mapper.readValue(response, Response.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error(e);
        }

        logger.debug("Team returned: " + team);

        return team;
    }
}