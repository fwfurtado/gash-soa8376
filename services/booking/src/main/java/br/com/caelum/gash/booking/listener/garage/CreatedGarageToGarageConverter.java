package br.com.caelum.gash.booking.listener.garage;

import br.com.caelum.gash.garage.shared.events.CreatedGarageEvent;
import br.com.caelum.gash.booking.shared.domain.Garage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CreatedGarageToGarageConverter implements Converter<CreatedGarageEvent, Garage> {

    @Override
    public Garage convert(CreatedGarageEvent source) {
        return new Garage(source.getId());
    }
}
