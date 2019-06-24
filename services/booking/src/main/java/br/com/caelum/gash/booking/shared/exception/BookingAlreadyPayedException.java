package br.com.caelum.gash.booking.shared.exception;

public class BookingAlreadyPayedException extends IllegalStateException {

    public BookingAlreadyPayedException(Long id) {
        super(String.format("Booking with id '%s' is already payed", id));
    }
}
