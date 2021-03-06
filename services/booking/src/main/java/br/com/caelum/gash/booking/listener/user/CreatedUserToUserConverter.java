package br.com.caelum.gash.booking.listener.user;

import br.com.caelum.gash.user.shared.events.CreatedUser;
import br.com.caelum.gash.booking.shared.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CreatedUserToUserConverter implements Converter<CreatedUser, User> {

    @Override
    public User convert(CreatedUser source) {
        return new User(source.getId(), source.getName());
    }
}
