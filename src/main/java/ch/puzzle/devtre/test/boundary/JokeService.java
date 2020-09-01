package ch.puzzle.devtre.test.boundary;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jokes")
@RegisterRestClient(configKey = "joke-api")
public interface JokeService {

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public JokeResponse getRandomJoke();

    interface JokeResponse {
        String getType();
        JokeResponseBody getValue();
        String[] getCategories();
    }

    interface JokeResponseBody {
        Long getId();
        String getJoke();
    }
}
