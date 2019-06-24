package br.com.caelum.gash.booking.shared.exception;

import br.com.caelum.gash.booking.shared.domain.Booking;

public class BookingCannotBePayedException extends IllegalStateException {

    public BookingCannotBePayedException(Booking booking) {
        super(String.format("Cannot be payed booking in status '%s'", booking.getStatus()));
    }
}
