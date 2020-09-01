package ch.puzzle.devtre.test.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {

    @GET
    public Response getData() {
        return Response.ok().build();
    }
}
