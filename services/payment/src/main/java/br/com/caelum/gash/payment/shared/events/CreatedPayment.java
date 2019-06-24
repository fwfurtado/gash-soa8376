package br.com.caelum.gash.payment.shared.events;

import java.time.ZonedDateTime;
import java.util.UUID;

public class CreatedPayment {

    private UUID id;
    private ZonedDateTime time;

    public CreatedPayment(UUID id, ZonedDateTime time) {
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
