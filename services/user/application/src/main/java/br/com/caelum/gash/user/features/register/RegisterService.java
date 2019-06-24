package br.com.caelum.gash.user.features.register;

import br.com.caelum.gash.user.commons.EventPublisher;
import br.com.caelum.gash.user.domain.User;
import br.com.caelum.gash.user.events.CreatedUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private final RegisterRepository repository;
    private final Converter<UserForm, User> converter;
    private final EventPublisher<Long, CreatedUser> eventPublisher;

    RegisterService(RegisterRepository repository, Converter<UserForm, User> converter, EventPublisher<CreatedUser> eventPublisher) {
        this.repository = repository;
        this.converter = converter;
        this.eventPublisher = eventPublisher;
    }

    String saveBy(UserForm form) {
        User user = converter.convert(form);

        repository.save(user);

        eventPublisher.send(user.getId(), new CreatedUser(user.getId(), user.getName(), user.getEmail()));

        return user.getSlug();
    }
}
