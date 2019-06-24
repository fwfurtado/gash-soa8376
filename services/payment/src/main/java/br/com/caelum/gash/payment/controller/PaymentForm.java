package br.com.caelum.gash.payment.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

class PaymentForm {

    @NotNull
    private Long bookingId;

    @NotNull
    @Future
    private ZonedDateTime start;

    public Long getBookingId() {
        return bookingId;
    }

    public ZonedDateTime getStart() {
        return start;
    }
}
