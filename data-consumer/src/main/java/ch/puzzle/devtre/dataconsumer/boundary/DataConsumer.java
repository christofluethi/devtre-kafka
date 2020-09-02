package ch.puzzle.devtre.dataconsumer.boundary;

import io.smallrye.reactive.messaging.kafka.IncomingKafkaRecordMetadata;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class DataConsumer {

    @Incoming("manual-transformed")
    @Outgoing("websocket-broadcast")
    public String streamManual(Message<String> msg) {
        return getKafkaMetadata(msg)+": "+msg.getPayload();
    }

    @Incoming("tweets")
    @Outgoing("websocket-broadcast")
    public String streamTweets(Message<String> msg) {
        return getKafkaMetadata(msg)+": "+msg.getPayload();
    }

    String getKafkaMetadata(Message<String> msg) {
        Optional<IncomingKafkaRecordMetadata> meta = msg.getMetadata(IncomingKafkaRecordMetadata.class);
        return meta.map(m -> m.getTopic()+"-"+m.getPartition()+" offset "+m.getOffset()).orElse("unknown");
    }
}
