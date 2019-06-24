package br.com.caelum.gash.garage.features.creation;

import br.com.caelum.gash.garage.shared.EventPublisher;
import br.com.caelum.gash.garage.shared.domain.Garage;
import br.com.caelum.gash.garage.shared.domain.User;
import br.com.caelum.gash.garage.shared.events.CreatedGarageEvent;
import br.com.caelum.gash.garage.shared.exceptions.UserNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class CreationService {

    private final LoadUserRepository userRepository;
    private final Converter<GarageForm, Garage> converter;
    private final CreationRepository garageRepository;
    private EventPublisher<CreatedGarageEvent> publisher;

    CreationService(LoadUserRepository userRepository, Converter<GarageForm, Garage> converter, CreationRepository garageRepository, EventPublisher<CreatedGarageEvent> publisher) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.garageRepository = garageRepository;
        this.publisher = publisher;
    }

    Long saveBy(GarageForm form) {
        Long userId = form.getUserId();

        User user = userRepository
                        .findById(userId)
                        .orElseThrow(() -> new UserNotFoundException(String.format("Cannot find user with id '%s'", userId)));

        Garage garage = converter.convert(form);

        garage.setUser(user);

        garageRepository.save(garage);

        Long garageId = garage.getId();

        publisher.send(garageId, CreatedGarageEvent.from(garage));

        return garageId;
    }
}
