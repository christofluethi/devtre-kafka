package ch.puzzle.devtre.manualdatatransformer.boundary;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManualDataTransformer {

    @Incoming("manual")
    @Outgoing("manual-transformed")
    @Broadcast
    public String transform(String value) {
        return Integer.toString(value.hashCode());
    }
}