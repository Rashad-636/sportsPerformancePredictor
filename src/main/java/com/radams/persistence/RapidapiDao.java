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
import java.util.Properties;

public class RapidapiDao implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(RapidapiDao.class);
    String API_URL;
    String API_KEY;
    String API_HOST;

    public void init() {

        Properties properties;

        try {
            properties = loadProperties("/tank01.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        API_URL = properties.getProperty("getNbaTeams");
        API_KEY = properties.getProperty("rapidApi-key-header");
        API_HOST = properties.getProperty("rapidApi-host-header");
    }

    public Response getTeams() {
        // load properties
        init();

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_URL)
                .queryParam("schedules", true)
                .queryParam("rosters", false)
                .queryParam("topPerformers", false)
                .queryParam("teamStats", false);

        String response = target.request(MediaType.APPLICATION_JSON)
                .header("x-rapidapi-host", API_HOST)
                .header("x-rapidapi-key", API_KEY)
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response team = null;
        try {
            team = mapper.readValue(response, Response.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error(e);
        }

//        logger.debug("Teams and schedule returned: {}", team);

        return team;
    }
}