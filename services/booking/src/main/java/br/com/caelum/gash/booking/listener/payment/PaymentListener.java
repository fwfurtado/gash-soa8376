package br.com.caelum.gash.booking.listener.payment;

import br.com.caelum.gash.booking.shared.domain.Booking;
import br.com.caelum.gash.booking.shared.exception.BookingNotFoundException;
import br.com.caelum.gash.payment.shared.events.CreatedPayment;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class PaymentListener {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentListener.class);
    private final BookingRepository repository;

    PaymentListener(BookingRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${gash.topics.payment}")
    void handle(ConsumerRecord<Long, CreatedPayment> event) {
        Long bookingId = event.key();

        Booking booking = repository.findById(bookingId)
                                .orElseThrow(() -> new BookingNotFoundException(bookingId));

        CreatedPayment payment = event.value();

        LOG.info("[LISTENER][PAYMENT] Created payment as: {}", payment);

        booking.pay();

        repository.save(booking);
    }

}
