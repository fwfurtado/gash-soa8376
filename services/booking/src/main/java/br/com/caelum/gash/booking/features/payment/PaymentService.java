package br.com.caelum.gash.booking.features.payment;

import br.com.caelum.gash.booking.shared.EventPublisher;
import br.com.caelum.gash.booking.shared.domain.Booking;
import br.com.caelum.gash.booking.shared.events.AttemptPaymentEvent;
import br.com.caelum.gash.booking.shared.exception.BookingAlreadyPayedException;
import br.com.caelum.gash.booking.shared.exception.BookingCannotBePayedException;
import br.com.caelum.gash.booking.shared.exception.BookingNotFoundException;
import br.com.caelum.gash.booking.shared.exception.PaymentFallbackException;
import java.util.Optional;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class PaymentService {

    private final PaymentBookingRepository repository;
    private final Converter<Booking, PaymentRequest> converter;
    private final PaymentClient paymentClient;
    private final EventPublisher<AttemptPaymentEvent> publisher;

    PaymentService(PaymentBookingRepository repository, Converter<Booking, PaymentRequest> converter, PaymentClient paymentClient, EventPublisher<AttemptPaymentEvent> publisher) {
        this.repository = repository;
        this.converter = converter;
        this.paymentClient = paymentClient;
        this.publisher = publisher;
    }

    PaymentView payBookingBy(Long id) {
        Booking booking = repository.findById(id)
                            .orElseThrow(() -> new BookingNotFoundException(id));

        if (booking.alreadyPayed()) {
            throw new BookingAlreadyPayedException(id);
        }

        if (!booking.canBePay()) {
            throw new BookingCannotBePayedException(booking);
        }

        PaymentRequest request = converter.convert(booking);

        Optional<PaymentView> payment = paymentClient.payBooking(request);

        if (payment.isPresent()) {

            booking.pay();

            repository.save(booking);

            return payment.get();
        }

        publisher.send(id, new AttemptPaymentEvent(request.getBookingId(), request.getStart()));

        throw new PaymentFallbackException();
    }
}
