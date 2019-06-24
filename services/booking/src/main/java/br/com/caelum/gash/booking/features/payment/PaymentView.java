package br.com.caelum.gash.booking.features.payment;

import java.time.ZonedDateTime;
import java.util.UUID;

class PaymentView {

    private UUID id;
    private ZonedDateTime time;

    @Deprecated
    private PaymentView() {
    }

    public PaymentView(UUID id, ZonedDateTime time) {
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
