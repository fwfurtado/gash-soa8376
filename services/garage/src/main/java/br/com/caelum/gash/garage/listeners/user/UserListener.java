package br.com.caelum.gash.garage.listeners.user;

import br.com.caelum.gash.user.shared.events.CreatedUser;
import br.com.caelum.gash.garage.shared.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class UserListener {
    private static final Logger LOG = LoggerFactory.getLogger(UserListener.class);

    private final UserRepository repository;
    private final Converter<CreatedUser, User> converter;

    UserListener(UserRepository repository, Converter<CreatedUser, User> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @KafkaListener(topics = "${gash.topics.user}")
    void handle(CreatedUser event) {
        LOG.info("[LISTENER][USER] Created use as: {}", event);

        User user = converter.convert(event);

        repository.save(user);
    }
}
