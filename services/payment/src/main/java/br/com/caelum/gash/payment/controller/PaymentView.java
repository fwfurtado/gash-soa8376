package br.com.caelum.gash.payment.controller;

import java.time.ZonedDateTime;
import java.util.UUID;

class PaymentView {

    private final UUID id;
    private final ZonedDateTime time;

    PaymentView(UUID id, ZonedDateTime time) {

        this.id = id;
        this.time = time;
    }

    public UUID getId() {
        return id;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
