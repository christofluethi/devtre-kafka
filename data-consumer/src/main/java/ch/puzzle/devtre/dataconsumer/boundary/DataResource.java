package ch.puzzle.devtre.dataconsumer.boundary;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/data")
public class DataResource {

    @Inject
    @Channel("tweets-stream")
    Publisher<String> tweetsPublisher;


    @GET
    @Path("/tweets/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain")
    public Publisher<String> streamTweets() {
        return tweetsPublisher;
    }
}
