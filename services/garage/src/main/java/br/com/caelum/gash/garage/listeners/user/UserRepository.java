package br.com.caelum.gash.garage.listeners.user;

import br.com.caelum.gash.garage.shared.domain.User;
import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, Long> {

    void save(User user);
}
