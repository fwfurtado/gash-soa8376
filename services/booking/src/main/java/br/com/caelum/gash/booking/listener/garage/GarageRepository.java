package br.com.caelum.gash.booking.listener.garage;

import br.com.caelum.gash.booking.shared.domain.Garage;
import org.springframework.data.repository.Repository;

interface GarageRepository extends Repository<Garage, Long> {

    void save(Garage garage);
}
