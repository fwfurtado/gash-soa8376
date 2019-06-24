package br.com.caelum.gash.garage.features.show;

import br.com.caelum.gash.garage.shared.domain.Garage;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface ShowRepository extends Repository<Garage, Long> {

    Optional<GarageView> findById(Long garageId);
}
