package br.com.caelum.gash.booking.shared.exception;

public class BookingNotFoundException extends IllegalArgumentException {

    private final Long bookingId;

    public BookingNotFoundException(Long id) {
        super(String.format("Cannot find booking with id '%s'", id));
        this.bookingId = id;

    }

    public Long getBookingId() {
        return bookingId;
    }
}
