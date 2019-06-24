package br.com.caelum.gash.booking.listener.garage;

import br.com.caelum.gash.booking.shared.domain.User;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface FindPartnerRepository extends Repository<User, Long> {

    Optional<User> findById(Long id);
}
