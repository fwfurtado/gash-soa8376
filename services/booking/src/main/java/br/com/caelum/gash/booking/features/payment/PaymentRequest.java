package br.com.caelum.gash.booking.features.payment;

import java.time.ZonedDateTime;

class PaymentRequest {
    private Long bookingId;
    private ZonedDateTime start;

    public PaymentRequest(Long bookingId, ZonedDateTime start) {
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
