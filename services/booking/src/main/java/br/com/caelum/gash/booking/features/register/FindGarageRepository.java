package br.com.caelum.gash.booking.features.register;

import br.com.caelum.gash.booking.shared.domain.Garage;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface FindGarageRepository extends Repository<Garage, Long> {

    Optional<Garage> findById(Long id);
}
