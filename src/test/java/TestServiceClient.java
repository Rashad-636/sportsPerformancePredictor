import com.fasterxml.jackson.databind.ObjectMapper;
import com.radams.persistence.PropertiesLoader;
import com.rapidapi.Tank01Team.DailyScheduleResponse;
import com.rapidapi.Tank01Team.TeamsResponse;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
// log4J both
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    String API_URL;
    String API_KEY;
    String API_HOST;
    String API_URL2;

    public void init() {

        Properties properties;

        try {
            properties = loadProperties("/tank01.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        API_URL = properties.getProperty("getNbaTeams");
        API_URL2 = properties.getProperty("getDailySchedule");
        API_KEY = properties.getProperty("rapidApi-key-header");
        API_HOST = properties.getProperty("rapidApi-host-header");
    }

    // test for nba teams and schedules
    @Test
    public void testTank01JSON() throws Exception {
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
        TeamsResponse data = mapper.readValue(response, TeamsResponse.class);

        assertEquals("Magic", data.getBody().get(0).getTeamName());
//        logger.info("Team Name: {}", data.getBody().get(0).getTeamName());
    }

    @Test
    public void testTank02JSON() throws Exception {
        init();

        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_URL2 + todayDate);

        String response = target.request(MediaType.APPLICATION_JSON)
                .header("x-rapidapi-host", API_HOST)
                .header("x-rapidapi-key", API_KEY)
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        DailyScheduleResponse data = mapper.readValue(response, DailyScheduleResponse.class);

        logger.debug("Response: " + data.getBody().get(0));
    }
}
