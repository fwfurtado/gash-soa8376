package br.com.caelum.gash.garage.features.creation;

import br.com.caelum.gash.garage.shared.domain.Garage;
import org.springframework.data.repository.Repository;

interface CreationRepository extends Repository<Garage, Long> {

    void save(Garage garage);
}
