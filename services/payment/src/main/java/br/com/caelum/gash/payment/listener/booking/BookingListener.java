package br.com.caelum.gash.payment.listener.booking;

import br.com.caelum.gash.booking.shared.events.AttemptPaymentEvent;
import br.com.caelum.gash.payment.shared.EventPublisher;
import br.com.caelum.gash.payment.shared.events.CreatedPayment;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class BookingListener {

    private static final Logger LOG = LoggerFactory.getLogger(BookingListener.class);

    private final EventPublisher<CreatedPayment> publisher;

    BookingListener(EventPublisher<CreatedPayment> publisher) {
        this.publisher = publisher;
    }

    @KafkaListener(topics = "${gash.topics.booking}")
    void handle(AttemptPaymentEvent event) {

        LOG.info("[LISTENER][BOOKING] Receive an attempt payment as: {} ", event);

        CreatedPayment payment = new CreatedPayment(UUID.randomUUID(), ZonedDateTime.now());

        publisher.send(event.getBookingId(), payment);
    }
}
