package br.com.caelum.gash.payment.shared;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher<VALUE> {

    private final KafkaTemplate<Long, VALUE> kafka;

    public EventPublisher(KafkaTemplate<Long, VALUE> kafka) {
        this.kafka = kafka;
    }

    public void send(Long key, VALUE value)  {
        kafka.send("payments", key, value);
    }
}
