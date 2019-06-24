package br.com.caelum.gash.garage.features.creation;

import br.com.caelum.gash.garage.shared.domain.Garage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class GarageFormToGarageConverter implements Converter<GarageForm, Garage> {

    @Override
    public Garage convert(GarageForm source) {
        return new Garage(source.getAddress(), source.getLatitude(), source.getLongitude());
    }
}
