package br.com.caelum.gash.user.commons;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventPublisherFactory {

    public <K, V, E extends Enum<E> & NameableTopic> EventPublisher<K, V> factoryBy(KafkaTemplate<K,V> template, E topic) {
        return new EventPublisher<>(template, topic);
    }

}
