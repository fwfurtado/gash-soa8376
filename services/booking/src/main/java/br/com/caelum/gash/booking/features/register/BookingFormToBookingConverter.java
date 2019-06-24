package br.com.caelum.gash.booking.features.register;

import br.com.caelum.gash.booking.shared.domain.Booking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BookingFormToBookingConverter implements Converter<BookingForm, Booking> {

    @Override
    public Booking convert(BookingForm source) {
        return new Booking(source.getStart(), source.getEnd());
    }
}
