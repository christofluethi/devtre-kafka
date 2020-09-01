package ch.puzzle.devtre.test.control;

import ch.puzzle.devtre.test.boundary.JokeService;
import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class RandomGenerator {

    @RestClient
    JokeService jokeService;

    @Outgoing("manual")
    public Flowable<String> generateMessages() {
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> "random.nextInt(100)");
    }
}
