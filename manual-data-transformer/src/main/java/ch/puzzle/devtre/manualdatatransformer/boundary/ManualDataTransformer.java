package ch.puzzle.devtre.manualdatatransformer.boundary;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class ManualDataTransformer {

    private static final Logger LOGGER = Logger.getLogger(ManualDataTransformer.class.getName());

    @Incoming("manual")
    @Outgoing("manual-transformed")
    @Broadcast
    public String transform(String value) {
        LOGGER.info("Received message: " + value);
        return value.toUpperCase();
    }
}