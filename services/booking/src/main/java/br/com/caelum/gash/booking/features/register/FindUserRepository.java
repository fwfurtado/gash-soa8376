package br.com.caelum.gash.booking.features.register;

import br.com.caelum.gash.booking.shared.domain.User;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface FindUserRepository extends Repository<User, Long> {

    Optional<User> findById(Long id);
}
