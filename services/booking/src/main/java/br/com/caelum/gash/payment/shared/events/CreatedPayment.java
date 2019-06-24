package br.com.caelum.gash.payment.shared.events;

import java.time.ZonedDateTime;
import java.util.StringJoiner;
import java.util.UUID;

public class CreatedPayment {

    private UUID id;
    private ZonedDateTime time;

    public UUID getId() {
        return id;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CreatedPayment.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("time=" + time)
            .toString();
    }
}
