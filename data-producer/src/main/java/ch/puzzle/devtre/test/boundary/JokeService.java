package ch.puzzle.devtre.test.boundary;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jokes")
@RegisterRestClient(configKey = "joke-api")
public interface JokeService {

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    JokeResponse getRandomJoke();

    class JokeResponse {
        public String type;
        public JokeResponseBody value;
        public String[] categories;
    }

    class JokeResponseBody {
        public Long id;
        public String joke;
    }
}
