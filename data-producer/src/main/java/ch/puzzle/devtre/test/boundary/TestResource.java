package ch.puzzle.devtre.test.boundary;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {

    @RestClient
    JokeService jokeService;

    @GET
    public Response getData() {
        return Response.ok(jokeService.getRandomJoke().value.joke).build();
    }
}
