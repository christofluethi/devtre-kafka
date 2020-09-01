package ch.puzzle.devtre.dataconsumer.boundary;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@ApplicationScoped
public class DataConsumer {

    private static final Logger LOGGER = Logger.getLogger(DataConsumer.class.getName());

    @Incoming("manual-transformed")
    public void streamData(String data) {
        LOGGER.info(data);
    }
}
