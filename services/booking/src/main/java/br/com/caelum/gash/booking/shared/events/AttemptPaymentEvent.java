package br.com.caelum.gash.booking.shared.events;

import java.time.ZonedDateTime;

public class AttemptPaymentEvent {

    private final Long bookingId;
    private final ZonedDateTime start;

    public AttemptPaymentEvent(Long bookingId, ZonedDateTime start) {
        this.bookingId = bookingId;
        this.start = start;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public ZonedDateTime getStart() {
        return start;
    }
}
