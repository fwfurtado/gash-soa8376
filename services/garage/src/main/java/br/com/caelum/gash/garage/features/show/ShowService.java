package br.com.caelum.gash.garage.features.show;

import br.com.caelum.gash.garage.shared.exceptions.GarageNotFoundException;
import org.springframework.stereotype.Service;

@Service
class ShowService {

    private final ShowRepository repository;

    ShowService(ShowRepository repository) {
        this.repository = repository;
    }

    GarageView showGarageBy(Long garageId) {

        return repository.findById(garageId)
                                .orElseThrow(() -> new GarageNotFoundException(String.format("Cannot find garage with id '%s'", garageId)));

    }
}
