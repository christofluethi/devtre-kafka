package ch.puzzle.devtre.test.control;

import ch.puzzle.devtre.test.entity.Tweet;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class TweetDeserializer extends JsonbDeserializer<Tweet> {

    public TweetDeserializer() {
        super(Tweet.class);
    }
}
