import com.fasterxml.jackson.databind.ObjectMapper;
import com.rapidapi.Tank01Team.Response;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
// log4J both
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testTank01JSON() throws Exception {
        Client client = ClientBuilder.newClient();

        // needs to be read from a properties file?
        WebTarget target = client.target("https://tank01-fantasy-stats.p.rapidapi.com/getNBATeams")
                // needs to be read from a properties file?
                .queryParam("schedules", true)
                .queryParam("rosters", false)
                .queryParam("topPerformers", false)
                .queryParam("teamStats", false);

        String response = target.request(MediaType.APPLICATION_JSON)
                // needs to be read from a properties file?
                .header("x-rapidapi-host", "tank01-fantasy-stats.p.rapidapi.com")
                .header("x-rapidapi-key", "2675fa7793msh7dc98ee2c3c8b44p148f76jsn9e60568e447f")
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response data = mapper.readValue(response, Response.class);

        assertEquals("Magic", data.getBody().get(0).getTeamName());
        logger.info("Team Name: {}", data.getBody().get(0).getTeamName());
    }
}
