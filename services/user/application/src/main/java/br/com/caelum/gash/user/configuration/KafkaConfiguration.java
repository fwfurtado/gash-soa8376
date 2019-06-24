package br.com.caelum.gash.user.configuration;

import br.com.caelum.gash.user.commons.EventPublisher;
import br.com.caelum.gash.user.commons.EventPublisherFactory;
import br.com.caelum.gash.user.commons.Topics;
import br.com.caelum.gash.user.events.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@EnableKafka
@Configuration
class KafkaConfiguration {

    @Bean
    <E extends Event> EventPublisher<Long, E> publisher(EventPublisherFactory factory, KafkaTemplate<Long, E> template) {
        return factory.factoryBy(template, Topics.USER);
    }
}
