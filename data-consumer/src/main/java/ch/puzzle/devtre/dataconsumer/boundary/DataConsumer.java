package ch.puzzle.devtre.dataconsumer.boundary;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/data")
public class DataConsumer {

    private static final Logger LOGGER = Logger.getLogger(DataConsumer.class.getName());

    @Inject
    @Channel("tweets")
    Publisher<String> tweetsPublisher;

    @Incoming("manual-transformed")
    public void streamData(String data) {
        LOGGER.info(data);
    }

    @GET
    @Path("/tweets/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain")
    public Publisher<String> streamTweets() {
        return tweetsPublisher;
    }
}
