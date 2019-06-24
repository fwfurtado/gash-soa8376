package br.com.caelum.gash.booking.shared.events;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

public class AttemptPaymentEvent {
    private Long bookingId;
    private ZonedDateTime start;

    public Long getBookingId() {
        return bookingId;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AttemptPaymentEvent.class.getSimpleName() + "[", "]")
            .add("bookingId=" + bookingId)
            .add("start=" + start)
            .toString();
    }
}
