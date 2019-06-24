package br.com.caelum.gash.user.commons;

import org.springframework.kafka.core.KafkaTemplate;

public class EventPublisher<KEY, VALUE> {

    private final KafkaTemplate<KEY, VALUE> kafka;
    private final String topic;

    EventPublisher(KafkaTemplate<KEY, VALUE> kafka, NameableTopic nameableTopic) {
        this.kafka = kafka;
        this.topic = nameableTopic.getTopicName();
    }

    public void send(KEY key, VALUE value)  {
        kafka.send("users", key, value);
    }
}
