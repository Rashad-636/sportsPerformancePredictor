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

    private final Logger logger = LogManager.getLogger(TestServiceClient.class);

    @Test
    public void testTank01JSON() throws Exception {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://tank01-fantasy-stats.p.rapidapi.com/getNBATeams")
                .queryParam("schedules", false)
                .queryParam("rosters", false)
                .queryParam("topPerformers", false)
                .queryParam("teamStats", false);

        String response = target.request(MediaType.APPLICATION_JSON)
                .header("x-rapidapi-host", "tank01-fantasy-stats.p.rapidapi.com")
                .header("x-rapidapi-key", "2675fa7793msh7dc98ee2c3c8b44p148f76jsn9e60568e447f")
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response data = mapper.readValue(response, Response.class);

        assertEquals("Magic" , data.getBody().get(0).getTeamName());
        logger.debug(data.getBody().get(0).getTeamName());
    }
}
