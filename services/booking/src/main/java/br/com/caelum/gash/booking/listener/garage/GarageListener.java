package br.com.caelum.gash.booking.listener.garage;

import br.com.caelum.gash.garage.shared.events.CreatedGarageEvent;
import br.com.caelum.gash.booking.shared.domain.Garage;
import br.com.caelum.gash.booking.shared.domain.User;
import br.com.caelum.gash.booking.shared.exception.PartnerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class GarageListener {
    private static final Logger LOG = LoggerFactory.getLogger(GarageListener.class);

    private final FindPartnerRepository userRepository;
    private final Converter<CreatedGarageEvent, Garage> converter;
    private final GarageRepository garageRepository;

    GarageListener(FindPartnerRepository userRepository, Converter<CreatedGarageEvent, Garage> converter, GarageRepository garageRepository) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.garageRepository = garageRepository;
    }

    @KafkaListener(topics = "${gash.topics.garage}")
    void handle(CreatedGarageEvent event) {
        LOG.info("[LISTENER][GARAGE] Create garage as: {}", event);

        Long partnerId = event.getOwnerId();

        User partner = userRepository.findById(partnerId)
                .orElseThrow(() -> new PartnerNotFoundException(partnerId));

        Garage garage = converter.convert(event);
        garage.setPartner(partner);

        garageRepository.save(garage);
    }
}
