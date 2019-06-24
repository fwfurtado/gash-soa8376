package br.com.caelum.gash.garage.features.creation;

import br.com.caelum.gash.garage.shared.domain.User;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface LoadUserRepository extends Repository<User, Long> {

    Optional<User> findById(Long id);
}
