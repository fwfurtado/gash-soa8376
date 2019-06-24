package br.com.caelum.gash.booking.features.payment;

import br.com.caelum.gash.booking.shared.domain.Booking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class BookingToPaymentRequestConverter implements Converter<Booking, PaymentRequest> {

    @Override
    public PaymentRequest convert(Booking source) {
        return new PaymentRequest(source.getId(), source.getStart());
    }
}
