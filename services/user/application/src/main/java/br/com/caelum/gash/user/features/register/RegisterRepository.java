package br.com.caelum.gash.user.features.register;

import br.com.caelum.gash.user.domain.User;
import org.springframework.data.repository.Repository;

interface RegisterRepository extends Repository<User, Long> {
    void save(User user);
}
