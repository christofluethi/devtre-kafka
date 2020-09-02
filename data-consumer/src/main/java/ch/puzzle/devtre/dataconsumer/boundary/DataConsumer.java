package ch.puzzle.devtre.dataconsumer.boundary;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class DataConsumer {

    private static final Logger LOGGER = Logger.getLogger(DataConsumer.class.getName());

    @Incoming("manual-transformed")
    public void streamData(String data) {
        LOGGER.info(data);
    }

    @Incoming("tweets")
    @Outgoing("tweets-stream")
    public String streamTweets(String data) {
        LOGGER.info(data);
        return data;
    }
}
