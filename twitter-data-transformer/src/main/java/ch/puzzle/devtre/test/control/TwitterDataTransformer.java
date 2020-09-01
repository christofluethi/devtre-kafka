package ch.puzzle.devtre.test.control;

import ch.puzzle.devtre.test.entity.Tweet;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TwitterDataTransformer {

    @Broadcast
    @Outgoing("tweets")
    @Incoming("twitter-inbound")
    public String transform(Tweet tweet) {
        return tweet.getText().toLowerCase();
    }
}