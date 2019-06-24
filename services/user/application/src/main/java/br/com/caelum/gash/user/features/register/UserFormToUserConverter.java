package br.com.caelum.gash.user.features.register;

import br.com.caelum.gash.user.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class UserFormToUserConverter implements Converter<UserForm, User> {

    @Override
    public User convert(UserForm form) {
        String name = form.getName();
        String slug = name.toLowerCase().replace(" ", "-");

        return new User(name, form.getEmail(), form.getPassword(), slug);
    }
}
