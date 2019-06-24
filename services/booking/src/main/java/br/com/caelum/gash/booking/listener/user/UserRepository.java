package br.com.caelum.gash.booking.listener.user;

import br.com.caelum.gash.booking.shared.domain.User;
import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, Long> {
    void save(User user);
}
