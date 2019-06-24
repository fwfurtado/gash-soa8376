package br.com.caelum.gash.booking.features.register;

import java.time.ZonedDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;

class BookingForm {

    @NotNull
    private Long customerId;

    @NotNull
    private Long garageId;

    @NotNull
    @Future
    private ZonedDateTime start;

    @NotNull
    @Future
    private ZonedDateTime end;

    public Long getCustomerId() {
        return customerId;
    }

    public Long getGarageId() {
        return garageId;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }
}
